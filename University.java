
package semesterproject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class University {
    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    // Add a Student
    public static void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    // Add a Teacher
    public static void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Teacher added: " + teacher.getName());
    }

    // Add a Course
    public static void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getTitle());
    }

    // Save Data to File
    public static void saveData(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            oos.writeObject(teachers);
            oos.writeObject(courses);
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load Data from File
    public static void loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
            teachers = (List<Teacher>) ois.readObject();
            courses = (List<Course>) ois.readObject();
            System.out.println("Data loaded successfully from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    // Display All Students
    public static void displayAllStudents() {
        System.out.println("\n--- All Students ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Display All Teachers
    public static void displayAllTeachers() {
        System.out.println("\n--- All Teachers ---");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    // Display All Courses
    public static void displayAllCourses() {
        System.out.println("\n--- All Courses ---");
        for (Course course : courses) {
            System.out.println(course);
        }
    }
    
    public static void generateSystemStatistics() {
    System.out.println("--- Overall System Statistics ---");
    System.out.println("Total Students: " + students.size());
    System.out.println("Total Teachers: " + teachers.size());
    System.out.println("Total Courses: " + courses.size());
}
    
    public static List<Student> searchStudentByName(String name) {
    List<Student> matchingStudents = new ArrayList<>();
    for (Student student : students) {
        if (student.getName().toLowerCase().contains(name.toLowerCase())) {
            matchingStudents.add(student);
        }
    }
    if (matchingStudents.isEmpty()) {
        System.out.println("No students found with name: " + name);
    } else {
        System.out.print("Found students: ");
        for (Student student : matchingStudents) {
            System.out.print(student.getName() + ", ");
        }
        System.out.println();
    }
    return matchingStudents;
}

    
    public static List<Course> filterCoursesByCredits(int minCredits) {
    List<Course> filteredCourses = new ArrayList<>();
    for (Course course : courses) {
        if (course.getCredits() >= minCredits) {
            filteredCourses.add(course);
        }
    }

    if (filteredCourses.isEmpty()) {
        System.out.println("No courses found with at least " + minCredits + " credits.");
    } else {
        System.out.print("Courses with at least " + minCredits + " credits: ");
        for (Course course : filteredCourses) {
            System.out.print(course.getTitle() + ", ");
        }
        System.out.println();
    }
    return filteredCourses;
}

}

