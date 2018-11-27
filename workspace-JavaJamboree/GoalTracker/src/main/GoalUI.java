package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Goal;
import model.Task;

public class GoalUI implements ActionListener {
	static JFrame frmGoal;
	static Container paneGoal;
	static JPanel pnlGoal;
	static JButton btnSave, btnDelete, btnCancel;

	/**
	 * Goal screen GUI.
	 */

	public void actionPerformed(ActionEvent e) {
		frmGoal = new JFrame("Goal");
		JTextField t1, t2;
		frmGoal.setSize(600, 600);
		paneGoal = frmGoal.getContentPane();
		paneGoal.setLayout(null);
		pnlGoal = new JPanel(null);
		paneGoal.add(pnlGoal);

		JLabel l1, l2;
		l1 = new JLabel("Title");
		l1.setBounds(50, 70, 100, 30);
		l2 = new JLabel("Description");
		l2.setBounds(50, 100, 100, 30);

		pnlGoal.add(l1);
		pnlGoal.add(l2);

		t1 = new JTextField("Title");
		t1.setBounds(150, 70, 200, 30);
		t2 = new JTextField("Description");
		t2.setBounds(150, 100, 200, 30);
		pnlGoal.add(t1);
		pnlGoal.add(t2);

		btnSave = new JButton("Save");
		btnDelete = new JButton("Delete");
		btnCancel = new JButton("Cancel");
		btnSave.setBounds(50, 175, 66, 25);
		btnDelete.setBounds(150, 175, 66, 25);
		btnCancel.setBounds(250, 175, 66, 25);
		pnlGoal.add(btnSave);
		pnlGoal.add(btnDelete);
		pnlGoal.add(btnCancel);

		pnlGoal.setBorder(BorderFactory.createTitledBorder("Goal"));
		pnlGoal.setBounds(100, 100, 400, 310);

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGoal.dispose();
			}
		});

		/**
		 * Saves the goal into the .csv file.
		 */
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Goal goal;
				goal = new Goal(t1.getText(), t2.getText());
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter("src/goals.csv", true);
					BufferedWriter br = new BufferedWriter(fileWriter);
					br.write(goal.getGTitle() + "\t" + goal.getGDescription() + "\n");
					System.out.println("Goal updated");
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		frmGoal.setResizable(false);
		frmGoal.setVisible(true);
	}
}
