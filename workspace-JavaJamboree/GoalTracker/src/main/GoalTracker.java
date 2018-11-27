package main;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GoalTracker {
	static JLabel lblMonth, lblYear;
	static JButton btnPrev, btnNext, btnTask, btnGoal, btnSave, btnDelete, btnCancel, btnDate;
	static JTable mnthTblCalendar, weekTblCalendar;
	static JComboBox<String> cmbYear;
	static JFrame frmMain, frmTask;
	static Container pane, paneTask;
	static DefaultTableModel mtblCalendar, wtblCalendar;
	static JScrollPane mstblCalendar;
	static JPanel pnlCalendarMonth, pnlTask, pnlCalendarWeek;
	static int realYear, realMonth, realDay, currentYear, currentMonth;
	static JTabbedPane tabs;

	/**
	 * Calendar GUI.
	 * @param args
	 */
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

		mtblCalendar = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return true;
			}
		};

		mnthTblCalendar = new JTable(mtblCalendar);
		mstblCalendar = new JScrollPane(mnthTblCalendar);
		pnlCalendarMonth = new JPanel(null);

		pnlCalendarMonth.setBorder(BorderFactory.createTitledBorder("Goal Tracker"));

		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());

		btnTask.addActionListener(new TaskUI());
		btnGoal.addActionListener(new GoalUI());

		pane.add(pnlCalendarMonth);
		pnlCalendarMonth.add(lblMonth);
		pnlCalendarMonth.add(lblYear);
		pnlCalendarMonth.add(cmbYear);
		pnlCalendarMonth.add(btnPrev);
		pnlCalendarMonth.add(btnNext);
		pnlCalendarMonth.add(mstblCalendar);
		pnlCalendarMonth.add(btnGoal);
		pnlCalendarMonth.add(btnTask);

		pnlCalendarMonth.setBounds(100, 100, 700, 750);
		lblYear.setBounds(10, 335, 110, 525);
		cmbYear.setBounds(97, 335, 90, 525);
		btnPrev.setBounds(10, 45, 90, 25);
		btnNext.setBounds(620, 45, 66, 25);
		btnGoal.setBounds(420, 10, 100, 25);
		btnTask.setBounds(540, 10, 100, 25);
		mstblCalendar.setBounds(10, 70, 680, 500);

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

		mnthTblCalendar.getParent().setBackground(mnthTblCalendar.getBackground());
		mnthTblCalendar.setGridColor(Color.BLACK);

		mnthTblCalendar.getTableHeader().setResizingAllowed(false);
		mnthTblCalendar.getTableHeader().setReorderingAllowed(false);

		mnthTblCalendar.setColumnSelectionAllowed(true);
		mnthTblCalendar.setRowSelectionAllowed(true);
		mnthTblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		mnthTblCalendar.setRowHeight(90);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);
		mtblCalendar.getColumnCount();
		// mtblCalendar.getColumnCount().setCellRenderer(new
		// ClientsTableButtonRenderer());

		for (int i = realYear - 100; i <= realYear + 100; i++) {
			cmbYear.addItem(String.valueOf(i));
		}

		refreshCalendar(realMonth, realYear);
	}

	/**
	 * Sets up the calendar.
	 * @param month an int.
	 * @param year an int.
	 */
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
			// mtblCalendar.setValueAt(i, row, column);
			// date = new JButton(Integer.toString(i));
			mtblCalendar.setValueAt(i, row, column);
			;
			// insert print/button stuff here
		}

		mnthTblCalendar.setDefaultRenderer(mnthTblCalendar.getColumnClass(0), new tblCalendarRenderer());
		int x = 30;
		int y = 630;
		int b = 30;
		int h = 40;
		int yy = 700;
		int xx = 30;
		for (int i = 1; i <= nod; i++) {
			btnDate = new JButton(Integer.toString(i));
			if (x < 500) {
				btnDate.setBounds(x, y, b, h);
				x = x + 30;
			} else {
				btnDate.setBounds(xx, yy, b, h);
				xx = xx + 30;
			}
			pnlCalendarMonth.add(btnDate);
			btnDate.addActionListener(new btnDate_Action(i));
		}
	}

	/**
	 * Displays the calendar.
	 */
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

	/**
	 * Button moves to previous month.
	 */
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

	/**
	 * Button moves to next month.
	 */
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

	/**
	 * Dropdown box to select year.
	 */
	static class cmbYear_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (cmbYear.getSelectedItem() != null) {
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentMonth, currentYear);
			}
		}
	}

	static class btnDate_Action implements ActionListener {
		private int day;

		btnDate_Action(int day) {
			this.day = day;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println(day + " " + currentMonth + " " + currentYear);
		}
	}

}
