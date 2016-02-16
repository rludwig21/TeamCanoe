package RequestLogger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * This class is used in the "pop-out" tray for searching for specific logs. The search will first check 
 * in the current Log being processed to see if it fits the requirements of the search, then will go
 * to the database being worked with and grab the rest of the Logs that meet the requirements.
 * 
 * @author Robert Lee, Andrew Ludwig, Sean Wagner, Oliver Leland
 * 
 * DATABASES USED: Priority Queue - sets jlist of logs by complete/incomplete and potentially date
 *
 */
public class Search {

	
	/**
	 * This method is used to send the information from the search fields back to
	 * main to use.
	 * @param field - The string selected from the comboBox
	 * @param search - The string entered into the refine field
	 * @throws ParseException 
	 */
	public void search(String fieldIn, String refineIn) throws ParseException {

		Database db = Database.getData();
		//ALGORITHM - depending on what field is selected from the combo box, the algorithm will be set up in an if-else form
		//that will run separate algorithms based on the field in
		if(fieldIn.equals("Office")) {
			char first = Character.toUpperCase(refineIn.charAt(0));
			String newRefineIn = first + refineIn.substring(1);
			refineIn.charAt(0);
			Map<String,LinkedList<Log>> offMap = db.getOfficeMap();
			LinkedList<Log> freshList = offMap.get(newRefineIn);
			db.setViewablePQ(freshList);
			Main.refreshLogs();
		} else if(fieldIn.equals("Date (YYYYMMDD)")) {
			if(refineIn.length()!=8) {
				JOptionPane.showMessageDialog(Main.getMainGUI(), "Date is not properly formatted.", "Search Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if(!isInteger(refineIn)) {
				JOptionPane.showMessageDialog(Main.getMainGUI(), "Date is not properly formatted.", "Search Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Map<String,LinkedList<Log>> dateMap = db.getDateMap();
			DatabaseTransactions gegen = new DatabaseTransactions();
			LinkedList<Log> freshList = new LinkedList<Log>();
			SimpleDateFormat hamlet = new SimpleDateFormat("yyyyMMdd");
			Date currentDate = hamlet.parse(refineIn);
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(Calendar.DATE, -7);
			for (int i = 0; i < 14; i++){
				cal.add(Calendar.DATE, +1);
				Date currentD = (cal.getTime());
				String j = hamlet.format(currentD);
				if (dateMap.get(j)!=null){
					//linked list of logs that is returned from map
					LinkedList<Log> list = dateMap.get(j);
					//gets an iterator of above list to run through and check if already in the complete search results list
					Iterator<Log> it = list.iterator();
					while(it.hasNext()) {
						//gets the next log in it
						Log currentLog = it.next();
						//if the log is not in the complete search result list, add its
						if(!freshList.contains(currentLog)) {
							freshList.add(currentLog);
						}
					}
				}
			}
			LinkedList<Log> zwei = gegen.loadToPQ(freshList);
			db.setViewablePQ(zwei);
			Main.refreshLogs();
		} else if(fieldIn.equals("Status")) {
			if(refineIn.toLowerCase().equals("incomplete")||refineIn.toLowerCase().equals("complete")){
				char first = Character.toUpperCase(refineIn.charAt(0));
				String newRefineIn = first + refineIn.substring(1);
				refineIn.charAt(0);
				Map<String,LinkedList<Log>> offMap = db.getStatusMap();
				LinkedList<Log> freshList = offMap.get(newRefineIn);
				DatabaseTransactions ohne = new DatabaseTransactions();
				LinkedList<Log> drei = ohne.loadToPQ(freshList);
				db.setViewablePQ(drei);
				Main.refreshLogs();
			}
			else{
				JOptionPane.showMessageDialog(Main.getMainGUI(), "This is not a valid status. Please use either \"complete\" or \"incomplete\".", "Search Error", JOptionPane.ERROR_MESSAGE);
				return;
			}	
		}
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
