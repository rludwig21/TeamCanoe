package RequestLogger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.*;

import edu.canisius.crypto.SFTPFacade;

//this class should be done, errors will be discoved as testing continues -sean
/**
 * This class is going to handle all interaction with the database(s). When anything is going to be sent to
 * the database or received from it, this class will be utilized. 
 * 
 * @author Robert Lee, Andrew Ludwig, Sean Wagner, Oliver Leland
 * 
 * DATASTRUCTURES USED: PriorityQueue
 * 
 */
public class DatabaseTransactions {
	
	//done
	/**
	 * This method will test sending all of the information to the selected database
	 * to be stored.
	 * @throws Exception 
	 */
	public boolean sendToDatabase(Log logIn) throws ServerNotConnectedException {
		
		try{
			//connect to the server with our information
			Database data = Database.getData();
			SFTPFacade server = new SFTPFacade();
			server.connect(data.getServerHost(), data.getUser(), data.getPass());
			
			String severFileLoc = data.getServerDir() + logIn.getFileName() + data.getFileExtension();
			String localFileLoc = logIn.getFileName() + data.getFileExtension();
			Serializer serializer = new Persister();
			File result = new File(localFileLoc);
			serializer.write(logIn, result);
			
			if(!server.isConnected()){
				throw new ServerNotConnectedException();
			}
			
			server.uploadFile(localFileLoc, severFileLoc);   //stores files as: YYYYMMDD_LogId
			result.delete();
			receiveFromDatabase();
			Main.refreshLogs();
			return true;
			
		} catch(Exception e) {
			return false;
		}
	}
	
	public Settings getSettingsFromDB() {
		createDir();
		Database data = Database.getData();
		SFTPFacade server = new SFTPFacade();
		server.connect(data.getServerHost(), data.getUser(), data.getPass());
		if(!server.isConnected()) {
			throw new ServerNotConnectedException();
		}
		String locFile = data.getLocalFileDir()+data.getSettingsFileName()+data.getFileExtension();
		String remFile = data.getServerDir() + data.getSettingsFileName() + data.getFileExtension();
		if(server.fileExists(remFile)) {
			server.downloadFile(locFile, remFile);
			Serializer serializer = new Persister();
			File source = new File(locFile);
			try {
				Settings l = serializer.read(Settings.class, source);
				Settings.setSettings(l);
				source.delete();
				removeDir();
				return l;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}	
		}
		return null;
	}
	public boolean sendSettingsToDB() throws Exception {
		Settings s = Settings.getSettings();
		createDir();
		Database data = Database.getData();
		SFTPFacade server = new SFTPFacade();
		server.connect(data.getServerHost(), data.getUser(), data.getPass());
		String locFile = data.getLocalFileDir()+data.getSettingsFileName()+data.getFileExtension();
		String remFile = data.getServerDir() + data.getSettingsFileName() + data.getFileExtension();
		File result = new File(locFile);
		Serializer serializer = new Persister();
		serializer.write(s, result);
		if(!server.isConnected()){
			throw new ServerNotConnectedException();
		}
		server.uploadFile(locFile, remFile);   //stores files as: YYYYMMDD_LogId
		result.delete();
		receiveFromDatabase();
		Main.refreshLogs();
		return true;
	}
	
	//done
	/**
	 * This method will be used to test to receive all of the information from the database
	 * when the user requests a specific log.  
	 */
	public LinkedList<Log> receiveFromDatabase() {
		
		createDir();
		//connect to the server with our information
		Database data = Database.getData();
		SFTPFacade server = new SFTPFacade();
		server.connect(data.getServerHost(), data.getUser(), data.getPass());
		if(!server.isConnected()) {
			throw new ServerNotConnectedException();
		}
		List<String> l = server.directoryListing(data.getServerDir());
		LinkedList<Log> logs = new LinkedList<Log>();
		
		for(String file:l){
			if(file.equals(data.getSettingsFileName()+data.getFileExtension())||file.equals(data.getSettingsFileName())){
				continue;
			}
			Log log = downloadLog(server,file);
			logs.add(log);
			addToOfficeMap(log);
			addToStatusMap(log);
			addToDateMap(log);
		}
		
		getNextLogNum(logs);
		LinkedList<Log> retVal = loadToPQ(logs);
		
		data.setDefaultPQ(retVal);
		data.setViewablePQ(retVal);
		removeDir();
		
		return retVal;
	}
	
