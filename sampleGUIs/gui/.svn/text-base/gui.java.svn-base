package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.CardLayout;

/**
 * A simple GUI with two frames and two buttons that allows for a frame to pop up
 * right next to the original frame.
 * 
 * @author Robert Lee
 */
public class gui extends JFrame implements ActionListener {
	
	/**
	 * The button on the main frame to "pop-out" the tray frame
	 */
	private JButton slideOut;
	
	/**
	 * The button on the tray frame to pop the tray back in
	 */
	private JButton slideIn;
	
	/**
	 * The main frame of the GUI
	 */
	private JFrame main;
	
	/**
	 * The tray frame for the GUI
	 */
	private JFrame tray;

	/**
	 * The constructor that allows the creation of all variables used in the frames
	 * 
	 * @throws IOException exception
	 */
	public gui() throws IOException {
			
		/**
		 * FRAME SET-UP
		 */
		
		main = new JFrame();
		main.getContentPane().setLayout(null);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tray = new JFrame();
		tray.getContentPane().setLayout(null);
		tray.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/**
		 * BUTTON SETUP
		 */
		
		slideOut = new JButton("->");
		slideOut.setBounds(339, 0, 45, 662);
		main.getContentPane().add(slideOut);
		slideOut.addActionListener(this);
		
		slideIn = new JButton("<-");
		slideIn.setBounds(0, 0, 45, 662);
		tray.getContentPane().add(slideIn);
		slideIn.addActionListener(this);

		/**
		 * FRAME SIZE AND VISIBILITY
		 */
		
		main.setSize(400, 700);
		main.setVisible(true);
	
		tray.setSize(400, 700);
		tray.setVisible(false);
	
	}
	
	/**
	 * The main method
	 * @param args -
	 * @throws IOException exception
	 */
	public static void main(String[] args) throws IOException {
		gui guwey = new gui();
	}

	/**
	 * The method to handle actions performed in the frame(s) by the user
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if the action is the button on the main frame to pop out the tray...
		if(e.getSource().equals(slideOut)) {
			
			//set the button on the main frame to be not visible
			slideOut.setVisible(false);
			
			//allows for the "tray" to be set to the right of the main frame when it becomes visible
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (int) ((dimension.getWidth() - main.getWidth()) / 2.45);
			int y = (int) ((dimension.getHeight() - main.getHeight()) / 25);
			tray.setLocation(x, y);
			
			//be sure to set the tray to be visible when this button is pressed
			tray.setVisible(true);
			
		//if the action is the button on the tray frame to pop it back in...	
		} else if(e.getSource().equals(slideIn)) {
			//set the tray to be invisible and the button to be visible again
			tray.setVisible(false);
			slideOut.setVisible(true);
		}
	}
}
