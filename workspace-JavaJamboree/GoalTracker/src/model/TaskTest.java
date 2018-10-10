package model;

public class TaskTest {
	
	public static void main(String[] args) {
		
		String s1 = "GOOD title";
		String s2 = "GOOD decription";
		int sD = 1;
		int eD = 2;
		boolean urg = true;
		boolean imp = false;
		
		Task task1 = new Task(s1, s2, sD, eD, urg, imp, config.Config.getIDCount());
		System.out.println("Task 2");
		Task task2 = new Task(s1, s2, sD, eD, urg, imp, config.Config.getIDCount());
	}
}
