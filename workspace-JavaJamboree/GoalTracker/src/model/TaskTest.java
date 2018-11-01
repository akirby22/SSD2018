package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskTest {
	
	public static void main(String[] args) {
		
		//ArrayList<ArrayList<Task>> group = new ArrayList<ArrayList<Task>>(365);
		
		int count = 1;
		Map <Integer, ArrayList<Task>> tasks = new HashMap<>();
		while(count < 10) {
			tasks.put(count, null);
		}
		
		String s1 = "GOOD title";
		String s2 = "GOOD decription";
		int sD = 1;
		int eD = 2;
		boolean urg = true;
		boolean imp = false;
		final int firstTask = 1;
		
		Task task1 = new Task(s1, s2, sD, eD, urg, imp, config.Config.getIDCount(), firstTask);
		config.Config.createTasks(task1);
		config.Config.getSize();
		
		System.out.println("");
		Task task2 = new Task(s1, s2, sD, eD + 4, urg, imp, config.Config.getIDCount(), firstTask);
		config.Config.createTasks(task2);
		config.Config.getSize();
	}
}
