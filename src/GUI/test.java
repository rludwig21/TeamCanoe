package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;

public class test extends JFrame implements ActionListener {

	private JButton clear;
	private JButton submit;
	private JButton slideOut;
	private JButton search;
	private JButton slideIn;

	private JLabel mainLabel;
	private JLabel origRequestLabel;
	private JLabel neededLabel;
	private JLabel solutionLabel;
	private JLabel errorFillLabel;

	private JFormattedTextField date;
	private JFormattedTextField time;

	private JComboBox office;
	private JComboBox deadline;
	private JComboBox sorted;

	private JTextArea origRequest;
	private JTextArea needed;
	private JTextArea solution;
	private JTextArea refine;

	private JList logs;

	private JFrame main;

	public test() throws IOException {

		main = new JFrame();
		main.getContentPane().setEnabled(false);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.getContentPane().setLayout(null);

		clear = new JButton("CLEAR");
		clear.setBounds(10, 601, 150, 50);
		main.getContentPane().add(clear);
		clear.addActionListener(this);

		submit = new JButton("Submit");
		submit.setBounds(174, 601, 150, 50);
		main.getContentPane().add(submit);
		submit.addActionListener(this);

		mainLabel = new JLabel("Request Logger");
		mainLabel.setBounds(10, 11, 314, 50);
		mainLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		main.getContentPane().add(mainLabel);

		date = new JFormattedTextField();
		date.setBounds(10, 72, 150, 20);
		date.setText("Date:");
		main.getContentPane().add(date);

		// button to slide out the tray
		slideOut = new JButton("<html>&#8594;</html>");
		slideOut.setBounds(334, 1, 50, 662);
		main.getContentPane().add(slideOut);
		slideOut.addActionListener(this);

		// button to slide tray in
		slideIn = new JButton("<html>&#8592;</html");
		slideIn.setBounds(334, 1, 50, 662);
		main.getContentPane().add(slideIn);
		slideIn.setVisible(false);
		slideIn.addActionListener(this);

		time = new JFormattedTextField();
		time.setBounds(174, 72, 150, 20);
		time.setText("Time:");
		main.getContentPane().add(time);

		office = new JComboBox();
		office.setBounds(10, 103, 314, 20);
		main.getContentPane().add(office);

		deadline = new JComboBox();
		deadline.setBounds(10, 134, 314, 20);
		main.getContentPane().add(deadline);

		origRequest = new JTextArea();
		origRequest.setBounds(10, 190, 314, 150);
		main.getContentPane().add(origRequest);

		needed = new JTextArea();
		needed.setBounds(10, 376, 314, 75);
		main.getContentPane().add(needed);

		solution = new JTextArea();
		solution.setBounds(10, 487, 314, 75);
		main.getContentPane().add(solution);

		origRequestLabel = new JLabel("Original Request");
		origRequestLabel.setBounds(10, 165, 150, 14);
		main.getContentPane().add(origRequestLabel);

		neededLabel = new JLabel("What is Needed");
		neededLabel.setBounds(10, 351, 150, 14);
		main.getContentPane().add(neededLabel);

		solutionLabel = new JLabel("Solution");
		solutionLabel.setBounds(10, 462, 150, 14);
		main.getContentPane().add(solutionLabel);

		errorFillLabel = new JLabel(
				"*ERROR: Please fill the highlighted fields above");
		errorFillLabel.setBounds(10, 575, 290, 14);
		errorFillLabel.setForeground(Color.RED);
		errorFillLabel.setVisible(false);
		main.getContentPane().add(errorFillLabel);

		refine = new JTextArea();
		refine.setText("Refine:");
		refine.setBounds(564, 9, 150, 22);
		main.getContentPane().add(refine);

		sorted = new JComboBox();
		sorted.setBounds(394, 11, 150, 20);
		main.getContentPane().add(sorted);

		search = new JButton("Search");
		search.setBounds(394, 38, 320, 22);
		main.getContentPane().add(search);

		logs = new JList();
		logs.setBounds(394, 74, 320, 577);
		main.getContentPane().add(logs);

		main.setResizable(false);
		main.setSize(700, 693);
		main.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		test gewey = new test();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// extend the tray from main GUI
		if (e.getSource().equals(slideOut)) {
			main.setSize(740, 693);
			slideIn.setVisible(true);
			slideOut.setEnabled(false);
			slideOut.setVisible(false);
		}
		// hide tray back into main GUI
		if (e.getSource().equals(slideIn)) {
			main.setSize(390, 693);
			slideIn.setVisible(false);
			slideOut.setEnabled(true);
			slideOut.setVisible(true);
		}
		// clear fields
		if (e.getSource().equals(clear)) {
			solution.setText("");
			needed.setText("");
			origRequest.setText("");
		}

		// submit
		if (e.getSource().equals(submit)) {
			// check all fields are filled
			boolean filledCorrect = true;
			if (origRequest.getText().isEmpty()) {
				origRequestLabel.setForeground(Color.RED);
				origRequestLabel.setText("*Original Request");
				filledCorrect = false;
			} else {
				origRequestLabel.setForeground(Color.BLACK);
				origRequestLabel.setText("Original Request");
			}
			if (solution.getText().isEmpty()) {
				solutionLabel.setForeground(Color.RED);
				solutionLabel.setText("*Solution");
				filledCorrect = false;
			} else {
				solutionLabel.setForeground(Color.BLACK);
				solutionLabel.setText("Solution");
			}
			if (needed.getText().isEmpty()) {
				neededLabel.setForeground(Color.RED);
				neededLabel.setText("*What is Needed");
				filledCorrect = false;
			} else {
				neededLabel.setForeground(Color.BLACK);
				neededLabel.setText("What is Needed");
			}
			// if every thing is not filled
			if (filledCorrect == false) {
				// display error message
				errorFillLabel.setVisible(true);
			} else {
				// otherwise submit
				// change any error messages back
				errorFillLabel.setVisible(false);
				// submit the log to be

			}

		}
	}
}
