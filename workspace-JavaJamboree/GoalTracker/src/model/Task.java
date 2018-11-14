package model;

import java.util.Date;
import org.joda.time.LocalDate;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class Task {
	
	private String title;
	private String description;
	//private LocalDate startDate;
	//private LocalDate endDate;
	private int startDate;
	private int endDate;
	private boolean urgent;
	private boolean important;
	private int ID;
	private int taskNum;
	private String goalDescription;
	private int goalID;
	
	private int numDays;
	private int priority;
	
	public Task(String titl, String desc, int sDate, int eDate, boolean urg, boolean imp, int id, int fT, String goalDesc, int gID) {
		setTitle(titl);
		setDescription(desc);
		//setStartDate(sDate);
		//setEndDate(eDate);
		setStartDate(sDate);
		setEndDate(eDate);
		setUrgent(urg);
		setImportant(imp);
		setID(id);
		setTaskNum(fT);
		setGoalDescription(goalDesc);
		setGoalID(gID);
		
		setNumDays(sDate, eDate);
		setPriority(urg, imp);
		
		System.out.println(title);
		System.out.println(description);
		System.out.println("StartDate is " + startDate);
		System.out.println("EndDate is " + endDate);
		System.out.println("Urgent is " + urgent);
		System.out.println("Important is " + important);
		System.out.println("ID is " + ID);
		System.out.println("NumDays is " + numDays);
		System.out.println("Priority is " + priority);
		System.out.println("Task num is " + taskNum);
		System.out.println(goalDescription);
		System.out.println("Goal ID is " + goalID);
		System.out.println("");
	}
	
	private void setTitle(String titl) {
		title = titl;
	}
	
	public String getTitle() {
		return title;
	}
	
	private void setDescription(String desc) {
		description = desc;
	}
	
	public String getDescription() {
		return description;
	}
	
	/*private void setStartDate(LocalDate sDate) {
		startDate = sDate;
	}*/
	private void setStartDate(int sDate) {
		startDate = sDate;
	}
	
	/*public LocalDate getStartDate() {
		return startDate;
	}*/
	public int getStartDate() {
		return startDate;
	}
	
	/*private void setEndDate(LocalDate eDate) {
		endDate = eDate;
	}*/
	private void setEndDate(int eDate) {
		endDate = eDate;
	}
	
	/*public LocalDate getEndDate() {
		return endDate;
	}*/
	public int getEndDate(){
		return endDate;
	}
	
	private void setUrgent(boolean urg) {
		urgent = urg;
	}
	
	public boolean getUrgent() {
		return urgent;
	}
	
	private void setImportant(boolean imp) {
		important = imp;
	}
	
	public boolean getImportant() {
		return important;
	}
	
	private void setID(int id) {
		ID = id;
	}
	
	public int getID() {
		return ID;
	}
	
	private void setTaskNum(int fT) {
		taskNum = fT;
	}
	
	public int getTaskNum() {
		return taskNum;
	}
	
	private void setGoalDescription(String goalDesc) {
		goalDescription = goalDesc;
	}
	
	public String getGoalDescription() {
		return goalDescription;
	}
	
	private void setGoalID(int gID) {
		goalID = gID;
	}
	
	public int getGoalID() {
		return goalID;
	}
	
	/*private void setNumDays(LocalDate sDate, LocalDate eDate) {
		numDays = Days.daysBetween(sDate, eDate).getDays();
	}*/
	private void setNumDays(int sDate, int eDate) {
		numDays = eDate - sDate;
	}
	
	public int getNumDays() {
		return numDays;
	}
	
	private void setPriority(boolean urg, boolean imp) {
		int pri;
		
		if (urg) {
			if(imp) {
				pri = 1; //urgent, important
			}
			else {
				pri = 2; //urgent, not important
			}
		}
		else {
			if (imp) {
				pri = 3; //not urgent, important
			}
			else {
				pri = 4; //not urgent, not important
			}
		}
		priority = pri;
	}
	
	public int getPriority() {
		return priority;
	}
}
