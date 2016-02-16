package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import RequestLogger.DatabaseTransactions;
import RequestLogger.Settings;

/**
 * This class allows settings to be modified such as adding and removing(version 2.0) a database
 * or office using an graphical interface.
 * 
 * IMPORTANT: databases/offices are not deleted from older logs for history
 * 
 * @author Robert Lee, Andrew Ludwig, Sean Wagner, Oliver Leland
 * 
 */

@SuppressWarnings("serial")
public class SettingsGUI extends JFrame implements ActionListener,
		WindowListener {
	/**
	 * Parent frame. aka where the settings GUI request came from.
	 */
	private MainGUI parentGUI;

	/**
	 * Settings Frame.
	 */
	private JFrame settings;

	// OFFICE SETTINGS-----------------------------------
	/**
	 * Label for the general office settings.
	 */
	private JLabel officeLabel;
	/**
	 * Label for the office name.
	 */
	private JLabel officeLabel2;
	/**
	 * Label to denote the combobox office removals.
	 */
	private JLabel officeLabel3;
	/**
	 * Field to type in the new office name.
	 */
	private JTextField newOfficeName;
	/**
	 * Button to handle adding a new office to the offices combobox.
	 */
	private JButton addOffice;
	/**
	 * Combobox which reflects the current mainGUI offices or anything added to
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox offices;
	/**
	 * Button to handle removing office
	 */
	private JButton removeOffice;

	// DATABASE SETTINGS-----------------------------------
	/**
	 * Label for the General Database settings.
	 */
	private JLabel databaseLabel;
	/**
	 * Label for adding a database.
	 */
	private JLabel databaseLabel2;
	/**
	 * Label for removing a database.
	 */
	private JLabel databaseLabel3;
	/**
	 * Field to enter a new database name.
	 */
	private JTextField newDatabase;
	/**
	 * Button to handle adding a database
	 */
	private JButton addDatabase;
	/**
	 * Combobox to hold the databases for removal.
	 */
	@SuppressWarnings("rawtypes")
	private JComboBox database;
	/**
	 * array of strings to be used by the database combobox.
	 */
	private String[] databaseStrings = { "Database",
			"ASK HERTZ OR FIND IN NOTES" };
	/**
	 * Button to remove selected database
	 */
	private JButton removeDatabase;

	// Other-----------------------------------
	/**
	 * Exits to MainGUI and saves no changes
	 */
	private JButton cancel;

	// horizontal rules (Jseperators)
	private JSeparator hr;
	private JSeparator hr2;
	private JSeparator hr3;
	private JSeparator hr4;
	private JSeparator hr5;
	private JSeparator hr6;
	private JSeparator hr7;
	/**
	 * Label for the info. version, name, authors....
	 */
	private JLabel info;
	/**
	 * image for icon
	 */
	private ImageIcon imgIcon = new ImageIcon(
			"/TeamCanoe/src/GUI/canisiusicon.jpg");

	/**
	 * Constructor for SettingsGUI.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SettingsGUI(MainGUI main) {
		parentGUI = main;
		parentGUI.getMain().setEnabled(false);
		// FRAME---------------------------------------------
		settings = new JFrame("ELSA Settings");
		settings.setResizable(false);
		settings.setType(Type.POPUP);
		settings.setIconImage(imgIcon.getImage());
		settings.setForeground(new Color(237, 178, 45));
		settings.getContentPane().setBackground(new Color(2, 34, 67));
		settings.getContentPane().setLayout(null);
		settings.setDefaultCloseOperation(HIDE_ON_CLOSE);
		settings.setSize(450, 450);
		settings.setVisible(true);
		settings.addWindowListener(this);

		// Cancel Button
		cancel = new JButton("Close Settings");
		cancel.setBounds(154, 198, 145, 50);
		settings.getContentPane().add(cancel);
		cancel.addActionListener(this);

		// OFFICE SETTINGS------------------------------------
		officeLabel = new JLabel();
		officeLabel.setText("Office Settings");
		officeLabel.setBounds(10, 11, 107, 25);
		officeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		officeLabel.setForeground(new Color(239, 178, 45));
		settings.getContentPane().add(officeLabel);

		// label for text field
		officeLabel2 = new JLabel();
		officeLabel2.setText("Enter a new Office name below:");
		officeLabel2.setBounds(10, 35, 254, 25);
		officeLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		officeLabel2.setForeground(Color.WHITE);
		settings.getContentPane().add(officeLabel2);

		// new office name
		newOfficeName = new JTextField();
		newOfficeName.setBounds(10, 65, 254, 25);
		settings.getContentPane().add(newOfficeName);

		// add office button
		addOffice = new JButton("Add Office");
		addOffice.setBounds(279, 65, 145, 24);
		addOffice.addActionListener(this);
		settings.getContentPane().add(addOffice);
		
		//******************************************FOR VERSION 2.0
		// Office Combobox
		offices = new JComboBox();
		offices.setBounds(10, 137, 254, 25);
		//settings.getContentPane().add(offices);

		//******************************************FOR VERSION 2.0
		removeOffice = new JButton("Remove Office");
		removeOffice.setSize(145, 25);
		removeOffice.setLocation(279, 137);
		removeOffice.setBounds(279, 65, 145, 24);
		settings.getContentPane().add(removeOffice);
		//removeOffice.setVisible(false);
		
		//******************************************FOR VERSION 2.0
		officeLabel3 = new JLabel();
		officeLabel3.setText("Select a Office name below to remove:");
		officeLabel3.setForeground(Color.WHITE);
		officeLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		officeLabel3.setBounds(10, 101, 254, 25);
		settings.getContentPane().add(officeLabel3);
		officeLabel3.setVisible(false);

		// DATABASE SETTINGS----------------------------------
		databaseLabel = new JLabel();
		databaseLabel.setText("Database Settings");
		databaseLabel.setForeground(new Color(239, 178, 45));
		databaseLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		databaseLabel.setBounds(10, 101, 145, 25);
		settings.getContentPane().add(databaseLabel);

		databaseLabel2 = new JLabel();
		databaseLabel2.setText("Enter a new Database name below:");
		databaseLabel2.setForeground(Color.WHITE);
		databaseLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		databaseLabel2.setBounds(10, 125, 254, 25);
		settings.getContentPane().add(databaseLabel2);

		newDatabase = new JTextField();
		newDatabase.setBounds(10, 148, 254, 25);
		settings.getContentPane().add(newDatabase);

		addDatabase = new JButton("Add Database");
		addDatabase.setBounds(279, 148, 145, 24);
		addDatabase.addActionListener(this);
		settings.getContentPane().add(addDatabase);
		//******************************************FOR VERSION 2.0
		databaseLabel3 = new JLabel();
		databaseLabel3.setEnabled(false);
		databaseLabel3.setText("Select a Database name below to remove:");
		databaseLabel3.setForeground(Color.WHITE);
		databaseLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		databaseLabel3.setBounds(10, 263, 254, 25);
		settings.getContentPane().add(databaseLabel3);
		databaseLabel3.setVisible(false);
		//******************************************FOR VERSION 2.0
		database = new JComboBox(databaseStrings);
		database.setEnabled(false);
		database.setBounds(10, 299, 254, 25);
		settings.getContentPane().add(database);
		database.setVisible(false);
		//******************************************FOR VERSION 2.0
		removeDatabase = new JButton("Remove Database");
		removeDatabase.setEnabled(false);
		removeDatabase.setBounds(279, 300, 145, 25);
		settings.getContentPane().add(removeDatabase);
		removeDatabase.setVisible(false);
		

		// Horizontal rules(Separators)--------------------------------------
		hr = new JSeparator(SwingConstants.HORIZONTAL);
		hr.setBounds(10, 35, 115, 1);
		hr.setForeground(new Color(239, 178, 45));
		settings.getContentPane().add(hr);

		hr2 = new JSeparator(SwingConstants.HORIZONTAL);
		hr2.setForeground(new Color(239, 178, 45));
		hr2.setBounds(0, 101, 434, 3);
		settings.getContentPane().add(hr2);

		hr3 = new JSeparator(SwingConstants.HORIZONTAL);
		hr3.setForeground(new Color(239, 178, 45));
		hr3.setBounds(10, 125, 115, 1);
		settings.getContentPane().add(hr3);

		hr4 = new JSeparator(SwingConstants.HORIZONTAL);
		hr4.setForeground(new Color(239, 178, 45));
		hr4.setBounds(0, 184, 434, 3);
		settings.getContentPane().add(hr4);

		hr5 = new JSeparator(SwingConstants.HORIZONTAL);
		hr5.setForeground(new Color(239, 178, 45));
		hr5.setBounds(0, 11, 434, 3);
		settings.getContentPane().add(hr5);

		hr6 = new JSeparator(SwingConstants.HORIZONTAL);
		hr6.setForeground(new Color(239, 178, 45));
		hr6.setBounds(126, 259, 198, 1);
		settings.getContentPane().add(hr6);

		hr7 = new JSeparator(SwingConstants.HORIZONTAL);
		hr7.setForeground(new Color(239, 178, 45));
		hr7.setBounds(126, 399, 198, 1);
		settings.getContentPane().add(hr7);

		// information
		info = new JLabel();
		info.setBackground(new Color(2, 34, 67));
		info.setText("<html><div style=\"text-align: center;\">ELSA ver: 1.0 <br>Extreme Log Storing Application<br>by<br>Andrew Ludwig<br>Oliver Leland<br>Robert Lee<br>Sean Wagner<br></html>");
		info.setForeground(new Color(237, 178, 45));
		info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		info.setBounds(126, 259, 198, 141);
		settings.getContentPane().add(info);

		// Center the entire GUI
		centerWindow(settings);
		settings.setAlwaysOnTop(true);
		settings.setEnabled(true);
	}

	/**
	 * Method that handles any actions prefromed within the GUI
	 */
	@Override
	public void actionPerformed(ActionEvent s) {
		if (s.getSource().equals(cancel)) {
			parentGUI.getMain().setEnabled(true);
			settings.dispose();
		} else if (s.getSource().equals(addOffice)) {
			String newOffice = newOfficeName.getText();
			System.out.println(newOffice);
			Settings set = Settings.getSettings();
			set.addOffice(newOffice);
			DatabaseTransactions dt = new DatabaseTransactions();
			try {
				dt.sendSettingsToDB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parentGUI.getOffice().removeItem("Other");
			parentGUI.getOffice().addItem(newOffice);
			parentGUI.getOffice().addItem("Other");
			parentGUI.getOffice().validate();
			newOfficeName.setText("");
			JOptionPane.showMessageDialog(settings, "A new office has been added to ELSA.", "Created", 0);
		} else if (s.getSource().equals(removeOffice)) {

		} else if (s.getSource().equals(addDatabase)) {
			String newDB = newDatabase.getText();
			System.out.println(newDB);
			Settings set = Settings.getSettings();
			set.addDB(newDB);
			DatabaseTransactions dt = new DatabaseTransactions();
			try {
				dt.sendSettingsToDB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parentGUI.getDatabase().addItem(newDB);
			parentGUI.getDatabase().validate();
			newDatabase.setText("");
			JOptionPane.showMessageDialog(settings, "A new database has been added to ELSA.", "Created", 0);
		} else if (s.getSource().equals(removeDatabase)) {

		}
	}

	/**
	 * Method to make the given frame centered in the screen.
	 * 
	 * @param frame
	 *            the frame that is to be centered.
	 */
	public static void centerWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 5);
		frame.setLocation(x, y);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		

	}

	
	public void windowClosing(WindowEvent arg0) {
		//
		parentGUI.getMain().setEnabled(true);
		settings.dispose();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}