package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Task;

public class TaskUI implements ActionListener {
	static JFrame frmTask;
	static Container paneTask;
	static JPanel pnlTask;
	static JButton btnSave, btnDelete, btnCancel;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	ButtonGroup impgroup = new ButtonGroup();
	ButtonGroup prioritygroup = new ButtonGroup();
	JRadioButton r1, r2, r3, r4;
	DateFormat format = new SimpleDateFormat("mm-dd-yyyy");
	JComboBox<String> c;
	List<String> Goals = new ArrayList<String>();

	public void actionPerformed(ActionEvent e) {
		frmTask = new JFrame("Task");
		JTextField t1, t2, t3, t4, t5, t6, t7, t8;
		frmTask.setSize(600, 600);
		paneTask = frmTask.getContentPane();
		paneTask.setLayout(null);
		pnlTask = new JPanel(null);
		paneTask.add(pnlTask);
		frmTask.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try (BufferedReader br = new BufferedReader(new FileReader("src/goals.csv"))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				if (!Goals.contains(sCurrentLine))
					Goals.add(sCurrentLine);
			}

			l1 = new JLabel("Title");
			l1.setBounds(50, 70, 100, 30);
			l2 = new JLabel("Description");
			l2.setBounds(50, 100, 100, 30);
			l3 = new JLabel("Is important");
			l3.setBounds(50, 125, 100, 30);
			l4 = new JLabel("Is urgent");
			l4.setBounds(50, 145, 100, 30);
			l5 = new JLabel("Start Date");
			l5.setBounds(50, 175, 100, 30);
			l7 = new JLabel("Choose Goal");
			l7.setBounds(50, 40, 100, 30);

			l6 = new JLabel("End date");
			l6.setBounds(50, 210, 100, 30);
			pnlTask.add(l1);
			pnlTask.add(l2);
			pnlTask.add(l3);
			pnlTask.add(l4);
			pnlTask.add(l5);
			pnlTask.add(l6);
			pnlTask.add(l7);

			c = new JComboBox<String>();
			c.setBounds(150, 40, 200, 30);
			pnlTask.add(c);
			for (int i = 0; i < Goals.size(); i++)
				c.addItem(Goals.get(i));
			t1 = new JTextField();
			t1.setBounds(150, 70, 200, 30);
			t2 = new JTextField();
			t2.setBounds(150, 100, 200, 30);
			pnlTask.add(t1);
			pnlTask.add(t2);
			r1 = new JRadioButton("Yes");
			r2 = new JRadioButton("No");
			impgroup.add(r1);
			impgroup.add(r2);
			r3 = new JRadioButton("Yes");
			r4 = new JRadioButton("No");
			prioritygroup.add(r3);
			prioritygroup.add(r4);
			r1.setBounds(150, 125, 100, 30);
			r2.setBounds(225, 125, 100, 30);
			r3.setBounds(150, 145, 100, 30);
			r4.setBounds(225, 145, 100, 30);
			ButtonGroup bg1 = new ButtonGroup();
			ButtonGroup bg2 = new ButtonGroup();
			bg1.add(r1);
			bg1.add(r2);
			bg2.add(r3);
			bg2.add(r4);
			pnlTask.add(r1);
			pnlTask.add(r2);
			pnlTask.add(r3);
			pnlTask.add(r4);

			t3 = new JTextField();
			t3.setBounds(150, 175, 35, 30);
			t4 = new JTextField();
			t4.setBounds(180, 175, 35, 30);
			t5 = new JTextField();
			t5.setBounds(210, 175, 50, 30);

			pnlTask.add(t3);
			pnlTask.add(t4);
			pnlTask.add(t5);

			t6 = new JTextField();
			t6.setBounds(150, 210, 35, 30);
			t7 = new JTextField();
			t7.setBounds(180, 210, 35, 30);
			t8 = new JTextField();
			t8.setBounds(210, 210, 50, 30);
			pnlTask.add(t6);
			pnlTask.add(t7);
			pnlTask.add(t8);

			btnSave = new JButton("Save");
			btnDelete = new JButton("Delete");
			btnCancel = new JButton("Cancel");
			btnSave.setBounds(50, 250, 66, 25);
			btnDelete.setBounds(150, 250, 66, 25);
			btnCancel.setBounds(250, 250, 66, 25);
			pnlTask.add(btnSave);
			pnlTask.add(btnDelete);
			pnlTask.add(btnCancel);

			pnlTask.setBorder(BorderFactory.createTitledBorder("Task"));
			pnlTask.setBounds(100, 100, 400, 310);

			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmTask.dispose();
				}
			});

			btnSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addTasks(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()), Integer.parseInt(t7.getText()), Integer.parseInt(t8.getText()), r1.isSelected(), r3.isSelected(), getIDCount(), 1,
							"tempgoaldesc", 0);
					/*Task task;
					task = new Task(t1.getText(), t2.getText(), 0, 0, r1.isSelected(), r3.isSelected(), 0, 0,
							"tempgoaldesc", 0);*/
					FileWriter fileWriter;
					try {
						/*fileWriter = new FileWriter("src/tasks.csv", true);
						BufferedWriter br = new BufferedWriter(fileWriter);
						br.write(task.getTitle() + "\t" + task.getDescription() + "\t" + task.getStartDate() + "\t"
								+ task.getEndDate() + "\t" + task.getImportant() + "\t" + task.getPriority() + "\t"
								+ "0" + "\t" + "0" + task.getGoalDescription() + "\t" + task.getGoalID() + "\n");
						System.out.println("task updated");
						br.close();
						frmTask.dispose();*/
						fileWriter = new FileWriter("src/tasks.csv", true);
						BufferedWriter br = new BufferedWriter(fileWriter);
						for(int i = 0; i < allTasks.size(); i++) {
							Task task = allTasks.get(i);
							br.write(task.getTitle() + "\t" + task.getDescription() + "\t" + task.getStartDate() + "\t"
									+ task.getEndDate() + "\t" + task.getUrgent() + "\t" + task.getImportant() + "\t"
									+ task.getID() + "\t" + task.getTaskNum() + task.getGoalDescription() + "\t" + task.getGoalID() + "\n");
						}
						System.out.println("task updated");
						br.close();
						frmTask.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			});

			frmTask.setResizable(false);
			frmTask.setVisible(true);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	private static int idCount;
	private static ArrayList<Task> allTasks = new ArrayList<Task>(); //the .csv file loads to and saves from this
	
	public static int getIDCount() {
		int temp = idCount;
		idCount++;
		return temp;
	}
	
	public static void addTasks(String titl, String desc, int sMonth, int sDay, int sYear, int eMonth, int eDay, int eYear, boolean urg, boolean imp, int id, int fT, String goalDesc, int gID) {
		Task temp = new Task(titl, desc, convertDate(sMonth, sDay, sYear), convertDate(eMonth, eDay, eYear), urg, imp, id, fT, goalDesc, gID);
		createTasks(temp);
	}
	
	public static int convertDate(int Month, int Day, int Year) {//converts dates fields into an int
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.MONTH, Month);
		gc.set(GregorianCalendar.DAY_OF_MONTH, Day);
	    gc.set(GregorianCalendar.YEAR, Year);
	    
	    return gc.get(GregorianCalendar.DAY_OF_YEAR);
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
	
	public static void updateTask(Task oldTask, Task newTask) { //takes old task and new task, deletes old task, adds new task
		deleteTasks(oldTask);
		//addTasks(newTask);
	}
	
	public static void printTasks() { //today = 0
		for(int i = 1; i < 10; i++) {//for each day (only 10 here)
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
}
