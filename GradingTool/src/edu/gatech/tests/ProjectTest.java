package edu.gatech.tests;

import edu.gatech.Constants;
import edu.gatech.GradesDB;
import edu.gatech.Project;
import edu.gatech.Team;
import junit.framework.TestCase;


public class ProjectTest extends TestCase{
	
	Project test = null;
	GradesDB db = null;

	protected void setUp() throws Exception {
		this.db = new GradesDB(Constants.GRADES_DB);
		this.test = this.db.getProject("P1"); // P1 will be used in the below test cases
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	// Test case 1: Get the name of the project being tested
	public void testGetProjectNumber() {
		try {
			String projectNumber = test.getNumber();
			assertEquals("P1", projectNumber);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 2: Get the project description of the project being tested
	public void testGetProjectDescription() { 
		try {
			String projDescrip = test.getDescription();
			assertEquals("WordCount in Java", projDescrip);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 3: Get the average grade of the project being tested
	public void testGetAverageGrade() {
		try {
			double avgGrade = test.getAvgGrade();
			assertEquals(93.0, avgGrade);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 4: Get the team with the given team number and make sure the team numbers match
	public void testGetTeam() {
		try {
			Team result = test.getTeam("Team 1");
			assertEquals("Team 1", result.getTeamNumber());
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 5: Get the team the specified student belongs to and make sure the team numbers match
	public void testGetStudentTeam() {
		try {
			Team result = test.getStudentTeam("Freddie Catlay");
			assertEquals("Team 1", result.getTeamNumber());
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 6: Outputs a toString consisting of project details for a specific student
	// Only change that was made from TDD Part 2 was changing the "value" string slightly from
	// "-Project 1\n" to "Project Number: P1\n" and the value of Average Grade from 93 to 93.0
	public void testToString() {
		try {
			String result = test.toString("Freddie Catlay");			
			String value = "Project Number: P1\n" +
						   "Team 1 Grade: 93\n" +
						   "Average Grade: 93.0\n" +
						   "Average Contribution: 9.25";			
			assertEquals(value, result);
		} catch (Exception e) {
			fail("Exception");
		}	
	}
}
