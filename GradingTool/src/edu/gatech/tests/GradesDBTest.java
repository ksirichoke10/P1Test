package edu.gatech.tests;

import java.util.ArrayList;

import java.util.HashSet;

import junit.framework.TestCase;
import edu.gatech.Assignment;
import edu.gatech.Constants;
import edu.gatech.GradesDB;
import edu.gatech.Project;
import edu.gatech.Student;
import edu.gatech.Team;

public class GradesDBTest extends TestCase {
	GradesDB db = null;
	ArrayList<Team> teams = null;
	ArrayList<Integer> grades = null;
	
	protected void setUp() throws Exception {
		db = new GradesDB(Constants.GRADES_DB);

		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}	

	public void testGetNumStudents() {
		try {
			int numStudents = db.getNumStudents();
			assertEquals(14, numStudents);
		} catch (Exception e) {
			fail("Exception");
		}
	}	
	
	public void testGetNumAssignments() {
		try {
			int numAssignments = db.getNumAssignments();
			assertEquals(3, numAssignments);
		} catch (Exception e) {
			fail("Exception");
		}
	}

	
	public void testGetNumProjects() {
		int numProjects;
		try {
			numProjects = db.getNumProjects();
			assertEquals(3, numProjects);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	
	public void testGetStudents1() {
		HashSet<Student> students = null;
		try {
			students = db.getStudents();
		} catch (Exception e) {
			fail("Exception");
		}
		assertEquals(14, students.size());
	}
	
	

	public void testGetStudents2() {
		HashSet<Student> students = null;
		try {
			students = db.getStudents();
		} catch (Exception e) {
			fail("Exception");
		}
		boolean found = false;
		for (Student s : students) {
			if ((s.getName().compareTo("Cynthia Faast") == 0) && (s.getGtid().compareTo("901234514") == 0)) {
				found = true;
				break;
			}
		}
		assertTrue(found);
	}	
	
	public void testGetStudentsByName1(){
		Student student = null;
		try {
			student = db.getStudentByName("Rastus Kight");
		} catch (Exception e) {
			fail("Exception");
		}
		assertTrue(student.getGtid().compareTo("901234512") == 0);
	}

	public void testGetStudentsByName2(){
		Student student = null;
		try {
			student = db.getStudentByName("Grier Nehling");
		} catch (Exception e) {
			fail("Exception");
		}
		assertEquals(96, student.getAttendance());
	}

	public void testGetStudentsByID(){
		try {
			Student student = db.getStudentByID("901234504");
			assertTrue(student.getName().compareTo("Shevon Wise") == 0);
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	//The below tests were added in TDD Part 2
	
	// Test case 1: Get the list of student names. The first name in the list should be Freddie Catlay
		public void testGetStudentList() {
			try {
				ArrayList<String> test = db.getStudentList();
				assertEquals(test.get(0), "Freddie Catlay");
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		// Test case 2: Get the basic information of the student with the given ID
		// Changes made from TDD Part 2 - getStudentInfo() takes in a student name as a parameter, not a student ID (initially had)
		// Made a string called "output" with the expected output
		public void testGetStudentInfo() {
			try {
				/*
				String test = db.getStudentInfo("901234501");
				*/
				String test = db.getStudentInfo("Freddie Catlay");
				Student s = db.getStudentByName("Freddie Catlay");
				String output = "Name: " + s.getName()+"\n"+
								"GT ID: "+ s.getGtid()+"\n"+
								"Email: "+s.getEmail()+"\n"+
								"Attendance: "+ s.getAttendance()+"%";
				assertEquals(test,output);
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		// Test case 3: Get the list of projects belonging to the student with the given ID. The first project in the list should be P1
		// Only minor change made from TDD Part 2 was the parameter for getStudentProjects() is the student's name, not student ID
		public void testGetStudentProjects() {
			try {
				ArrayList<Project> projects = db.getStudentProjects("Freddie Catlay");
				assertEquals(projects.get(0).getNumber(), "P1");
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		// Test case 4: Get the list of all the assignments (done by all the students). The first assignment in the list should be Assignment 1
		public void testGetStudentAssignments() {
			try {
				ArrayList<Assignment> assignments = db.getStudentAssignments();
				assertEquals(assignments.get(0).getNumber(), "Assignment 1");
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		// Test case 5: Get the project with the given project number
		public void testGetProject() {
			try {
				Project test = db.getProject("P1");
				assertEquals(test.getNumber(), "P1");
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		// Test case 6: Get the assignment with the given assignment number
		public void testGetAssignment() {
			try {
				Assignment test = db.getAssignment("Assignment 1");
				assertEquals(test.getNumber(), "Assignment 1");
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		// Test case 7: Outputs a toString that includes the basic information, project information, and assignment information belonging to the specified student
		// Only minor changes made from TDD Part 2 was changing the p2 and p3 strings from initially being blank to saying-
			// "Projects done by Freddie Catlay:\n" and "Assignments done by Freddie Catlay:\n" respectively
		public void testGetAllStudentInfo() {
			try {
				String p1 = db.getStudentInfo("Freddie Catlay") + "\n";
			
				String p2 = "Projects done by Freddie Catlay:\n";
				ArrayList<Project> projects = db.getStudentProjects("Freddie Catlay");
				for (int i = 0; i < projects.size(); i++) {
					p2 += "\n"+ projects.get(i).toString("Freddie Catlay") + "\n";
				}
			
				String p3 = "Assignments done by Freddie Catlay:\n";
				ArrayList<Assignment> assignments = db.getStudentAssignments();
				for (int i = 0; i < assignments.size(); i++) {
					p3 += "\n" +assignments.get(i).toString("Freddie Catlay") + "\n";
				}
				
				String test = db.getAllStudentInfo("Freddie Catlay");
				assertEquals(test, p1 + "\n" + p2 + "\n"+ p3);	
			} catch (Exception e) {
				fail("Exception");
			}
		}
		
		
}
