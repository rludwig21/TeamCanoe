package RequestLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleframework.xml.*;

@Root
public class Settings {
	@ElementList
	private List<String> databases;
	@ElementList
	private List<String> offices;
	@Element
	private int nextDB;
	@Element
	private int nextOffice;
	
	private static Settings settings;
	
	//will likely need setters on all of this to make it work when loading from server
	
	public static void setSettings(Settings settings) {
		Settings.settings = settings;
	}

	public static Settings getSettings() {
		if(settings==null) {
			settings = new Settings();
		}
		return settings;
	}
	
	private Settings() {
		setDatabases(new ArrayList<String>());
		setOffices(new ArrayList<String>());
	}
	
	private void defaultSetup() {
		databases.add(0,"Database");
		databases.add(1,"Athletics");
		databases.add(2,"Course Census");
		databases.add(3,"Faculty Census");
		databases.add(4,"Financial Aid");
		databases.add(5, "Student Census");
		nextDB = 6;
		offices.add(0,"Office");
		offices.add(1, "Admissions");
		offices.add(2, "VP of Academic Affairs");
		offices.add(3,"VP of Finance");
		offices.add(4,"Other");
		nextOffice = 5;
	}
	
	public void addOffice(String office) {
		int itemToRemove = nextOffice - 1;
		offices.remove(itemToRemove);
		offices.add(itemToRemove,office);
		offices.add(nextOffice,"Other");
		nextOffice = nextOffice + 1;
	}
	
	public void addDB(String newDB) {
		int itemToRemove = nextDB - 1;
		databases.remove(itemToRemove);
		databases.add(itemToRemove,newDB);
		nextDB = nextDB + 1;
	}

	public List<String> getDatabases() {
		return databases;
	}

	private void setDatabases(ArrayList<String> databases) {
		this.databases = databases;
	}

	public List<String> getOffices() {
		return offices;
	}

	private void setOffices(ArrayList<String> offices) {
		this.offices = offices;
	}
	
	
	
}
