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
	
	/**
	 * A constructor.
	 * Sets the various global variables.
	 * @param titl a String title.
	 * @param desc a String description.
	 * @param sDate the int start date.
	 * @param eDate the int end date.
	 * @param urg the boolean urgency.
	 * @param imp the boolean importance.
	 * @param id the int task ID.
	 * @param fT (first task) the int task number.
	 * @param goalDesc the String goal description.
	 * @param gID the int goal ID.
	 */
	public Task(String titl, String desc, int sDate, int eDate, boolean urg, boolean imp, int id, int fT, String goalDesc, int gID) {
		setTitle(titl);
		setDescription(desc);

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
		
		/*System.out.println(title);
		//System.out.println(description);
		System.out.println("StartDate is " + startDate);
		System.out.println("EndDate is " + endDate);
		System.out.println("Urgent is " + urgent);
		System.out.println("Important is " + important);
		System.out.println("ID is " + ID);
		System.out.println("NumDays is " + numDays);
		System.out.println("Priority is " + priority);
		System.out.println("Task num is " + taskNum);
		//System.out.println(goalDescription);
		//System.out.println("Goal ID is " + goalID);
		System.out.println("");*/
	}
	
	/**
	 * Sets the title.
	 * @param titl the String title.
	 */
	private void setTitle(String titl) {
		title = titl;
	}
	
	/**
	 * Gets the title.
	 * @return the String title.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the description.
	 * @param desc the String description.
	 */
	private void setDescription(String desc) {
		description = desc;
	}
	
	/**
	 * Gets the description.
	 * @return the String description.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the start date.
	 * @param sDate the int start date.
	 */
	private void setStartDate(int sDate) {
		startDate = sDate;
	}
	
	/**
	 * Gets the start date.
	 * @return the int start date.
	 */
	public int getStartDate() {
		return startDate;
	}
	
	/**
	 * Sets the end date.
	 * @param eDate the int end date.
	 */
	private void setEndDate(int eDate) {
		endDate = eDate;
	}
	
	/**
	 * Gets the end date.
	 * @return the int end date.
	 */
	public int getEndDate(){
		return endDate;
	}
	
	/**
	 * Sets the urgency.
	 * @param urg the boolean urgency.
	 */
	private void setUrgent(boolean urg) {
		urgent = urg;
	}
	
	/**
	 * Gets the urgency.
	 * @return the boolean urgency.
	 */
	public boolean getUrgent() {
		return urgent;
	}
	
	/**
	 * Sets the importance.
	 * @param imp the boolean importance.
	 */
	private void setImportant(boolean imp) {
		important = imp;
	}
	
	/**
	 * Gets the importance.
	 * @return the boolean importance.
	 */
	public boolean getImportant() {
		return important;
	}
	
	/**
	 * Sets the task ID.
	 * @param id the int task ID.
	 */
	private void setID(int id) {
		ID = id;
	}
	
	/**
	 * Gets the task ID.
	 * @return the int task ID.
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Sets the task number.
	 * @param fT the int task number.
	 */
	private void setTaskNum(int fT) {
		taskNum = fT;
	}
	
	/**
	 * Gets the task number.
	 * @return the int task number.
	 */
	public int getTaskNum() {
		return taskNum;
	}
	
	/**
	 * Sets the goal description.
	 * @param goalDesc the String goal description.
	 */
	private void setGoalDescription(String goalDesc) {
		goalDescription = goalDesc;
	}
	
	/**
	 * Gets the goal description.
	 * @return the String goal description.
	 */
	public String getGoalDescription() {
		return goalDescription;
	}
	
	/**
	 * Sets the goal ID.
	 * @param gID the int goal ID.
	 */
	private void setGoalID(int gID) {
		goalID = gID;
	}
	
	/**
	 * Gets the goal ID.
	 * @return the int goal ID.
	 */
	public int getGoalID() {
		return goalID;
	}
	
	/**
	 * Sets the number if days.
	 * @param sDate the int start date.
	 * @param eDate the int end date.
	 */
	private void setNumDays(int sDate, int eDate) {
		numDays = eDate - sDate;
	}
	
	/**
	 * Gets the number of days.
	 * @return the int number of days.
	 */
	public int getNumDays() {
		return numDays;
	}
	
	/**
	 * Sets priority.
	 * @param urg the boolean urgency.
	 * @param imp the boolean importance.
	 */
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
	
	/**
	 * Gets the priority.
	 * @return the boolean priority.
	 */
	public int getPriority() {
		return priority;
	}
}
