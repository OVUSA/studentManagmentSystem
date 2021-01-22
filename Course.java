package studentManagementSystem;

public class Course {

    private String title;
    private double grade;

    public Course(String title, double grade) {
        this.title = title;
        this.grade = grade;
    }

    public Course(String title){
        this.title = title;
        this.grade = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double score) {
        grade = score;
    }
    
    public String toString() {
    	
    	String sm = getTitle();
    	
		return sm;
    	
    }
}

