package config;

import java.util.ArrayList;

import model.Task;

public class Config {
	
	private static int idCount = 0;
	private static ArrayList<Task> taskList = new ArrayList<Task>();
	
	public static int getIDCount() {
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
