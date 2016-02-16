package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import RequestLogger.Database;

public class DatabaseTEST {
	
	/**Verifies that the maps generated when the system starts have the same data
	 * 
	 */
	@Test
	public void mapSizeTest() {
		Database testDB = Database.getData();
		// simulate the creation of maps on startup
		// three maps created
		
		// verify that all maps contain same data 
		// verify that all maps are not empty 
		assertEquals(testDB.getOfficeMap().size(),testDB.getDateMap().size(),testDB.getStatusMap().size());
		assertTrue(testDB.getOfficeMap().isEmpty());
	}
	
	
}
