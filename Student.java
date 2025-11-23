
package semesterproject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Serializable  {
    private String studentID;
    private List<Course> enrolledCourses;
    private List<Double> grades;
     private static int totalStudents = 0;
     
     
    public Student(String studentID, String name, String email, String dateOfBirth) {
        super(name, email, dateOfBirth);
        this.studentID = studentID;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new ArrayList<>();
        totalStudents++;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    
    public List<Double> getGrades() { return grades; }
    
    //Static Method
    public static int getTotalStudents() {
        return totalStudents;
    }
    
     public void addGrade(Double grade) {
        grades.add(grade);
        System.out.println("Grade " + grade + " added for Student " + studentID);
    }

    
 
     public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this); 
            System.out.println("Student " + studentID + " successfully enrolled in " + course.getTitle() + ".");
        } else {
            System.out.println("Student " + studentID + " is already enrolled in " + course.getTitle() + ".");
        }
    }
     
     public void displayCourses() {
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled yet.");
        } else {
            System.out.println("Courses enrolled by Student " + studentID + ":");
            for (Course course : enrolledCourses) {
                System.out.println("- " + course);
            }
        }
    }
    public void displayDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder courseTitles = new StringBuilder();
        for (Course course : enrolledCourses) {
            courseTitles.append(course.getTitle()).append(", ");
        }
        String coursesList = courseTitles.length() > 0 ? courseTitles.substring(0, courseTitles.length() - 2) : "None";
        return "Student: " + studentID + ", Name: " + getName() + 
               ", Enrolled in: [" + coursesList + "], Grades: " + grades;
    }
}


