package studentManagementSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class StudentDataOperator {

    private int numberOfStudents;
    private Student[] students;
    private Scanner scanner;
    private int freeIndex;
    

    public StudentDataOperator(int size) {
        this.numberOfStudents = size;
        this.students = new Student[numberOfStudents];
        this.scanner = new Scanner(System.in);
        this.freeIndex = 0;
    }

    public void displayMenu() {
        System.out.println("1. Input student info");
        System.out.println("2. Lookup a particular student by studentID");
        System.out.println("3. Remove student by studentID");
        System.out.println("4. Register student for courses");
        System.out.println("5. Add student grades for courses");
        System.out.println("6. Display all students");
        System.out.println("7. Sort students by GPA");
        System.out.println("8. Create a report");
        System.out.println("9. Upload a report");    
        System.out.println("10. Quit");
    }

    public void run() throws FileNotFoundException {
    	displayMenu();
 
    	int  answer = scanner.nextInt();
    	
    	switch(answer){
		case 1: insertStudent();
		break;
		case 2: findStudentById();
		break;
		case 3: removeStudent();
		break;
		case 4: registerStudentForCourses();
		break;
		case 5: addStudentGradesForCourses();
		break;
		case 6: displayAllStudents();
		break;
		case 7: sortStudentsByGPA();
		break;
		case 8: creatReport();
		break;
		case 9:	readReport();	
		break;
		case 10:System.out.println("You end the session.");
		break; 		
    	}
    	
    	run();
 }

    

	private void insertStudent(){

    	System.out.println("Enter the student first name: ");
    	String firstName = scanner.next();
    	
    	System.out.println("Enter the student last name: ");
    	String lastName = scanner.next();
    	
    	String bday = bday();
    	
    	students[freeIndex()] = new Student (firstName,lastName,bday); 
    	
    	System.out.println("Student "+ firstName +" "+ lastName + " was recorded.What would you like to do next?\n ");
       
        freeIndex++;
    }
		
    
    public int freeIndex() {
    	int i= 0;	
    	while (students[i]!=null) {
    		i++;
    	}
    	return i;
    }

    public String bday() {
    	 System.out.println("Enter the student date of birth in the mm-dd-year format: ");
    	 
     	 String bday = scanner.next();
     	 try {
     	 	if (StudentValidator.validateBirthDate(bday)) {
     	 		return bday;
     		
     		}else {
     			System.out.println("It seems you made a mistake...");
     			bday();
     	}
    	 return bday;
    	 
     	 } catch (Exception anyVarName) { 
     		 return null; }
     }
    private void findStudentById(){
    	System.out.println("Enter the student ID you looking for: ");
    	String id = scanner.next();
    	int i = 0;
    	try {
    	while (!students[i].getID().equals(id)) {
    		i++;
    		}
    	if(students[i].getID().equals(id))  {
    		System.out.println(students[i].toString());
    		}
    	}
    	catch(Exception ex) {
    		 
    			System.out.println("Student isn't found");
    			
    		}
        // TODO: this method should lookup a student based on the studentID it should ask for and if the student is found print out the student info (call the toString() method from the Student class)
    }
  /* private Student find_Student_by_Id() {
    	String id = scanner.next();
    	int i = 0;
    	while (!students[i].getID().equals(id)) {
    		i++;
    		}
    	if (students[i].getID().equals(id)) {
    		return students[i];
    	}else {
    		return null;
    }
   }*/

    private void removeStudent(){
    	System.out.print("Enter the student's ID you want to delete :");
    	String id = scanner.next();
    	int i = 0;
    	while (!students[i].getID().equals(id)) {
    		i++;
    		}
    	if(students[i].getID().equals(id)) {
    	
    		System.out.println("Deleted student is " + students[i]+ " .\n");
    		students[i]= null;
    		freeIndex--;
    		} 
     }

    private void registerStudentForCourses(){
    	System.out.println("Enter the student's ID you wish to register:  ");
    	String[] temp = new String [3];
    	String id = scanner.next();
    	try {
    	int i = 0;
    	while (!students[i].getID().equals(id)) {
    		//if (i < students.length-1) {
    			i++;
    		}   	
    	if (students[i]!= null) {
    		for ( int j = 0; j < 3; j++) {
        		System.out.println("Enter a course you want to register for");
        		temp[j] = scanner.next();
        		students[i].registerStudentForCourse(temp[j]);     	
        		}
    	}
	     	} catch(Exception ex) {
	    		System.out.println("Student isn't found. You might need to input the student's info at first.");
	    		try {
					run();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     		}
    }

    private void addStudentGradesForCourses(){
    	System.out.println("Enter the student's ID you adding grade to : ");
    	String id = scanner.next();
    	int i = 0;
    	while (!students[i].getID().equals(id)) {
    		i++;
    		}
    	if(students[i].getID().equals(id)){
    		System.out.println(students[i].toString());
    	}
    	String[] titles = new String [3];
    	for ( int j = 0 ; j < 3;j++) {
    		System.out.println("Enter a course you want to add a grade to: ");// HOW TO DISPLAY EXISTENT COURSES
    		titles[j] = scanner.next();
   
    		
    	System.out.println("Enter the student grades for: " + titles[j]);
    	double grades= scanner.nextDouble();
    	if ( grades > 4.0) {
    		//System.out.println("It seems you made a mistake by entering incorrect grade.Please try again.");
    	}else 
    	students[i].setCourseGrade(titles[j],grades);
    	//break;
    	}

        //TODO: this method should ask for the student id and then for 3 course grades. You should get each course of the student and then using a setCourse mehtod assign the course grade to it.
        // After that's done print the student info (it should display the GPA by now)
    }

    private void displayAllStudents(){
    	if (students!= null) {
    		for ( int j = 0; j < freeIndex; j++) 
    			System.out.println(students[j]); 		
    	}
    		else {
    			System.out.println("No students are found.What would you like to do next?\n");
    	}
    }

    
    private void sortStudentsByGPA(){
    	
    	
    	if (students[0].getGPA()!= 0.0|| students[1].getGPA()!= 0.0) {
    		
    		double[] GPA = new double[students.length];
    		
    			for ( int i = 0; i < students.length; i++) {
    				int smallest = i;
    				for ( int j = i + 1 ;j < students.length; j++) {
    					if (students[j].getGPA() < students[smallest].getGPA()) {
    						smallest = j;
    					}
    				}
    				Student temp = students[i];
    			    students[i] = students[smallest]; ;
    				students[smallest]= temp;
    		
    			}
    	displayAllStudents();
    	
    }else {
    	System.out.println(" Students don't have registered GPA score");
    }
  	
    }
    private void creatReport() throws FileNotFoundException   {
		try {	
			PrintWriter pw = new PrintWriter(
					new BufferedWriter(
							new FileWriter("C:\\Users\\Olya\\Desktop\\Java\\Repost.txt")));
			
			LocalDate today = LocalDate.now();
			pw.write("Registreded students for "+ today+ " : \n");
			for ( int j = 0; j < freeIndex; j++) {
				pw.println(students[j]);}	
		pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
		private void readReport() throws FileNotFoundException {
			String separator = File.separator;
			String path = "C:" +separator+"Users"+ separator +"Olya"+ separator+ "Desktop"+separator+"Students.txt"; 
		
			FileInputStream fis = new FileInputStream(path);
			Scanner in = new Scanner (fis);
			
			while (in.hasNext()) {
				System.out.println(in.nextLine());			
			}	
			System.out.println();
	}
}
