/**
 * 
 */
package com.manosoft.design.observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author manohar_mandadi
 *
 */
public class Pool extends Thread implements Observer {

	private List<Subject> subjectList = new ArrayList<Subject>(); 
	private String poolName;
	private final int maxPoolSize = 4;
	
	private boolean poolActive = false;

	private Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("IST"), Locale.ENGLISH);
	
	public Pool(String name) {
		this.poolName = name;
	}
	
	@Override
	public void subscribe(Subject subject) {
		poolActive = true;
		if(subjectList.size() < maxPoolSize){
			subjectList.listIterator().add(subject);
			System.out.println(subject +"subscribed to Pool :"+calendar.getTime());
		} else {
			
			System.out.println("Pool subscription is closed. Cant add "+subject+" to pool ");
		}
	}
	
	@Override
	public void unSubscribe(Subject subject) {
		if(subjectList.size() > 0){
			ListIterator<Subject> listIterator = subjectList.listIterator();
			boolean removed = false;
			while(listIterator.hasNext() && !removed){
				if(listIterator.next()==subject){
					listIterator.remove();
					System.out.println(subject +"UnSubscribed to Pool :"+calendar.getTime());
					removed = true;
				}
			}
			if(!removed){
				System.out.println(subject +"not found in Pool ");
			} else {
				if(subjectList.isEmpty()){
					poolActive = false;
				}
			}
		} else {
			System.out.println("Pool is closed. ");
		}
		
	}
	
	@Override
	public void run() {
		while(poolActive){
			rotatePool(subjectList);
		}
	}
	
	public void rotatePool(List<Subject> poolSubjects){
		Iterator<Subject> iterator = poolSubjects.listIterator();
		while(iterator.hasNext()){
			int date = calendar.get(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, date+1);
			updateSubjects(iterator.next(), poolSubjects);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void updateSubjects(Subject currSubject, List<Subject> poolSubjects){
		
		Iterator<Subject> iterator = poolSubjects.listIterator();
		while(iterator.hasNext()){
			Subject subject = iterator.next();
			subject.update(currSubject);
		}
		System.out.println("Completed Pool turn for :"+currSubject+ " on "+ calendar.getTime());
	}
	
	@Override
	public String toString() {
		return poolName;
	}
}
