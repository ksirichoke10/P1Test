package edu.gatech;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GradesDB {	
	
	//Class variables for workbook,sheets used, and data structures
	XSSFWorkbook wb;
	XSSFSheet sheet; // Details sheet
	XSSFSheet sheet2; // Data sheet
	XSSFSheet sheet3; // Attendance sheet
	XSSFSheet sheet4; // P1 Teams
	XSSFSheet sheet5; // P1 Contributions
	XSSFSheet sheet6; // P1 Grades
	XSSFSheet sheet7; // P2 Teams
	XSSFSheet sheet8; // P2 Contributions
	XSSFSheet sheet9; // P2 Grades
	XSSFSheet sheet10; // P3 Teams
	XSSFSheet sheet11; // P3 Contributions
	XSSFSheet sheet12; // P3 Grades
	XSSFSheet sheet13; // Grades
	
	LinkedHashMap<String, Project> projectMap = null;	
	LinkedHashMap<String, Assignment> assignmentMap = null;	
	HashSet<Student> students = null;
	ArrayList<String> orderedStudents = null;
	
	//Constructor 
	public GradesDB(String gradesDb){
		
		this.students = new HashSet<Student>();
		this.projectMap = new LinkedHashMap<String, Project>();
		this.assignmentMap = new LinkedHashMap<String, Assignment>();
		this.orderedStudents = new ArrayList<String>();
		
		try{
			FileInputStream file = new FileInputStream(new File(gradesDb));
			wb = new XSSFWorkbook(file);		
			sheet = wb.getSheet("Details");	
			sheet2 = wb.getSheet("Data");
			sheet3 = wb.getSheet("Attendance");
			sheet4 = wb.getSheet("P1 Teams");
			sheet5 = wb.getSheet("P1 Contri");
			sheet6 = wb.getSheet("P1 Grades");
			sheet7 = wb.getSheet("P2 Teams");
			sheet8 = wb.getSheet("P2 Contri");
			sheet9 = wb.getSheet("P2 Grades");
			sheet10 = wb.getSheet("P3 Teams");
			sheet11 = wb.getSheet("P3 Contri");
			sheet12 = wb.getSheet("P3 Grades");
			sheet13 = wb.getSheet("Grades");
			
			this.setAllProjects(); // fill the projectMap
			this.setAllAssignments(); // fill the assignmentMap
			this.setAllStudents(); // fill the student hashset
			
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	} // end of Constructor
	
	
	//Get the total number of students 
	public int getNumStudents(){		
				
		int rowNum = sheet.getLastRowNum();		
		
		return rowNum;
	}
	
	// Get the total number of assignments
	public int getNumAssignments(){
		
		int rowNum = sheet2.getLastRowNum();
		int count = 0; // counter for number of assignments
		
		//loop through each row, make sure there's a valid assignment before incrementing counter
		for (int i = 1; i<=rowNum; i++) {
			XSSFRow row = sheet2.getRow(i);
			String r = cellToString(row.getCell(3));
			if (r instanceof String && !r.equals("")){
				count++;                
			}
		}			
		return count;
	}	
	
	// Get the total number of projects
	public int getNumProjects(){
		
		int rowNum = sheet2.getLastRowNum();
		int count = 0; // counter for number of projects
		
		//loop through each row, make sure there's a valid project before incrementing counter
		for (int i = 1; i<=rowNum; i++) {
			XSSFRow row = sheet2.getRow(i);
			String r = cellToString(row.getCell(0));
			if (r instanceof String && !r.equals("")){
				count++;                
			}
		}			
		return count;
	}
	
	
	// Get the students in the class
	// Initially had the code to set the student's hashset in this method
	// Moved code to setAllStudents() - see below - and called it from Constructor
	public HashSet<Student> getStudents() {
		return this.students;	
	} 
	
	
	// Get the student with the given name
	public Student getStudentByName(String n) {
		Student student = null;
	
		HashSet<Student> students = this.getStudents();
	
		if (students != null) {
			for (Student s : students){
				if (s.getName().equals(n)) {
					student = s;
					break;
				}
			}
		}
		return student;
	}

	// Get the student with the given ID
	public Student getStudentByID(String id) {
		Student student = null;
	
		HashSet<Student> students = this.getStudents();
	
		if (students != null) {
			for (Student s : students){
				if (s.getGtid().equals(id)) {
					student = s;
					break;
				}
			}
		}	
		return student;
	}	
	
	// Convert value of cell to a string	
	public static String cellToString(XSSFCell cell){		
		Object result;		
		cell.setCellType(Cell.CELL_TYPE_STRING);		
		result = cell.getStringCellValue();
					
		return result.toString();
		
	}	
	
	
	//The methods below were added for TDD Part 3 
	
	//This function returns a list of strings for the combo box to select the student 
	//String format: studentName
	public ArrayList<String> getStudentList() {
		return this.orderedStudents;
	}	
		
	//Returns the basic information about a student with the given name
	//Includes: Name, ID, Email, Attendance
	public String getStudentInfo(String studentName) {
		Student s = this.getStudentByName(studentName);
		String output = "Name: " + s.getName()+"\n"+
						"GT ID: "+ s.getGtid()+"\n"+
						"Email: "+s.getEmail()+"\n"+
						"Attendance: "+ s.getAttendance()+"%";			
			
		return output;
	}
		
	//Returns the list of projects the student, with the given name, is working on
	public ArrayList<Project> getStudentProjects(String studentName) {	
		ArrayList<Project> studentProj = new ArrayList<Project>();
		ArrayList<Project> allProjects = this.getProjects(); // get the list of all projects
			
		// for each project, get the team the student belongs to
		for (Project p : allProjects){
			
			Team t = p.getStudentTeam(studentName);
			if (t!=null){
				studentProj.add(p);
			}
		}		
			
		return studentProj;
	}
		
	// Returns the list of all projects in the class
	public ArrayList<Project> getProjects() {
		return new ArrayList<Project>(this.projectMap.values());
	}
		
	//Returns the list of assignments the student is working on
	//Since every student works on every assignment, this will just return a list of all assignments
	public ArrayList<Assignment> getStudentAssignments() {
		return new ArrayList<Assignment>(this.assignmentMap.values());
	}
		
	//Returns the project with the given project number
	public Project getProject(String projectNumber) {
		return this.projectMap.get(projectNumber);		
	}
		
	//Returns the assignment with the given assignment number
	public Assignment getAssignment(String assignmentNumber) {
		return this.assignmentMap.get(assignmentNumber);
	}
		
	// Return a string that includes the student's basic info, project info, and assignment info	
	public String getAllStudentInfo(String studentName) {
		String s1 = this.getStudentInfo(studentName) + "\n";
		String s2 = "Projects done by " + studentName + ":\n";
		ArrayList<Project> studentProjects = this.getStudentProjects(studentName);
		for (Project p: studentProjects){
			s2 = s2 + "\n" + p.toString(studentName) + "\n";
		}
		String s3 = "Assignments done by " + studentName +  ":\n";
		ArrayList<Assignment> studentAssignments = this.getStudentAssignments();
		for (Assignment a: studentAssignments){
			s3 = s3 + "\n" +  a.toString(studentName) + "\n";
		}
		return s1+ "\n" + s2 + "\n" + s3;
	}
		

	// Get the list of teams for the specified projectNumber
	private ArrayList<Team> getTeams(String projectNumber){
		ArrayList<Team>teams = new ArrayList<Team>();
		XSSFSheet sheetTeam;
		XSSFSheet sheetContri;
		XSSFSheet sheetGrades;	
			
		//set the correct sheets depending on the project number that is passed in		
		if (projectNumber.equals("P1")) {
			sheetTeam = sheet4;
			sheetContri = sheet5;
			sheetGrades = sheet6;			
		}
		else if (projectNumber.equals("P2")) {
			sheetTeam = sheet7;
			sheetContri = sheet8;
			sheetGrades = sheet9;
		}
		else {
			sheetTeam = sheet10;
			sheetContri = sheet11;
			sheetGrades = sheet12;
		}	
				
		int rowNum = sheetTeam.getLastRowNum();
		int colNum = sheetTeam.getRow(0).getLastCellNum()-1;			
				
		for (int i = 1; i<rowNum; i++) {
			Team team = new Team();
			XSSFRow row = sheetTeam.getRow(i);
			String teamName = cellToString(row.getCell(0));
			if (teamName instanceof String && !teamName.equals("")){
				team.setTeamNumber(teamName); // set the team names
			}
					
		ArrayList<String>names = new ArrayList<String>(); // list of students name on each team (for each row)
			for (int j = 1; j<colNum; j++) {					
				if (teamName instanceof String && !teamName.equals("") && row.getCell(j).getCellType()!=Cell.CELL_TYPE_BLANK) {
					String studentName = cellToString(row.getCell(j));
					names.add(studentName); // add the student's name to the arraylist					
				} 						
			} 
		team.setNames(names); // set the list of member's names
						
				
		ArrayList<Double>contributions = new ArrayList<Double>(); // list of student contribution values
		
		// add each student's contribution values - who belong to the team -  to the contributions list
		int contriRowNum = sheetContri.getLastRowNum();
			for (String n:names){
				for (int k=2;k<contriRowNum;k++){
					XSSFRow contriRow = sheetContri.getRow(k);
					String name = cellToString(contriRow.getCell(1));
					if (n.equals(name)){
						Double contri = cellToDouble(contriRow.getCell(2));
						BigDecimal bd = new BigDecimal(contri);
						bd = bd.setScale(2,RoundingMode.HALF_EVEN);
						double contribution = bd.doubleValue();
						contributions.add(contribution);
						break;
					}
				}
					
			}
		team.setContributions(contributions);
									
		// add the team to the list of teams 			
		int gradeRowNum = sheetGrades.getLastRowNum()-1; 
		XSSFRow gradeRow = sheetGrades.getRow(gradeRowNum);
		int teamGrade = cellToInt(gradeRow.getCell(i+1));
		team.setTeamGrade(teamGrade);		
		teams.add(team);
						
		} // end of first for
			
		return teams;	
			
			
	} // end of method	
			
	// Sets the students HashSet with all the students in the class
	// Called in the constructor
	// Names are also added in order to "orderedStudents" ArrayList, which is returned when getStudentList() is called (see above)
	private void setAllStudents() {
		int rowNum = sheet.getLastRowNum();
		int j = 2; // counter for rows in Attendance sheet		
		//get name, id, and email for each row and create a student
		for (int i = 1; i<=rowNum; i++) {	
			XSSFRow row = sheet.getRow(i);
			XSSFRow rowA = sheet3.getRow(j);
			
			//get name, id, and email
			XSSFCell cellName = row.getCell(0);
			String name = cellToString(cellName);		
			this.orderedStudents.add(name);
			XSSFCell cellID = row.getCell(1);
			String id = cellToString(cellID);	
			XSSFCell cellEmail = row.getCell(2);
			String email = cellToString(cellEmail);
			
			//get attendance
			XSSFCell cellAtten = rowA.getCell(1);
			double p = cellAtten.getNumericCellValue()*100;
			BigDecimal bd = new BigDecimal(p);
			bd = bd.setScale(0,BigDecimal.ROUND_DOWN);
			double newVal = bd.doubleValue();
			int atten = (int)newVal;	
			
			//create new student with given information
			Student student = new Student(name,id,email,atten, new ArrayList<Team>());
			// add the student to the HashSet
			this.students.add(student);
			j++;
		}		
			
	} // end of method			
		
	// Set the project number, description, list of teams, and average grade for each project	
	// Sets the projectMap LinkedHashMap with each project
	// Called in the constructor
	private void setAllProjects() {
			
			int rowNum = sheet2.getLastRowNum();	
			
			//loop through each row, make sure there's a valid project 
			for (int i = 1; i<=rowNum; i++) {
				Project p = new Project(); // create a new project
				XSSFRow row = sheet2.getRow(i);
				String name = cellToString(row.getCell(0));
				if (name instanceof String && !name.equals("")){				
					p.setNumber(name); // set the project's name
					String description = cellToString(row.getCell(1)); //description column
					p.setDescription(description); // set the project's description
					
					ArrayList<Team> projTeams = getTeams(name); // get the list of teams for the specific project
					p.setTeam(projTeams); // set the teams for the specific project
					double total = 0; // sum of all project grades across the teams
					double avgG = 0;
					for (Team t:projTeams){
						double grade = t.getTeamGrade();
						total+=grade;
					}
					
					avgG = total/projTeams.size();
					BigDecimal bd = new BigDecimal(avgG);
					bd = bd.setScale(2,RoundingMode.HALF_EVEN);
					double averageGrade = bd.doubleValue();
					p.setAvgGrade(averageGrade);	
					
				}			
				projectMap.put(name, p); // add the project to the projectMap
			} // end of for		
		
			
		}
	
	// Set the assignment number, description, list of grades, and average grade for the class
	// Sets the assignmentMap LinkedHashMap with each assignment
	// Called in the constructor
	private void setAllAssignments() {
		
		int rowNum = sheet2.getLastRowNum();
		int gradesRowNum = sheet13.getLastRowNum();	
		int colCount = 2; // counter for assignment columns in Grades sheet
		
		//loop through each row, make sure there's a valid assignment
		for (int i = 1; i<=rowNum;i++){ 
			double total = 0;
			Assignment a  = new Assignment();
			XSSFRow row = sheet2.getRow(i);
			String name = cellToString(row.getCell(3)); 
			
			if (name instanceof String && !name.equals("") && !name.equals(null)){
				a.setNumber(name);
				String description = cellToString(row.getCell(4));
				a.setDescription(description);
				
							
				for (int j = 1; j<gradesRowNum; j++ ){
					XSSFRow assignmentRow = sheet13.getRow(j);
					String studentName = cellToString(assignmentRow.getCell(0));
					int grade = cellToInt(assignmentRow.getCell(colCount));
					a.addStudentGrade(studentName,grade);
					total+=grade;
				}
				double avgGrade = total/(gradesRowNum-1);
				BigDecimal bd = new BigDecimal(avgGrade);
				bd = bd.setScale(2,RoundingMode.HALF_EVEN);
				double averageGrade = bd.doubleValue();
				a.setAvgGrade(averageGrade);				
			}
			assignmentMap.put(name, a);
			colCount++;
		} // end of main for

	} // end of method


	// Saves the student's information to a text file
	public void saveInfoToFile(String studentName) throws IOException{
		File file = new File(studentName+".txt");
		FileWriter fw = new FileWriter(file);
		fw.write(this.getAllStudentInfo(studentName));
		fw.close();
	}
	
	// Converts the cell content to a Double
	private static Double cellToDouble(XSSFCell cell) {
		Object result;		
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);		
		result = cell.getNumericCellValue();
			
		return (Double) result;
			
	}	
	// Converts the cell content to an int	
	private static int cellToInt(XSSFCell cell) {	
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);		
		int num = (int) cell.getNumericCellValue();
			
		return num;
			
	}	

} //end of GradesDB class
