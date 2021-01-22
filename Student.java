package studentManagementSystem;

public class Student {

    private String firstName;
    private String lastName;
    private String birthDate;
    int i = 0;
    

    
    private String studentID;

    private double GPA;
    Course[] courses; // had to make it public

  

    public Student(String firstName, String lastName, String birthDate) {
        this.courses = new Course[3];
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.studentID = setStudentID();
        this.GPA = 0.0;
       
       
    }


    public String getFirstName() {
		return firstName;
	}
    public void setFirstName(String name) {
		firstName = name;
	}

    public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
	lastName = last_name;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthData) {
		birthDate = birthData;
	}

	public Course[] getCourses() {
		
		return courses;
	}

	public void setCourses(Course[] courses) {
		this.courses = courses;
	}

	public double getGPA() {
		return GPA;
	}

    public void setGPA(double GPA_Score) { 
    	if (getCourses()!= null){
    	    GPA = GPA_Score + GPA;
       	}
    }
    public String setStudentID() {
    	String name = getFirstName().substring(0,2);
    	String last_name = getLastName().substring(getLastName().length()-2, getLastName().length());
    	String id  = name+ last_name + getBirthDate().substring(getBirthDate().length()-5, getBirthDate().length());
    	
    	 	return id.toUpperCase();
    }
    public String getID() {

    	return studentID;
    }

    public void registerStudentForCourse(String courseTitle) {
    	
    	Course cr= new Course(courseTitle);
    	courses[i]= cr;
    	i++;
    }

   public void setCourseGrade(String courseTitle, double grade) {
	   
	   Course cr= new Course(courseTitle, grade);
	   
    	setGPA(grade);
    	
    	
   	
    }
  @Override
    public String toString() {
	  
	 	
    	String studentInfo = "Student "+ firstName +" "+ lastName+ " with ID: " + studentID + " has registered to " ;
    	String st = "the following courses:" + courses[0]+", "+courses[1] +", "+ courses[2]+ " and has a GPA of ";
    	double gpa = getGPA()/3;
    	String some = String.format("%.2f",(gpa));
     	String NoGPA = " 0 courses and has no evaluted GPA so far";
    	
    	if(courses[0]!= null) {
    		return studentInfo + st +  some;
        	}
    	return studentInfo + NoGPA;
    }
}
  

	


