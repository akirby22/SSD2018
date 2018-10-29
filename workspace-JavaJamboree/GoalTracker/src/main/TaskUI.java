package main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




	public class TaskUI implements ActionListener {
		static JFrame frmTask;
		static Container paneTask;
		static JPanel pnlTask;
		static JButton btnSave, btnDelete, btnCancel;
		
		public void actionPerformed(ActionEvent e) {
			frmTask = new JFrame("Task");
			JTextField t1, t2;
			frmTask.setSize(600, 600);
			paneTask = frmTask.getContentPane();
			paneTask.setLayout(null);
			pnlTask = new JPanel(null);
			paneTask.add(pnlTask);

			JLabel l1, l2, l3, l4;
			l1 = new JLabel("Title");
			l1.setBounds(50, 70, 100, 30);
			l2 = new JLabel("Description");
			l2.setBounds(50, 100, 100, 30);
			l3 = new JLabel("Is important");
			l3.setBounds(50, 125, 100, 30);
			l4 = new JLabel("Is urgent");
			l4.setBounds(50, 145, 100, 30);
			pnlTask.add(l1);
			pnlTask.add(l2);
			pnlTask.add(l3);
			pnlTask.add(l4);

			t1 = new JTextField("Title");
			t1.setBounds(150, 70, 200, 30);
			t2 = new JTextField("Description");
			t2.setBounds(150, 100, 200, 30);
			pnlTask.add(t1);
			pnlTask.add(t2);
			JRadioButton r1 = new JRadioButton("Yes");
			JRadioButton r2 = new JRadioButton("No");
			JRadioButton r3 = new JRadioButton("Yes");
			JRadioButton r4 = new JRadioButton("No");
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

			btnSave = new JButton("Save");
			btnDelete = new JButton("Delete");
			btnCancel = new JButton("Cancel");
			btnSave.setBounds(50, 175, 66, 25);
			btnDelete.setBounds(150, 175, 66, 25);
			btnCancel.setBounds(250, 175, 66, 25);
			pnlTask.add(btnSave);
			pnlTask.add(btnDelete);
			pnlTask.add(btnCancel);

			pnlTask.setBorder(BorderFactory.createTitledBorder("Task"));
			pnlTask.setBounds(100, 100, 400, 310);

			frmTask.setResizable(false);
			frmTask.setVisible(true);
		}
	}

