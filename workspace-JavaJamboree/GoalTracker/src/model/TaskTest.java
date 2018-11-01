package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskTest {
	
	public static void main(String[] args) {
		
		makeArray();
		String s1 = "GOOD title";
		String s2 = "GOOD decription";
		int sD = 1;
		int eD = 2;
		boolean urg = true;
		boolean imp = false;
		final int firstTask = 1;
		
		Task task1 = new Task(s1, s2, sD, eD, urg, imp, config.Config.getIDCount(), firstTask);
		createTasks(task1);
		getSize();
		
		System.out.println("");
		Task task2 = new Task(s1, s2, sD, eD + 4, urg, imp, config.Config.getIDCount(), firstTask);
		createTasks(task2);
		getSize();
	}//end of Main
	
	private static int idCount;
	private static ArrayList<Task> taskList = new ArrayList<Task>();
	
	public static void makeArray() {
		int count = 0;
		Map<Integer, ArrayList<Task>> all = new HashMap<>(365);
		count++;
		all.put(count, null);
	}
	
	public int getIDCount() {
		int temp = idCount;
		idCount++;
		return temp;
	}
	
	public static void createTasks(Task task) {
		if(task.getNumDays() == 1) { //only one day left
			taskList.add(task);
		}
		else { //not last day
			taskList.add(task);
			
			Task temp = new Task(task.getTitle(), task.getDescription(), task.getStartDate() + 1, 
					task.getEndDate(), task.getUrgent(), task.getImportant(), task.getID(), task.getTaskNum() + 1);
			createTasks(temp);
		}
	}
	
	public static void getSize() {
		System.out.println("");
		System.out.println("Array Size: " + taskList.size());
	}
}
