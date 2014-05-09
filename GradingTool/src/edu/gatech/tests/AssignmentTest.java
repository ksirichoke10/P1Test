package edu.gatech.tests;

import edu.gatech.Assignment;
import edu.gatech.Constants;
import edu.gatech.GradesDB;
import junit.framework.TestCase;

public class AssignmentTest extends TestCase {
	
	Assignment test = null;
	GradesDB db = null;
	
	protected void setUp() throws Exception {
		this.db = new GradesDB(Constants.GRADES_DB);
		this.test = this.db.getAssignment("Assignment 1"); //Assignment 1 will be used in the below test cases
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// Test case 1: Get the name of the assignment being tested
	public void testGetAssignmentNumber() {
		try {
			String assignmentNumber = test.getNumber();
			assertEquals("Assignment 1", assignmentNumber);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 2: Get the assignment description of the assignment being tested
	public void testGetAssignmentDescription() { 
		try {
			String assignDescrip = test.getDescription();
			assertEquals("swiki page", assignDescrip);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 3: Get the average grade of the assignment being tested
	public void testGetAverageGrade() {
		try {
			double avgGrade = test.getAvgGrade();
			assertEquals(99, (int) avgGrade);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 4: Get the assignment grade for the given student name
	public void testGetStudentGrade() {
		try {
			Integer result = test.getStudentGrade("Freddie Catlay");
			assertEquals(new Integer(100), result);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	
	// Test case 5: Outputs a toString consisting of assignment details for a specific student
	// Only change that was made from TDD Part 2 was changing the "value" string slightly from
	// "-Assignment 1\n" to "Assignment Number: Assignment 1\n" and the value of Average Class Grade from 99 to 99.0
	public void testToString() {
		try {
			String result = test.toString("Freddie Catlay");				
			String value = "Assignment Number: Assignment 1\n" +
						   "Student Grade: 100\n" +
						   "Average Class Grade: 99.0";			
			assertEquals(value, result);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	
	
	
	
	

}
