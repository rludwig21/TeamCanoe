package RequestLogger;

import java.io.IOException;

import GUI.MainGUI;

/**
 * This class is used as the main for the entire project...it is where the GUI
 * is created.
 * 
 * @author Robert Lee, Andrew Ludwig, Sean Wagner, Oliver Leland
 * 
 *         DATA STRUCTURES USED: Priority Queue for loading data into the list
 *         of logs.
 * 
 */
public class Main {

	private static MainGUI MG;

	/**
	 * The main method that will instantiate the start of the GUI
	 * 
	 * @param args
	 *            arguments
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// calls load data before instantiating gui to get data for tray
		// loadData();
		MG = new MainGUI();
		 refreshLogs();
		 if(MG.logs.getComponentCount()==0) {
		 refreshLogs();
		 }
	}

	public static boolean refreshLogs() {
		try {
			MG.refreshLogs();
			MG.doNotPrefill();
			return true;
		} catch (IOException e) {
			return false;
		}

	}

	/**
	 * This method is used to load all of the logs into the list when the
	 * program starts
	 */
	public static void loadData() {
		// ALGORITHM - calls methods from database transactions to load logs
		// into tray
		DatabaseTransactions dt = new DatabaseTransactions();
		dt.getSettingsFromDB();
		dt.receiveFromDatabase();
		if (MG == null) {
			return;
		}
	}

	public static MainGUI getMainGUI() {
		return MG;
	}

}
