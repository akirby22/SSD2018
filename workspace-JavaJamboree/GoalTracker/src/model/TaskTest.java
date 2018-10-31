package model;

import java.util.ArrayList;

public class TaskTest {
	
	public static void main(String[] args) {
		
		ArrayList<Task> year = new ArrayList<Task>(365);
		
		int count = 0;
		String temp = "";
		while(count < 10) {
			temp = "day" + count;
			System.out.println(temp);
			ArrayList<Task> day = new ArrayList<Task>();
			count++;
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
