package main;

import javax.swing.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TaskViewer {
	JButton btnTasks;
	static JFrame frmMain;
	static Container pane;
	static JPanel TasksonDay;
//	ArrayList<JButton> task;

	TaskViewer() throws IOException {
		frmMain = new JFrame("Goal Tracker Taks");
		frmMain.setSize(700, 700);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		TasksonDay = new JPanel(null);
		pane.add(TasksonDay);
//		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/day.csv"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] task = sCurrentLine.split("\t");
				btnTasks = new JButton(task[0]);
				System.out.println(Boolean.valueOf(task[5]) + " " + Boolean.valueOf(task[4]));
				if(Boolean.valueOf(task[5]) == true && Boolean.valueOf(task[4]) == true) {
				btnTasks.setBackground(Color.RED);
				btnTasks.setForeground(Color.RED);
				}
				btnTasks.setBounds(50, 100, 50, 50);
				TasksonDay.add(btnTasks);
				System.out.println(task[0]);
				// btnTasks.addActionListener(new btnTasks_Action());
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

		}
		//
		TasksonDay.setBorder(BorderFactory.createTitledBorder("Tasks"));
		TasksonDay.setBounds(100, 100, 400, 310);

		frmMain.setResizable(false);
		frmMain.setVisible(true);
	}
	// static class btnTasks_Action implements ActionListener {
	// public void actionPerformed(ActionEvent e) {
	//
	// }
	// }

	// @Override
	// public void actionPerformed(ActionEvent e) {
	// frmMain = new JFrame("Goal Tracker Taks");
	// frmMain.setSize(700, 700);
	// System.out.println("in");
	// pane = frmMain.getContentPane();
	// pane.setLayout(null);
	// frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//
	// try {
	// BufferedReader br = new BufferedReader(new FileReader("src/days.csv"));
	// String sCurrentLine;
	// while ((sCurrentLine = br.readLine()) != null) {
	// String[] task = sCurrentLine.split("\t");
	// btnTasks = new JButton(task[0]);
	// btnTasks.setBounds(50, 100, 50, 50);
	// frmMain.add(btnTasks);
	// // btnTasks.addActionListener(new btnTasks_Action());
	// }
	// br.close();
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// // e.printStackTrace();
	//
	// }
	//
	// }

}
