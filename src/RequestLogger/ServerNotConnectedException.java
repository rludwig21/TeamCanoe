package RequestLogger;

import javax.swing.JOptionPane;

public class ServerNotConnectedException extends RuntimeException {
	public ServerNotConnectedException(){
		super();
		
		int choice = JOptionPane.showOptionDialog(null, 
			      "No server found. Would you like to quit?", 
			      "Server Not Found", 
			      JOptionPane.YES_NO_OPTION, 
			      JOptionPane.QUESTION_MESSAGE, 
			      null, null, null);
			 
			  // interpret the user's choice
			  if (choice == JOptionPane.YES_OPTION)
			  {
			    System.exit(0);
			  }
	}
	
	public ServerNotConnectedException(String s){
		super(s);
	}
}
