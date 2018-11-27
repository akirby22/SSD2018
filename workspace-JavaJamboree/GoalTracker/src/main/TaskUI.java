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
	private ArrayList<Task> allTasks = new ArrayList<Task>();
	private int idCount;

	/**
	 * Task screen GUI.
	 * 
	 * @throws IOException
	 */

	TaskUI() throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/tasks.csv"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] task = sCurrentLine.split("\t");
				allTasks.add(new Task(task[0], task[1], Integer.parseInt(task[2]), Integer.parseInt(task[3]),
						Boolean.valueOf(task[4]), Boolean.valueOf(task[5]), Integer.parseInt(task[6]),
						Integer.parseInt(task[7]), task[8], Integer.parseInt(task[9])));
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

		}
	}

	// the .csv
	// file
	// loads
	// to
	// and
	// saves
	// from
	// this

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
				if (!Goals.contains(sCurrentLine)) {
					String[] goal = sCurrentLine.split("\t");
					Goals.add(goal[0]);
				}
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
			r1.setBounds(150, 125, 100, 30);
			r2.setBounds(225, 125, 100, 30);
			r3 = new JRadioButton("Yes");
			r4 = new JRadioButton("No");
			prioritygroup.add(r3);
			prioritygroup.add(r4);
			r3.setBounds(150, 145, 100, 30);
			r4.setBounds(225, 145, 100, 30);
			// ButtonGroup bg1 = new ButtonGroup();
			// ButtonGroup bg2 = new ButtonGroup();
			// bg1.add(r1);
			// bg1.add(r2);
			// bg2.add(r3);
			// bg2.add(r4);
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

			/**
			 * Closes task screen.
			 */
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmTask.dispose();
				}
			});

			/**
			 * Saves entered data into allTasks ArrayList and into csv file.
			 */
			btnSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addTasks(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()),
							Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText()),
							Integer.parseInt(t7.getText()), Integer.parseInt(t8.getText()), r1.isSelected(),
							r3.isSelected(), getIDCount(), 1, (String) c.getSelectedItem(), 0);
					FileWriter fileWriter;
					try {
						fileWriter = new FileWriter("src/tasks.csv", true);
						BufferedWriter br = new BufferedWriter(fileWriter);
						for (int i = 0; i < allTasks.size(); i++) {
							Task task = allTasks.get(i);
							br.write(task.getTitle() + "\t" + task.getDescription() + "\t" + task.getStartDate() + "\t"
									+ task.getEndDate() + "\t" + task.getUrgent() + "\t" + task.getImportant() + "\t"
									+ task.getID() + "\t" + task.getTaskNum() + "\t" + task.getGoalDescription() + "\t"
									+ task.getGoalID() + "\n");
						}
						System.out.println("task added");
						br.close();
						frmTask.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}
			});

			/**
			 * Deletes all instances of the displayed task.
			 */
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Enter code here to send task to deleteTasks(Task task)
					FileWriter fileWriter;
					try {
						fileWriter = new FileWriter("src/tasks.csv");
						BufferedWriter br = new BufferedWriter(fileWriter);
						for (int i = 0; i < allTasks.size(); i++) {
							Task task = allTasks.get(i);
							br.write(task.getTitle() + "\t" + task.getDescription() + "\t" + task.getStartDate() + "\t"
									+ task.getEndDate() + "\t" + task.getUrgent() + "\t" + task.getImportant() + "\t"
									+ task.getID() + "\t" + task.getTaskNum() + task.getGoalDescription() + "\t"
									+ task.getGoalID() + "\n");
						}
						System.out.println("task deleted");
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

	/**
	 * Gets the generated unique task ID.
	 * 
	 * @return the int task ID.
	 */
	public int getIDCount() {
		int temp = idCount;
		idCount++;
		return temp;
	}

	/**
	 * Converts the info from start and end dates and creates tasks.
	 * 
	 * @param titl
	 *            a String title.
	 * @param desc
	 *            a String description.
	 * @param sMonth
	 *            an int starting month.
	 * @param sDay
	 *            an int starting day.
	 * @param sYear
	 *            an int starting year.
	 * @param eMonth
	 *            an int ending month.
	 * @param eDay
	 *            an int ending day.
	 * @param eYear
	 *            and int ending year.
	 * @param urg
	 *            a boolean urgency.
	 * @param imp
	 *            a boolean importance.
	 * @param id
	 *            and int task ID.
	 * @param fT
	 *            and int task number.
	 * @param goalDesc
	 *            a String description.
	 * @param gID
	 *            an int goal ID.
	 */
	public void addTasks(String titl, String desc, int sMonth, int sDay, int sYear, int eMonth, int eDay, int eYear,
			boolean urg, boolean imp, int id, int fT, String goalDesc, int gID) {
		Task temp = new Task(titl, desc, convertDate(sMonth, sDay, sYear), convertDate(eMonth, eDay, eYear), urg, imp,
				id, fT, goalDesc, gID);
		createTasks(temp);
	}

	/**
	 * Converts the given month, day, and year into the day if the year 1-365.
	 * 
	 * @param Month
	 *            an int.
	 * @param Day
	 *            an int.
	 * @param Year
	 *            an int.
	 * @return an int day of year.
	 */
	public int convertDate(int Month, int Day, int Year) {// converts
															// dates
															// fields
															// into an
															// int
		GregorianCalendar gc = new GregorianCalendar();
		switch (Month) {
		case 1:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
			;
			break;
		case 2:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.FEBRUARY);
			break;
		case 3:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.MARCH);
			break;
		case 4:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.APRIL);
			break;
		case 5:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.MAY);
			break;
		case 6:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.JUNE);
			break;
		case 7:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.JULY);
			break;
		case 8:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.AUGUST);
			break;
		case 9:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.SEPTEMBER);
			break;
		case 10:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.OCTOBER);
			break;
		case 11:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.NOVEMBER);
			break;
		case 12:
			gc.set(GregorianCalendar.MONTH, GregorianCalendar.DECEMBER);
			break;
		default:
			break;
		}
		gc.set(GregorianCalendar.DAY_OF_MONTH, Day);
		gc.set(GregorianCalendar.YEAR, Year);

		return gc.get(GregorianCalendar.DAY_OF_YEAR);
	}

	/**
	 * Creates a task for each day the task is present.
	 * 
	 * @param task
	 *            a Task object.
	 */
	public void createTasks(Task task) {
		allTasks.add(task);

		if (task.getNumDays() != 0) { // not last day
			Task temp = new Task(task.getTitle(), task.getDescription(), task.getStartDate() + 1, task.getEndDate(),
					task.getUrgent(), task.getImportant(), task.getID(), task.getTaskNum() + 1,
					task.getGoalDescription(), task.getGoalID());
			createTasks(temp);
		}
	}

	/**
	 * Deletes all instances of a task.
	 * 
	 * @param task
	 *            a Task object.
	 */
	public void deleteTasks(Task task) {// takes the task to be deleted
										// and deletes all instances of
										// that task
		int taskID = task.getID();
		for (int i = allTasks.size() - 1; i >= 0; i--) { // starts at end and
															// goes towards 0
			if (allTasks.get(i).getID() == taskID) {
				allTasks.remove(i);
			}
		}
	}

	public void updateTask(Task oldTask, Task newTask) { // takes old
															// task and new
															// task, deletes
															// old task,
															// adds new task
		deleteTasks(oldTask);
		// addTasks(newTask);
	}

	/*
	 * public static void printTasks() { //today = 0 for(int i = 1; i < 10; i++)
	 * {//for each day (only 10 here) System.out.println("Day " + i); for(int j
	 * = 1; j < 5; j++) {//for each priority System.out.println("Priority " +
	 * j); for(int k = 0; k < allTasks.size(); k++) {//go through each task in
	 * allTasks Task temp = allTasks.get(k); if(temp.getStartDate() == i &&
	 * temp.getPriority() == j) { System.out.println(temp.getTitle()); } }
	 * System.out.println(""); }
	 * System.out.println("----------------------------"); } }
	 */

	/**
	 * Fills the day.csv file.
	 * 
	 * @param day
	 *            an int.
	 * @param month
	 *            an int.
	 * @param year
	 *            an int.
	 */
	public void fillList(int day, int month, int year) {
		int clickedDay = day + convertDate(month, 1, year);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("src/day.csv", false);
			BufferedWriter br = new BufferedWriter(fileWriter);
			System.out.println(allTasks.size());
			for (int i = 0; i < allTasks.size(); i++) {
				Task task = allTasks.get(i);
				for (int j = 1; j < 5; j++) {
					if (task.getStartDate() == clickedDay && task.getPriority() == j) {
						br.write(task.getTitle() + "\t" + task.getDescription() + "\t" + task.getStartDate() + "\t"
								+ task.getEndDate() + "\t" + task.getUrgent() + "\t" + task.getImportant() + "\t"
								+ task.getID() + "\t" + task.getTaskNum() + "\t" + task.getGoalDescription() + "\t"
								+ task.getGoalID() + "\n");
					}
				}
			}
			System.out.println("day.csv updated");
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}