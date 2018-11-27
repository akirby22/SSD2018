package main;

import javax.swing.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TaskViewer {
	JButton btnTasks;
	static JFrame frmMain;
	static Container pane;
	static JPanel TasksonDay;

	TaskViewer() throws IOException {
		frmMain = new JFrame("Goal Tracker Taks");
		frmMain.setSize(700, 700);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		TasksonDay = new JPanel(null);
		pane.add(TasksonDay);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/day.csv"));
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] task = sCurrentLine.split("\t");
				btnTasks = new JButton(task[0]);
				System.out.println(Boolean.valueOf(task[5]) + " " + Boolean.valueOf(task[4]));
				if (Boolean.valueOf(task[5]) == true && Boolean.valueOf(task[4]) == true) {
					btnTasks.setBackground(Color.RED);
					btnTasks.setForeground(Color.RED);
				}
				if (Boolean.valueOf(task[5]) == true && Boolean.valueOf(task[4]) == false) {
					btnTasks.setBackground(Color.BLUE);
					btnTasks.setForeground(Color.BLUE);
				}
				if (Boolean.valueOf(task[5]) == false && Boolean.valueOf(task[4]) == true) {
					btnTasks.setBackground(Color.GREEN);
					btnTasks.setForeground(Color.GREEN);
				}
				btnTasks.setBounds(50, 100, 50, 50);
				TasksonDay.add(btnTasks);
				// System.out.println(task[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {

		}
		TasksonDay.setBorder(BorderFactory.createTitledBorder("Tasks"));
		TasksonDay.setBounds(100, 100, 400, 310);

		frmMain.setResizable(false);
		frmMain.setVisible(true);
	}

}
