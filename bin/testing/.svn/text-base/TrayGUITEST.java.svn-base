package testing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import GUI.MainGUI;
import RequestLogger.Log;

public class TrayGUITEST {

	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test
	public void preFillWhenEmptyTest() throws IOException {
		
		MainGUI maingui = new MainGUI();
		
		Log logIn = new Log();
		logIn.setOffice("Office");
		logIn.setTimeReq("Time required");
		logIn.setDeadline("Deadline");
		//logIn.setDate("Date:");
		logIn.setOrigReq("");
		logIn.setNeeded("");
		logIn.setSolution("");
		logIn.setStatus("Status");
				
		
		assertEquals(maingui.getOffice().getSelectedItem(), "Office");
		assertEquals(maingui.getTimeReq().getSelectedItem(), "Time required");
		assertEquals(maingui.getDeadline().getSelectedItem(), "Deadline");
		//assertEquals(maingui.getDate(), "01012015");
		assertEquals(maingui.getOrigReq().getText(), "");
		assertEquals(maingui.getNeeded().getText(), "");
		assertEquals(maingui.getSolution().getText(), "");
		assertEquals(maingui.getDatabase().getSelectedItem(), "Database");
		assertEquals(maingui.getStatus().getSelectedItem(), "Status");
		
	}
	
	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test
	public void preFillWhenFullTest() throws IOException {
		
		MainGUI maingui = new MainGUI();
		
		Log logIn = new Log();
		logIn.setOffice("President");
		logIn.setTimeReq("Two weeks");
		logIn.setDeadline("Two weeks");
		//logIn.setDate("01012015");
		logIn.setOrigReq("ORIGINAL");
		logIn.setNeeded("NEEDED");
		logIn.setSolution("SOLUTION");
		logIn.setStatus("Complete");
				
		
		assertTrue(maingui.getError2Label().isVisible());
		assertTrue(maingui.getError2Label().isVisible());
		assertTrue(maingui.getError2Label().isVisible());
		
	}
	
}
