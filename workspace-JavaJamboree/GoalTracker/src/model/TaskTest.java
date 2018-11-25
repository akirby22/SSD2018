package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskTest {
	
	public static void main(String[] args) {
		
		String s1 = "GOOD title";
		String s2 = "GOOD decription";
		int sD = 1;
		int eD = 2;
		boolean urg = true;
		boolean imp = false;
		final int firstTask = 1;
		String s3 = "GOOD GOAL";
		int goalID = 1;
		
		Task task1 = new Task("Task 1", s2, 1, 3, urg, imp, getIDCount(), firstTask, s3, goalID);
		addTasks(task1);
		//getSize();
		
		Task task2 = new Task("Task 2", s2, 1, 7, true, true, getIDCount(), firstTask, s3, goalID);
		addTasks(task2);
		//getSize();
		
		Task task3 = new Task("Task 3", s2, 3, 5, false, true, getIDCount(), firstTask, s3, goalID);
		addTasks(task3);
		//getSize();
		
		Task task4 = new Task("Task 4", s2, 4, 8, false, false, getIDCount(), firstTask, s3, goalID);
		addTasks(task4);
		//getSize();
		
		Task task5 = new Task("task 5", s2, 2, 9, urg, imp, getIDCount(), firstTask, s3, goalID);
		addTasks(task5);
		//getSize();
		
		printTasks();

	}
	//************************************END OF MAIN************************************************************
	
	private static int idCount;
	private static ArrayList<Task> allTasks = new ArrayList<Task>(); //the .csv file loads to and saves from this
	
	public static int getIDCount() {
		int temp = idCount;
		idCount++;
		return temp;
	}
	
	public static void addTasks(Task task) {
		allTasks.add(task);
		
		if(task.getNumDays() != 0) { //not last day
			Task temp = new Task(task.getTitle(), task.getDescription(), task.getStartDate() + 1, 
					task.getEndDate(), task.getUrgent(), task.getImportant(), task.getID(), task.getTaskNum() + 1, task.getGoalDescription(), task.getGoalID());
			addTasks(temp);
		}
	}
	
	public static void deleteTasks(Task task) {//takes the task to be deleted and deletes all instances of that task
		int taskID = task.getID();
		for(int i = allTasks.size() - 1; i >= 0; i--) { //starts at end and goes towards 0
			if(allTasks.get(i).getID() == taskID) {
				allTasks.remove(i);
			}
		}
	}
	
	public static void updateTask(Task oldTask, Task newTask) { //takes old task and new task, deletes old task, adds new task
		deleteTasks(oldTask);
		addTasks(newTask);
	}
	
	public static void printTasks() { //today = 0
		for(int i = 0; i < 10; i++) {//for each day (only 10 here)
			System.out.println("Day " + i);
			for(int j = 1; j < 5; j++) {//for each priority
				System.out.println("Priority " + j);
				for(int k = 0; k < allTasks.size(); k++) {//go through each task in allTasks
					Task temp = allTasks.get(k);
					if(temp.getStartDate() == i && temp.getPriority() == j) {
						System.out.println(temp.getTitle());
					}
				}
				System.out.println("");
			}
			System.out.println("----------------------------");
		}
	}
	
	public static void getSize() { // just for testing purposes
		System.out.println("");
		System.out.println("Array Size: " + allTasks.size());
		/*for(int i = 0; i < allTasks.size(); i++) {
			System.out.println("ID is " + allTasks.get(i).getID());
		}*/
	}
	
}
