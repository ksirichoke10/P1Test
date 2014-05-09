package edu.gatech.tests;

import edu.gatech.Constants;
import edu.gatech.GradesDB;
import edu.gatech.Student;
import junit.framework.TestCase;


public class StudentTest extends TestCase {
	
	Student test = null;
	GradesDB db = null;

	
	protected void setUp() throws Exception {
		this.db = new GradesDB(Constants.GRADES_DB);
		this.test = this.db.getStudentByName("Shevon Wise"); // The student, Shevon Wise, will be used in the below test cases
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// Test case 1: Get the name of the student being tested
	public void testGetStudentName() {
		try {
			String name = test.getName();
			assertEquals("Shevon Wise", name);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 2: Get the ID of the student being tested
	public void testGetStudentID() { 
		try {
			String id = test.getGtid();
			assertEquals("901234504", id);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 3: Get the email address of the student being tested
	public void testGetEmail() {
		try {
			String email = test.getEmail();
			assertEquals("sw@gatech.edu", email);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 4: Get the attendance of the student being tested
	// Only change that was made from TDD Part 2 was changing attendance to an int instead of a double
	// In the TDD Part 1 screenshot in the instructions, attendance was shown as an int in the output
	public void testGetAttendance() {
		try {
			int attendance = test.getAttendance();
			assertEquals(100,attendance);
		} catch (Exception e) {
			fail("Exception");
		}
	}
}
