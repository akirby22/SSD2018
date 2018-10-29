package main;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GoalTracker {
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext, btnTask, btnGoal, btnSave, btnDelete, btnCancel;
	static JTable tblCalendar;
	static JComboBox cmbYear;
	static JFrame frmMain, frmTask;
	static Container pane, paneTask;
	static DefaultTableModel mtblCalendar;
	static JScrollPane stblCalendar;
	static JPanel pnlCalendarMonth, pnlTask;
	static int realYear, realMonth, realDay, currentYear, currentMonth;

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new GoalTracker();
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

	}

	GoalTracker() {
		frmMain = new JFrame("SSD");
		frmMain.setSize(900, 900);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblMonth = new JLabel("January");
		lblYear = new JLabel("Change year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton("Previous");
		btnNext = new JButton("Next");
		btnTask = new JButton("Add Task");
		btnGoal = new JButton("Add Goal");
		mtblCalendar = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return true;
			}
		};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendarMonth = new JPanel(null);

		pnlCalendarMonth.setBorder(BorderFactory.createTitledBorder("Goal Tracker"));

		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
		btnTask.addActionListener(new btnTask_Action());

		pane.add(pnlCalendarMonth);
		pnlCalendarMonth.add(lblMonth);
		pnlCalendarMonth.add(lblYear);
		pnlCalendarMonth.add(cmbYear);
		pnlCalendarMonth.add(btnPrev);
		pnlCalendarMonth.add(btnNext);
		pnlCalendarMonth.add(stblCalendar);
		pnlCalendarMonth.add(btnGoal);
		pnlCalendarMonth.add(btnTask);

		pnlCalendarMonth.setBounds(100, 100, 700, 610);
		lblYear.setBounds(10, 335, 110, 525);
		cmbYear.setBounds(97, 335, 90, 525);
		btnPrev.setBounds(10, 45, 90, 25);
		btnNext.setBounds(620, 45, 66, 25);
		btnGoal.setBounds(420, 10, 100, 25);
		btnTask.setBounds(540, 10, 100, 25);
		stblCalendar.setBounds(10, 70, 680, 500);

		frmMain.setResizable(false);
		frmMain.setVisible(true);

		GregorianCalendar cal = new GregorianCalendar();
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
		realMonth = cal.get(GregorianCalendar.MONTH);
		realYear = cal.get(GregorianCalendar.YEAR);
		currentMonth = realMonth;
		currentYear = realYear;

		String[] headers = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (int i = 0; i < 7; i++) {
			mtblCalendar.addColumn(headers[i]);
		}

		tblCalendar.getParent().setBackground(tblCalendar.getBackground());
		tblCalendar.setGridColor(Color.BLACK);

		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblCalendar.setRowHeight(90);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);

		for (int i = realYear - 100; i <= realYear + 100; i++) {
			cmbYear.addItem(String.valueOf(i));
		}

		refreshCalendar(realMonth, realYear);
	}

	public static void refreshCalendar(int month, int year) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int nod, som;

		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= realYear - 10) {
			btnPrev.setEnabled(false);
		} // Too early
		if (month == 11 && year >= realYear + 100) {
			btnNext.setEnabled(false);
		} // Too late
		lblMonth.setText(months[month]);
		lblMonth.setBounds(345 - lblMonth.getPreferredSize().width / 2, 45, 180, 25);
		cmbYear.setSelectedItem(String.valueOf(year));

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				mtblCalendar.setValueAt(null, i, j);
			}
		}

		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		for (int i = 1; i <= nod; i++) {
			int row = new Integer((i + som - 2) / 7);
			int column = (i + som - 2) % 7;
			mtblCalendar.setValueAt(i, row, column);
		}

		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	}

	static class tblCalendarRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
				int row, int column) {
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 0 || column == 6) {
				setBackground(new Color(100, 100, 100));
			} else {
				setBackground(new Color(255, 255, 255));
			}
			if (value != null) {
				if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth
						&& currentYear == realYear) {
					setBackground(new Color(0, 220, 220));
				}
			}
			setBorder(null);
			setForeground(Color.BLACK);

			return this;
		}
	}

	static class btnPrev_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (currentMonth == 0) {
				currentMonth = 11;
				currentYear -= 1;
			} else {
				currentMonth -= 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}

	static class btnNext_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (currentMonth == 11) {
				currentMonth = 0;
				currentYear += 1;
			} else {
				currentMonth += 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}

	static class cmbYear_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (cmbYear.getSelectedItem() != null) {
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentMonth, currentYear);
			}
		}
	}

	static class btnTask_Action implements ActionListener {
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

}
