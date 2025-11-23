
package semesterproject;

public class Runner3 {
    public static void main(String[] args) {
        // Create Students
        Student student1 = new Student("S001", "Alice Johnson", "alice@example.com", "2001-09-12");
        Student student2 = new Student("S002", "Bob Anderson", "bob@example.com", "2002-03-18");
        student1.addGrade(90.0);
        student2.addGrade(85.0);

        // Create Teachers
        Teacher teacher1 = new Teacher("T001", "John Doe", "john@example.com", "1980-06-15", "Computer Science");

        // Create Courses
        Course course1 = new Course("CS101", "Introduction to Java", 3);
        course1.addStudent(student1);
        course1.addStudent(student2);
        teacher1.assignCourse(course1);

        // Generate Reports
        System.out.println(course1.generateStudentReport());
        System.out.println(teacher1.generateWorkloadReport());

        // System Statistics
        University.addStudent(student1);
        University.addStudent(student2);
        University.addTeacher(teacher1);
        University.addCourse(course1);
        University.generateSystemStatistics();

        // Search and Filtering
        University.searchStudentByName("Alice");
        University.filterCoursesByCredits(3);

        // Calculate Average Grade for a Course
        System.out.println("Average Grade for " + course1.getTitle() + ": " + course1.calculateAverageGrade());
    }
}



