package RequestLogger;

import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is used to store the specific instance of data currently being processed.
 * 
 * @author Robert Lee, Andrew Ludwig, Sean Wagner, Oliver Leland 
 *
 */
public class Database {
	
	private static Database data;
	
	private String localFileDir;
	
	private String fileExt;
	
	private Map<String,LinkedList<Log>> officeMap;
	
	private Map<String,LinkedList<Log>> statusMap;
	
	private Map<String,LinkedList<Log>> dateMap; //in YYYYMMDD format
	
	//need setters and getters for this and viewable pq
	private LinkedList<Log> defaultPQ;
	
	private LinkedList<Log> viewablePQ;
	
	private String serverHost;
	
	private String serverUser;
	
	private String serverPass;
	
	private String serverDirectory;
	
	private String settingsFileName;
	
	public String getSettingsFileName() {
		return settingsFileName;
	}

	/**
	 * The constructor for the Database class - private for singleton class
	 */
	private Database() {
		serverUser = "teamcanoe";
		serverPass = "R4&wC*@s";
		serverHost = "megahertz.canisius.edu";
		serverDirectory = "/opt/orie/teamCanoe/";
		localFileDir = "temp/";
		fileExt = ".xml";
		officeMap = new HashMap<String,LinkedList<Log>>();
		statusMap = new HashMap<String,LinkedList<Log>>();
		dateMap = new HashMap<String,LinkedList<Log>>();
		defaultPQ = new LinkedList<Log>();
		viewablePQ = defaultPQ;
		settingsFileName = "Settings";
	}
	
	/**
	 * This method allows the program to prevent multiple instances
	 * from being created.
	 * 
	 * @return Single instance of the data class.
	 */
	public static Database getData() {
		if (data==null) {
			data = new Database();
		}
		return data;
	}
	
	public LinkedList<Log> getViewablePQ() {
		return viewablePQ;
	}
	
	public void setViewablePQ(LinkedList<Log> pq) {
		viewablePQ = pq;
	}
	
	public void setDefaultPQ(LinkedList<Log> pq) {
		defaultPQ = pq;
	}
	
	public Map<String,LinkedList<Log>> getOfficeMap(){
		return officeMap;
	}
	
	public String getFileExtension() {
		return fileExt;
	}

	public Map<String,LinkedList<Log>> getStatusMap(){
		return statusMap;
	}
	
	public Map<String,LinkedList<Log>> getDateMap(){
		return dateMap;
	}
	
	public String getUser() {
		return serverUser;
	}
	
	public String getPass() {
		return serverPass;
	}
	
	public String getServerHost() {
		return serverHost;
	}
	
	public String getServerDir() {
		return serverDirectory;
	}
	
	public String getLocalFileDir() {
		return localFileDir;
	}
}
