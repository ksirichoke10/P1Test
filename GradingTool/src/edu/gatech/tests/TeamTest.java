package edu.gatech.tests;

import java.util.ArrayList;

import junit.framework.TestCase;

import edu.gatech.Constants;
import edu.gatech.Team;
import edu.gatech.GradesDB;

public class TeamTest extends TestCase {
	Team test = null;
	GradesDB db = null;
	
	ArrayList<String> teamNames = null;
	
	ArrayList<Double> teamContributions = null;
	
	
	protected void setUp() throws Exception {
		this.db = new GradesDB(Constants.GRADES_DB);
		this.test = this.db.getProject("P1").getTeam("Team 1"); // Team 1 from P1 will be used in the below test cases
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	//Test case 1: Get the correct team number of the team being tested
	public void testGetTeamNumber() {
		try {
			String teamNumber = test.getTeamNumber();
			assertEquals("Team 1", teamNumber);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	//Test case 2: Get the grade of the team being tested
	public void testGetTeamGrade() { 
		try {
			int teamGrade = test.getTeamGrade();
			assertEquals(93, teamGrade);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 3: Get a list of names of all members of the team being tested
	public void testGetTeamNames() {
		try {
			ArrayList<String> names = new ArrayList<String>();
			names.add("Freddie Catlay");
			names.add("Shevon Wise");
			names.add("Kym Hiles");
			names.add("Ernesta Anderson");
			names.add("Sheree Gadow");
			
			ArrayList<String> result = test.getNames();
			assertEquals(names, result);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 4: Get the list of average contributions of the team being tested
	public void testGetTeamContributions() {
		try {
			ArrayList<Double> contributions = new ArrayList<Double>();
			contributions.add(new Double(9.25));
			contributions.add(new Double(9.25));
			contributions.add(new Double(9.25));
			contributions.add(new Double(9.00));
			contributions.add(new Double(7.00));
			
			ArrayList<Double> result = test.getContributions();
			assertEquals(contributions, result);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 5: Check that the student with the given name belongs to the team being tested
	public void testCheckStudent() {
		try {
			int result = test.checkStudent("Freddie Catlay");
			assertEquals(0, result);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	// Test case 6: Get the average contribution of the student with the given name (belonging to the team being tested)
	public void testGetStudentContributions() {
		try {
			double result = test.getStudentContribution("Freddie Catlay");
			assertEquals(9.25, result);
		} catch (Exception e) {
			fail("Exception");
		}
	}
}
