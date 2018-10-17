package model;

public class TaskTest {
	
	public static void main(String[] args) {
		
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
