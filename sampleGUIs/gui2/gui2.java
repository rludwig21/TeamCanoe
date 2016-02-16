package gui2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class gui2 extends JFrame implements ActionListener {
	
	/**
	 * The button to slide the frame back in
	 */
	private JButton slideIn;
	
	/**
	 * The button to slide the frame out
	 */
	private JButton slideOut;
	
	/**
	 * The main frame of the GUI
	 */
	private JFrame main;

	/**
	 * The constructor that allows the creation of all variables used in the frame
	 * 
	 * @throws IOException exception
	 */
	public gui2() throws IOException {
			
		/**
		 * FRAME SET-UP
		 */
		
		main = new JFrame();
		main.getContentPane().setLayout(null);
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/**
		 * BUTTON SETUP
		 */
		
		slideOut = new JButton("->");
		slideOut.setBounds(339, 0, 45, 662);
		main.getContentPane().add(slideOut);
		slideOut.addActionListener(this);
		
		slideIn = new JButton("<-");
		slideIn.setBounds(0, 0, 45, 662);
		main.getContentPane().add(slideIn);
		slideIn.addActionListener(this);
		slideIn.setVisible(false);

		/**
		 * FRAME SIZE AND VISIBILITY
		 */
		
		main.setSize(400, 700);
		main.setVisible(true);
	
	}
	
	/**
	 * The main method
	 * @param args -
	 * @throws IOException exception
	 */
	public static void main(String[] args) throws IOException {
		gui2 guwey = new gui2();
	}

	/**
	 * The method to handle actions performed in the frame(s) by the user
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if the action is the button on the frame to pop out the tray...
		if(e.getSource().equals(slideOut)) {
			//enlarge the frame
			main.setSize(800, 700);
			//set the bounds of the button to be on the outside of the frame
			slideIn.setBounds(740, 0, 45, 662);
			//set the slideIn button to be visible
			slideIn.setVisible(true);
			//set the slide out button to be not visible
			slideOut.setVisible(false);
		//if the action is the button on the frame to slide the tray back in
		} else if(e.getSource().equals(slideIn)) {
			//reset the frame size to the original
			main.setSize(400, 700);
			//set the slideOut button to be visible
			slideOut.setVisible(true);
			//set the slideIn button to be invisible
			slideIn.setVisible(false);
		}
	}	
}
