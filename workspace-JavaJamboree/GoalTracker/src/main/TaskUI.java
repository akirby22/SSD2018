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
	JLabel l1, l2, l3, l4, l5, l6;
	ButtonGroup impgroup = new ButtonGroup();
	ButtonGroup prioritygroup = new ButtonGroup();
	JRadioButton r1, r2, r3, r4;
	DateFormat format = new SimpleDateFormat("mm-dd-yyyy");
	JComboBox<String> c;
	List<String> Goals = new ArrayList<String>();

	public void actionPerformed(ActionEvent e) {
		frmTask = new JFrame("Task");
		JTextField t1, t2;
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
			l5 = new JLabel("Date Range");
			l5.setBounds(50, 175, 100, 30);
			l6 = new JLabel("Choose Goal");
			l6.setBounds(50, 40, 100, 30);
			pnlTask.add(l1);
			pnlTask.add(l2);
			pnlTask.add(l3);
			pnlTask.add(l4);
			pnlTask.add(l5);
			pnlTask.add(l6);

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

			JFormattedTextField startDateTextField = new JFormattedTextField(format);
			startDateTextField.setBounds(150, 175, 70, 30);
			JFormattedTextField endDateTextField = new JFormattedTextField(format);
			endDateTextField.setBounds(260, 175, 70, 30);
			pnlTask.add(startDateTextField);
			pnlTask.add(endDateTextField);

			btnSave = new JButton("Save");
			btnDelete = new JButton("Delete");
			btnCancel = new JButton("Cancel");
			btnSave.setBounds(50, 215, 66, 25);
			btnDelete.setBounds(150, 215, 66, 25);
			btnCancel.setBounds(250, 215, 66, 25);
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
					Task task;
					task = new Task(t1.getText(), t2.getText(), 0, 0, r1.isSelected(), r3.isSelected(), 0, 0,
							"tempgoaldesc", 0);
					FileWriter fileWriter;
					try {
						fileWriter = new FileWriter("src/tasks.csv", true);
						BufferedWriter br = new BufferedWriter(fileWriter);
						br.write(task.getTitle() + "\t" + task.getDescription() + "\t" + task.getStartDate() + "\t"
								+ task.getEndDate() + "\t" + task.getImportant() + "\t" + task.getPriority() + "\t"
								+ "0" + "\t" + "0" + task.getGoalDescription() + "\t" + task.getGoalID() + "\n");
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
}
