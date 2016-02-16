package testing;

import org.junit.Test;

import RequestLogger.Log;
import static org.junit.Assert.*;

/*
 * Example of a log in XML for later use when implementing this test class
 * <log>
 *	<date>10-30-14</date>
 *	<time>14:48:07</time>
 *	<office>President's Office</office>
 *	<deadline>2</deadline>
 *	<request>List of honor's students</request>
 *	<needed>N/A</needed>
 *	<solution>Compile list and send to president</solution>
 *	<database>1</database>
 *	<time required>3</time required>
 * 	<status>2</status>
 *</log>
 *
 */
/**
 * This test class tests the transactions between the database for logs and the
 * storage database for XML logs
 */
import edu.canisius.crypto.*;

public class DatabaseTransactionsTEST {
	/**
	 * This test will be used to see if the information from the given log is
	 * correctly transfered to XML and stored into the database(s).
	 */
	@Test
	public void sendToDatabaseTest() {
		// create a log to test
		Log logIn = new Log();
		logIn.setOffice("President");
		logIn.setTimeReq("Two weeks");
		logIn.setDeadline("Two weeks");
		// figuring this out later
		// logIn.setDate("Date:");
		logIn.setOrigReq("this");
		logIn.setNeeded("is a");
		logIn.setSolution("test");
		logIn.setStatus("Complete");

		//set up a server 
		SFTPFacade server = new SFTPFacade();
		String userName = "teamcanoe";
		String password = "R4&wCa@s";
		String host = "/opt/orie/teamCanoe";
		server.connect(host, userName, password);
		// check that we are connected to database
		assertTrue(server.isConnected());
		// send a log to the database with the sendToDatabase(Log logIn)
		// receive from the database all the logs in a Priority Queue of Logs
		// iterate through logs and check to see if the log is there
		// check the specific logs info and and make sure it equals the send
		// logs data
		server.endConnection();
		// make sure we are not connected
		assertFalse(server.isConnected());

	}

	/**
	 * This test will be used to see if the information from the storage
	 * database(s) is correctly transfered from XML to the Database class.
	 */
	@Test
	public void recieveFromDatabaseTest() {
		// create a log to test
		Log logIn = new Log();
		logIn.setOffice("President");
		logIn.setTimeReq("Two weeks");
		logIn.setDeadline("Two weeks");
		// figuring this out later
		// logIn.setDate("Date:");
		logIn.setOrigReq("this");
		logIn.setNeeded("is a");
		logIn.setSolution("test");
		logIn.setStatus("Complete");
		
		//create a server
		SFTPFacade server = new SFTPFacade();
		String userName = "teamcanoe";
		String password = "R4&wCa@s";
		String host = "/opt/orie/teamCanoe";
		server.connect(host, userName, password);
		// check that we are connected to database
		assertTrue(server.isConnected());
		// send a log to the database with the sendToDatabase(Log logIn)
		// receive from the database all the logs in a Priority Queue of Logs
		// iterate through logs and check to see if the log is there
		// check the specific logs info and and make sure it equals the send
		// logs data
		server.endConnection();
		// make sure we are not connected
		assertFalse(server.isConnected());
	}

}
