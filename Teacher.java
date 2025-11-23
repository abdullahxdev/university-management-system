
package semesterproject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements Reportable, Serializable  {
    private String teacherID;
    private String specialization;
    private List<Course> coursesTaught; 
    private static int totalTeachers = 0;

    public Teacher(String teacherID, String name, String email, String dateOfBirth, String specialization) {
        super(name, email, dateOfBirth);
        this.teacherID = teacherID;
        this.specialization = specialization;
        this.coursesTaught = new ArrayList<>();
        totalTeachers++;
    }

    public String getTeacherID() { return teacherID; }
    public void setTeacherID(String teacherID) { this.teacherID = teacherID; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public List<Course> getCoursesTaught() { return coursesTaught; }
    //Static
     public static int getTotalTeachers() {
        return totalTeachers;
    }

    public void assignCourse(Course course) {
        if (!coursesTaught.contains(course)) {
            coursesTaught.add(course);
            course.assignTeacher(this); 
            System.out.println("Teacher " + teacherID + " assigned to teach " + course.getTitle() + ".");
        } else {
            System.out.println("Course " + course.getTitle() + " is already assigned to Teacher " + teacherID + ".");
        }
    }

    public void displayCourses() {
        if (coursesTaught.isEmpty()) {
            System.out.println("Teacher " + teacherID + " is not assigned to any courses.");
        } else {
            System.out.println("Courses taught by Teacher " + teacherID + ":");
            for (Course course : coursesTaught) {
                System.out.println("- " + course.getTitle() + " (Course ID: " + course.getCourseID() + ")");
            }
        }
    }
    
    public void displayDetails() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {
        StringBuilder coursesInfo = new StringBuilder();
        for (Course course : coursesTaught) {
            coursesInfo.append(course.getTitle()).append(", ");
        }
        String coursesList = coursesInfo.length() > 0 ? coursesInfo.substring(0, coursesInfo.length() - 2) : "None";
        return "Teacher: " + teacherID + ", Name: " + getName() +
               ", Specialization: " + specialization +
               ", Courses Taught: [" + coursesList + "]";
    }
    
    public String generateReport() {
        StringBuilder report = new StringBuilder("Teacher Report:\n");
        report.append("Teacher ID: ").append(teacherID).append("\n")
              .append("Name: ").append(getName()).append("\n")
              .append("Specialization: ").append(specialization).append("\n")
              .append("Courses Taught: ");

        if (coursesTaught.isEmpty()) {
            report.append("None\n");
        } else {
            for (Course course : coursesTaught) {
                report.append(course.getTitle()).append(", ");
            }
            report.setLength(report.length() - 2); 
            report.append("\n");
        }
        return report.toString();
    }
    
     public void exportToFile(String filename) {
        System.out.println("Exporting teacher report to file: " + filename);}
     
     
public String generateWorkloadReport() {
    StringBuilder report = new StringBuilder("Teacher: ").append(getName()).append(", Courses: ");
    if (coursesTaught.isEmpty()) {
        report.append("None");
    } else {
        for (Course course : coursesTaught) {
            report.append(course.getTitle()).append(", ");
        }
        report.setLength(report.length() - 2); // Remove trailing comma
    }return report.toString();}

}

    