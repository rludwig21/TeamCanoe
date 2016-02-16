package testing;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.IOException;
import org.junit.Test;
import GUI.MainGUI;

public class MainGUITEST {
	
	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test
	public void clearButtonTest() throws IOException {
		
		MainGUI maingui = new MainGUI();
		
		maingui.getOffice().setSelectedItem("President");
		maingui.getDeadline().setSelectedItem("this week");
		maingui.getStatus().setSelectedItem("incomplete");
		maingui.getTimeReq().setSelectedItem("two weeks");
		maingui.getDatabase().setSelectedItem("Megahertz");
		maingui.getOrigReq().setText("original request");
		maingui.getNeeded().setText("what is needed");
		maingui.getSolution().setText("solution");
		
		maingui.clear();
		
		assertTrue(maingui.getOffice().getSelectedItem().equals("Office"));				//default value, whatever it is
		assertTrue(maingui.getDeadline().getSelectedItem().equals("Deadline"));			//default value, whatever it is
		assertTrue(maingui.getStatus().getSelectedItem().equals("Status"));				//default value, whatever it is
		assertTrue(maingui.getTimeReq().getSelectedItem().equals("Time required"));		//default value, whatever it is
		assertTrue(maingui.getDatabase().getSelectedItem().equals( "Database"));		//default value, whatever it is
		assertTrue(maingui.getOrigReq().getText().equals(""));
		assertTrue(maingui.getNeeded().getText().equals(""));
		assertTrue(maingui.getSolution().getText().equals(""));
	}
	
	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test
	public void checkCompleteTestOneFieldBlank() throws IOException {
		
		MainGUI maingui = new MainGUI();
		
		maingui.getOffice().setSelectedItem("President");
		maingui.getDeadline().setSelectedItem("this week");
		maingui.getStatus().setSelectedItem("incomplete");
		maingui.getTimeReq().setSelectedItem("two weeks");
		maingui.getDatabase().setSelectedItem("Megahertz");
		maingui.getOrigReq().setText("");
		maingui.getNeeded().setText("what is needed");
		maingui.getSolution().setText("solution");
		
		maingui.checkComplete();
		
		assertEquals(maingui.getOrigRequestLabel().getBackground(), Color.RED);
		assertTrue(maingui.getErrorLabel().isVisible());
		assertFalse(maingui.checkComplete());
	}
	
	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test
	public void checkCompleteTestTwoFieldsBlank() throws IOException {
		
		MainGUI maingui = new MainGUI();
		
		maingui.getOffice().setSelectedItem("President");
		maingui.getDeadline().setSelectedItem("this week");
		maingui.getStatus().setSelectedItem("incomplete");
		maingui.getTimeReq().setSelectedItem("two weeks");
		maingui.getDatabase().setSelectedItem("Megahertz");
		maingui.getOrigReq().setText("");
		maingui.getNeeded().setText("");
		maingui.getSolution().setText("solution");
		
		maingui.checkComplete();
		
		assertEquals(maingui.getOrigRequestLabel().getBackground(), Color.RED);
		assertEquals(maingui.getNeededLabel().getBackground(), Color.RED);
		assertTrue(maingui.getErrorLabel().isVisible());
		assertFalse(maingui.checkComplete());
	}
	
	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test
	public void checkCompleteTestAllFieldsBlank() throws IOException {
		
		MainGUI maingui = new MainGUI();
		
		maingui.getOffice().setSelectedItem("Office");					//default value, whatever it is
		maingui.getDeadline().setSelectedItem("Deadline");				//default value, whatever it is
		maingui.getStatus().setSelectedItem("Status");					//default value, whatever it is
		maingui.getTimeReq().setSelectedItem("Time required");			//default value, whatever it is
		maingui.getDatabase().setSelectedItem("Database");				//default value, whatever it is
		maingui.getOrigReq().setText("");
		maingui.getNeeded().setText("");
		maingui.getSolution().setText("");
		
		maingui.checkComplete();
		
		assertEquals(maingui.getOrigRequestLabel().getBackground(), Color.RED);
		assertEquals(maingui.getNeededLabel().getBackground(), Color.RED);
		assertEquals(maingui.getSolutionLabel().getBackground(), Color.RED);
		assertEquals(maingui.getOffice().getBackground(), Color.RED);
		assertEquals(maingui.getDeadline().getBackground(), Color.RED);
		assertEquals(maingui.getTimeReq().getBackground(), Color.RED);
		assertEquals(maingui.getStatus().getBackground(), Color.RED);
		assertEquals(maingui.getDatabase().getBackground(), Color.RED);
		assertTrue(maingui.getErrorLabel().isVisible());
		assertFalse(maingui.checkComplete());
		
	}
	
	/**
	 * ALSO CAN TEST THIS METHOD BY RUNNING THE PROGRAM AND CLICKING THE TOGGLETRAY BUTTON
	 * @throws IOException
	 */
	@Test 
	public void testToggleTray() throws IOException {
		
		MainGUI maingui = new MainGUI();
		maingui.toggleTrayOpen();
		assertEquals(maingui.getMain().getWidth(), 724);
		assertEquals(maingui.getMain().getHeight(), 800);
		
	}
	
	@Test
	public void checkCompleteTestCorrect() throws IOException {
		
		MainGUI maingui = new MainGUI();
				
		maingui.getOffice().setSelectedItem("President");
		maingui.getDeadline().setSelectedItem("This week");
		maingui.getStatus().setSelectedItem("Incomplete");
		maingui.getTimeReq().setSelectedItem("Two weeks");
		maingui.getDatabase().setSelectedItem("Megahertz");
		maingui.getOrigReq().setText("Original request");
		maingui.getNeeded().setText("What is needed");
		maingui.getSolution().setText("Solution");
		
		assertTrue(maingui.checkComplete());
		
	}
	
}
