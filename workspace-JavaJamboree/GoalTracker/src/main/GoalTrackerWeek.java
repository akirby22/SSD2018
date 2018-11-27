package main;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import main.GoalTracker.tblCalendarRenderer;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class GoalTrackerWeek {
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext, btnTask, btnGoal, btnSave, btnDelete, btnCancel;
	static JTable weekTblCalendar;
	static JComboBox<String> cmbYear;
	static JFrame frmMain, frmTask;
	static Container pane, paneTask;
	static DefaultTableModel mtblCalendar, wtblCalendar;
	static JScrollPane wstblCalendar;
	static JPanel pnlTask, pnlCalendarWeek;
	static int realYear, realMonth, realWeek, realDay, currentWeek, currentYear, currentMonth;
	static JTabbedPane tabs;

	public static void main(String args[]) throws IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new GoalTrackerWeek();
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

	}

	GoalTrackerWeek() throws IOException {
		frmMain = new JFrame("SSDweek");
		frmMain.setSize(900, 900);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// tabs = new JTabbedPane();
		// tabs.setBounds(10, 70, 680, 500);
		//// tabs.add(pnlCalendarMonth);
		//
		// JFrame frame = new JFrame();
		// JMenuBar bar = new JMenuBar();
		// bar.add(new JMenu("menu"));
		// frame.setJMenuBar(bar);
		// frame.add(new JButton("button"));
		//
		// JPanel tab1 = new JPanel(new BorderLayout());
		// tab1.add(frame.getJMenuBar(),BorderLayout.NORTH);
		// tab1.add(frame.getContentPane());
		// tabs.addTab("1", tab1);

		lblMonth = new JLabel("January");
		lblYear = new JLabel("Change year:");
		cmbYear = new JComboBox<String>();
		btnPrev = new JButton("Previous");
		btnNext = new JButton("Next");
		btnTask = new JButton("Add Task");
		btnGoal = new JButton("Add Goal");
		wtblCalendar = new DefaultTableModel() {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return true;
			}
		};

		weekTblCalendar = new JTable(wtblCalendar);
		wstblCalendar = new JScrollPane(weekTblCalendar);
		pnlCalendarWeek = new JPanel(null);

		pnlCalendarWeek.setBorder(BorderFactory.createTitledBorder("Goal Tracker week"));

		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
		btnTask.addActionListener(new TaskUI());
		btnGoal.addActionListener(new GoalUI());

		pane.add(pnlCalendarWeek);
		pnlCalendarWeek.add(lblMonth);
		pnlCalendarWeek.add(lblYear);
		pnlCalendarWeek.add(cmbYear);
		pnlCalendarWeek.add(btnPrev);
		pnlCalendarWeek.add(btnNext);
		pnlCalendarWeek.add(wstblCalendar);
		pnlCalendarWeek.add(btnGoal);
		pnlCalendarWeek.add(btnTask);
		pnlCalendarWeek.setBounds(100, 100, 700, 610);

		pnlCalendarWeek.setBounds(100, 100, 700, 610);
		lblYear.setBounds(10, 335, 110, 525);
		cmbYear.setBounds(97, 335, 90, 525);
		btnPrev.setBounds(10, 45, 90, 25);
		btnNext.setBounds(620, 45, 66, 25);
		btnGoal.setBounds(420, 10, 100, 25);
		btnTask.setBounds(540, 10, 100, 25);
		wstblCalendar.setBounds(10, 70, 680, 500);

		frmMain.setResizable(false);
		frmMain.setVisible(true);

		GregorianCalendar cal = new GregorianCalendar();
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
		realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		realMonth = cal.get(GregorianCalendar.MONTH);
		realYear = cal.get(GregorianCalendar.YEAR);
		currentMonth = realMonth;
		currentYear = realYear;
		currentMonth = realMonth;
		currentYear = realYear;

		String[] headers = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		for (int i = 0; i < 7; i++) {
			wtblCalendar.addColumn(headers[i]);
		}

		weekTblCalendar.getParent().setBackground(weekTblCalendar.getBackground());
		weekTblCalendar.setGridColor(Color.BLACK);

		weekTblCalendar.getTableHeader().setResizingAllowed(false);
		weekTblCalendar.getTableHeader().setReorderingAllowed(false);

		weekTblCalendar.setColumnSelectionAllowed(true);
		// weekTblCalendar.setRowSelectionAllowed(true);
		weekTblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		weekTblCalendar.setRowHeight(500);
		wtblCalendar.setColumnCount(7);
		wtblCalendar.setRowCount(1);

		for (int i = realYear - 100; i <= realYear + 100; i++) {
			cmbYear.addItem(String.valueOf(i));
		}

		refreshCalendar(realWeek, realMonth, realYear);
	}

	public static void refreshCalendar(int week, int month, int year) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int som, nod;
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

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 7; j++) {
				wtblCalendar.setValueAt(null, i, j);
			}
		}

		GregorianCalendar cal = new GregorianCalendar(year, month, 0);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		System.out.println(nod + "," + som);
		for (int i = 1; i <= 7; i++) {
			int k = new Integer((i + som - 2) / 7);
			if (k != 1) {
				int row = k;
				int column = (i + som - 2) % 7;
				System.out.println(row + "," + column);
				wtblCalendar.setValueAt(i, row, column);
			}
		}

		weekTblCalendar.setDefaultRenderer(weekTblCalendar.getColumnClass(0), new tblCalendarRenderer());
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
			if (currentWeek == 0) {
				currentWeek = 53;
				currentYear -= 1;
			} else {
				currentWeek -= 1;
			}
			refreshCalendar(currentWeek, currentMonth, currentYear);
		}
	}

	static class btnNext_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (currentWeek == 53) {
				currentWeek = 0;
				currentYear += 1;
			} else {
				currentWeek += 1;
			}
			refreshCalendar(currentWeek, currentMonth, currentYear);
		}
	}

	static class cmbYear_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (cmbYear.getSelectedItem() != null) {
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				// refreshCalendar(currentMonth, currentYear);
			}
		}
	}

}