	public boolean updateLog(Log log) throws ServerNotConnectedException{
		Database data = Database.getData();
		SFTPFacade server = new SFTPFacade();
		server.connect(data.getServerHost(), data.getUser(), data.getPass());
		if(!server.isConnected()) {
			throw new ServerNotConnectedException();
		}
		String logToDelete = data.getServerDir() + log.getFileName()+data.getFileExtension();
		if(server.fileExists(logToDelete)) {
			server.deleteFile(logToDelete);
		}
		try {
			sendToDatabase(log);
		} catch (Exception e) {
			
		}
		return true;
	}
	
	//done
	private void addToOfficeMap(Log log) {
		
		Database data = Database.getData();
		Map<String,LinkedList<Log>> officeMap = data.getOfficeMap();
		
		if(!officeMap.containsKey(log.getOffice())){
			LinkedList<Log> ll = new LinkedList<Log>();
			officeMap.put(log.getOffice(), ll);
		}
		
		LinkedList<Log> ll = officeMap.get(log.getOffice());
		ll.add(log);
		
	}

	//done
	private void addToStatusMap(Log log) {
		
		Database data = Database.getData();
		Map<String,LinkedList<Log>> statusMap = data.getStatusMap();
		
		if(!statusMap.containsKey(log.getStatus())){
			LinkedList<Log> ll = new LinkedList<Log>();
			statusMap.put(log.getStatus(), ll);
		}
		
		LinkedList<Log> ll = statusMap.get(log.getStatus());
		ll.add(log);
		
	}
	
	//done
	private void addToDateMap(Log log) {
		
		Database data = Database.getData();
		Map<String,LinkedList<Log>> dateMap = data.getDateMap();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String mapDate = sdf.format(log.getDate());
		
		if(!dateMap.containsKey(mapDate)){
			LinkedList<Log> ll = new LinkedList<Log>();
			ll.add(log);
			dateMap.put(mapDate, ll);
		} else{
			LinkedList<Log> ll = dateMap.get(mapDate);
			ll.add(log);
		}
		
	}
	
	
	
	//done
	protected LinkedList<Log> loadToPQ(LinkedList<Log> logs) {
		//completeList
		LinkedList<Log> completeList = new LinkedList<Log>();
		//incompleteList
		LinkedList<Log> incompleteList = new LinkedList<Log>();
		
		LinkedList<Log> retVal = new LinkedList<Log>();
		Iterator<Log> it = logs.iterator();
		
		while(it.hasNext()) {
			Log l = it.next();
			if(l.getStatus().equals("Complete")) {
				completeList.add(l);
			} else if(l.getStatus().equals("Incomplete")) {
				incompleteList.add(l);
			}
		}
		
		for(Log l : incompleteList) {
			retVal.add(l);
		}
		for(Log l : completeList) {
			retVal.add(l);
		}
		
		return retVal;
		
	}
	
	//done
	private void createDir() {
		new File("temp").mkdir();
	}
	
	//done
	private void removeDir() {
		File f = new File("temp");
		f.delete();
	}
	
	//done
	private int getNextLogNum(LinkedList<Log> logs) {
		
		int highest = 1;
		Iterator<Log> it = logs.iterator();
		
		while(it.hasNext()) {
			Log l = it.next();
			int current = l.getId();
			if(current>highest) {
				highest = current;
			}
		}
		
		highest = highest + 1;
		Log.setNextLogId(highest);
		return highest;
		
	}
	
	//done
	private Log downloadLog(SFTPFacade server,String logName) throws ServerNotConnectedException {
		try{
			Database data = Database.getData();
			if(!server.isConnected()) {
				throw new ServerNotConnectedException();
			}
			String remFile = data.getServerDir()+logName;
			String locFile = "temp/"+logName;
			server.downloadFile(locFile, remFile);
			Serializer serializer = new Persister();
			File source = new File(locFile);
			Log l = serializer.read(Log.class, source);
			source.delete();
			return l;
			
		}
		catch(Exception e){
			return null;
		}
	}
	
}
