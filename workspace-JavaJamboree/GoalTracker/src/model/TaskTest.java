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
		
		Task task1 = new Task(s1, s2, sD, eD, urg, imp, getIDCount(), firstTask, s3, goalID);
		createTasks(task1);
		getSize();
		
		System.out.println("");
		Task task2 = new Task(s1, s2, sD, eD + 4, urg, imp, getIDCount(), firstTask, s3, goalID);
		createTasks(task2);
		getSize();
		deleteTasks(task2);
		getSize();
	}
	//************************************END OF MAIN************************************************************
	
	private static int idCount;
	private static ArrayList<Task> allTasks = new ArrayList<Task>(); //the .csv file loads to and saves from this
	
	public static int getIDCount() {
		int temp = idCount;
		idCount++;
		return temp;
	}
	
	public static void createTasks(Task task) {
		allTasks.add(task);
		
		if(task.getNumDays() != 0) { //not last day
			Task temp = new Task(task.getTitle(), task.getDescription(), task.getStartDate() + 1, 
					task.getEndDate(), task.getUrgent(), task.getImportant(), task.getID(), task.getTaskNum() + 1, task.getGoalDescription(), task.getGoalID());
			createTasks(temp);
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
	
	public static void getSize() { // just for testing purposes
		System.out.println("");
		System.out.println("Array Size: " + allTasks.size());
		/*for(int i = 0; i < allTasks.size(); i++) {
			System.out.println("ID is " + allTasks.get(i).getID());
		}*/
	}
	
	/*public static void putIntoHash() {
		Integer index = 0;
		for(int i = 0; i < allTasks.size(); i++) {
			index = allTasks.get(i).getStartDate();
			all.put(index, allTasks.get(i));
			System.out.println(all.get(index));
		}
	}*/
	//private static Map<Integer, Object> all = new HashMap<>(365); //this is what will sort into days
	//private static Map<Object, ArrayList<Object>> multiMap = new HashMap<>();
	
	/*private static void fillHash() {
		ArrayList<Task> d0 = new ArrayList<Task>();
		all.put(0, d0);
		ArrayList<Task> d1 = new ArrayList<Task>();
		all.put(0, d1);
		ArrayList<Task> d2 = new ArrayList<Task>();
		all.put(0, d2);
		ArrayList<Task> d3 = new ArrayList<Task>();
		all.put(0, d3);
		ArrayList<Task> d4 = new ArrayList<Task>();
		all.put(0, d4);
		ArrayList<Task> d5 = new ArrayList<Task>();
		all.put(0, d5);
		ArrayList<Task> d6 = new ArrayList<Task>();
		all.put(0, d6);
		ArrayList<Task> d7 = new ArrayList<Task>();
		all.put(0, d7);
		ArrayList<Task> d8 = new ArrayList<Task>();
		all.put(0, d8);
		ArrayList<Task> d9 = new ArrayList<Task>();
		all.put(0, d9);
	}*/
	
	/*public static void makeArray() { //this is what will sort into days
		int count = 0;
		Map<Integer, ArrayList<Task>> all = new HashMap<>(365);
		count++;
		all.put(count, null);
	}*/
}
