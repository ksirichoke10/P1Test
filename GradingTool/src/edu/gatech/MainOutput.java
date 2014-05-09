package edu.gatech;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainOutput extends JFrame  {
	
	//Class variables
	private JComboBox combobox;
	private JTextArea textArea;
	private JButton save;
	private GradesDB db;
	
	//Constructor
	public MainOutput() {
		super("CS6300 Grading Tool");
		super.setMinimumSize(new Dimension(500,500));
		db = new GradesDB(Constants.GRADES_DB);
		initialize();		
	}
	
	//Creating the GUI - includes a combobox, textArea, and button
	public void initialize(){
	
		JPanel primary = new JPanel();		
		primary.setLayout(new GridLayout(0,2));	
		
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.white);
		primary.add(p1);		
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		textArea = new JTextArea();
		textArea.setEditable(false);		
		primary.add(p2);
		
		JPanel p3 = new JPanel();
		save = new JButton("Save Information"); // the save button will save the student's information to a text file when selected
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getSource() instanceof JButton){
					Student s = (Student)combobox.getSelectedItem();
					try{
						db.saveInfoToFile(s.getName());
					}catch (IOException ex) {
					    ex.printStackTrace();
					    
					}
				}
			}			
			
		});
		p1.add(p3);
		
	
		ArrayList<Student>students=  new ArrayList<Student>();
		ArrayList<String>names = db.getStudentList();
		
		for (String n: names){
			Student s = db.getStudentByName(n);
			students.add(s);
		}
		
		combobox = new JComboBox(students.toArray()); // the combobox will include the student's names
		Student s = (Student)combobox.getSelectedItem();
		String output = db.getAllStudentInfo(s.getName()); 
		textArea.setText(output); // the textArea will show all of the student's information (basic info, projet info, assignment info)	
		
		
		combobox.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent event){
		
				if(event.getSource() instanceof JComboBox){
					JComboBox cb = (JComboBox) event.getSource();
					Student s = (Student)cb.getSelectedItem();
					String output = db.getAllStudentInfo(s.getName());
					textArea.setText(output);		
				}		
					
			}
	
		});		
		
		p1.add(combobox);
		p2.add(textArea);	
		p3.add(save);
		getContentPane().add(primary);
	
	}
	
	public static void main (String args[]){		
		
		  javax.swing.SwingUtilities.invokeLater(new Runnable() {
			  
			  public void run() {
				  MainOutput f = new MainOutput();
				  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	              f.pack();
	              f.setVisible(true);
			  }
		  });
		  
	} // end of main	
}


