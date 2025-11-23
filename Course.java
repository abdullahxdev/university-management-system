package semesterproject;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Collections;

public class Course implements Serializable {
    private String courseID;
    private String title;
    private int credits;
    private Teacher assignedTeacher; 
    private List<Student> enrolledStudents; 
    private static int totalCourses = 0;
    
    // Constructor
    public Course(String courseID, String title, int credits) {
        this.courseID = courseID;
        this.title = title;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
        totalCourses++;
    }
    // Getters and Setters
    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public Teacher getAssignedTeacher() { return assignedTeacher; }

    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    
    
     // Static method to get total number of courses
    public static int getTotalCourses() {
        return totalCourses;
    }

    // Assign a Teacher to the Course
    public void assignTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
        System.out.println("Course " + title + " is now assigned to Teacher " + teacher.getName() + ".");
    }

    // Add a Student to the Course
    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println("Student " + student.getStudentID() + " added to " + title + ".");
        } else {
            System.out.println("Student " + student.getStudentID() + " is already enrolled in " + title + ".");
        }
    }

    // Remove a Student from the Course
    public void removeStudent(Student student) {
        if (enrolledStudents.remove(student)) {
            System.out.println("Student " + student.getStudentID() + " removed from " + title + ".");
        } else {
            System.out.println("Student " + student.getStudentID() + " is not enrolled in " + title + ".");
        }
    }

    // Calculate Average Grade
    public Double calculateAverageGrade() {
    List<Double> allGrades = new ArrayList<>();
    for (Student student : enrolledStudents) {
        allGrades.addAll(student.getGrades());
    }

    if (allGrades.isEmpty()) {
        System.out.println("No grades available to calculate the average.");
        return null;
    }

    double total = 0;
    for (Double grade : allGrades) {
        total += grade;
    }
    return total / allGrades.size();
}
    
        public Double calculateMedianGrade() {
        List<Double> allGrades = new ArrayList<>();
        for (Student student : enrolledStudents) {
            allGrades.addAll(student.getGrades()); 
        }

        if (allGrades.isEmpty()) {
            System.out.println("No grades available to calculate the median.");
            return null;
        }

        Collections.sort(allGrades);

        int size = allGrades.size();
        if (size % 2 == 1) {
            return allGrades.get(size / 2);
        } else {
            return (allGrades.get(size / 2 - 1) + allGrades.get(size / 2)) / 2.0;
        }
    }

    // Display All Students Enrolled in the Course
    public void displayStudents() {
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in " + title + ".");
        } else {
            System.out.println("Students enrolled in " + title + ":");
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getName() + " (ID: " + student.getStudentID() + ")");
            }
        }
    }

    // Overriding toString() for formatted output
    @Override
    public String toString() {
        String teacherName = (assignedTeacher != null) ? assignedTeacher.getName() : "None";
        return "Course: " + courseID + ", Title: " + title + ", Credits: " + credits +
               ", Assigned Teacher: " + teacherName + 
               ", Total Enrolled Students: " + enrolledStudents.size();
    }
    
    
public String generateStudentReport() {
    StringBuilder report = new StringBuilder("Students enrolled in " + title + ":\n");
    if (enrolledStudents.isEmpty()) {
        report.append("No students are enrolled in this course.");
    } else {
        for (Student student : enrolledStudents) {
            report.append("- ").append(student.getName()).append(" (ID: ").append(student.getStudentID()).append(")\n");
        }
    }
    return report.toString();
}


}



