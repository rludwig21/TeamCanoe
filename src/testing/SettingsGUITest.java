package testing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import GUI.MainGUI;
import GUI.SettingsGUI;

public class SettingsGUITest {
	
	
	@Test
	public void test() throws IOException {
		MainGUI main = new MainGUI();
		SettingsGUI set = new SettingsGUI(main);
		fail("Not yet implemented");
	}

}
