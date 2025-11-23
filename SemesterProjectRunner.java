package semesterproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SemesterProjectRunner {
    // Repositories for managing objects
    private static Repository<Student> studentRepository = new Repository<>();
    private static Repository<Teacher> teacherRepository = new Repository<>();
    private static Repository<Course> courseRepository =   new   Repository<>();
    private static Repository<AdministrativeStaff> adminStaffRepository = new Repository<>();

    // Main Frame
    private JFrame frame;
    private JTextArea outputArea;

    public SemesterProjectRunner() {
        frame = new JFrame("University Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("University Management System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(title, BorderLayout.NORTH);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        JButton addStudentButton = new JButton("Add Student");
        JButton addTeacherButton = new JButton("Add Teacher");
        JButton addCourseButton = new JButton("Add Course");
        JButton addAdminStaffButton = new JButton("Add Administrative Staff");
        JButton assignTeacherButton = new JButton("Assign Teacher to Course");
        JButton enrollStudentButton = new JButton("Enroll Student in Course");
        JButton displayAllButton = new JButton("Display All Data");
        JButton saveButton = new JButton("Save Data to File");
        JButton loadButton = new JButton("Load Data from File");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addStudentButton);
        buttonPanel.add(addTeacherButton);
        buttonPanel.add(addCourseButton);
        buttonPanel.add(addAdminStaffButton);
        buttonPanel.add(assignTeacherButton);
        buttonPanel.add(enrollStudentButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.WEST);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        addStudentButton.addActionListener(e -> addStudent());
        addTeacherButton.addActionListener(e -> addTeacher());
        addCourseButton.addActionListener(e -> addCourse());
        addAdminStaffButton.addActionListener(e -> addAdminStaff());
        assignTeacherButton.addActionListener(e -> assignTeacherToCourse());
        enrollStudentButton.addActionListener(e -> enrollStudentInCourse());
        displayAllButton.addActionListener(e -> displayAllData());
        saveButton.addActionListener(e -> saveDataToFile());
        loadButton.addActionListener(e -> loadDataFromFile());
        exitButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private void addStudent() {
        String studentID = JOptionPane.showInputDialog("Enter Student ID:");
        String name = JOptionPane.showInputDialog("Enter Student Name:");
        String email = JOptionPane.showInputDialog("Enter Student Email:");
        String dob = JOptionPane.showInputDialog("Enter Student Date of Birth (yyyy-mm-dd):");

        if (studentID != null && name != null && email != null && dob != null) {
            Student student = new Student(studentID, name, email, dob);
            studentRepository.add(student);
            University.addStudent(student);
            outputArea.append("Student Added: " + student + "\n");
        }
    }

    private void addTeacher() {
        String teacherID = JOptionPane.showInputDialog("Enter Teacher ID:");
        String name = JOptionPane.showInputDialog("Enter Teacher Name:");
        String email = JOptionPane.showInputDialog("Enter Teacher Email:");
        String dob = JOptionPane.showInputDialog("Enter Teacher Date of Birth (yyyy-mm-dd):");
        String specialization = JOptionPane.showInputDialog("Enter Specialization:");

        if (teacherID != null && name != null && email != null && dob != null && specialization != null) {
            Teacher teacher = new Teacher(teacherID, name, email, dob, specialization);
            teacherRepository.add(teacher);
            University.addTeacher(teacher);
            outputArea.append("Teacher Added: " + teacher + "\n");
        }
    }

    private void addCourse() {
        String courseID = JOptionPane.showInputDialog("Enter Course ID:");
        String title = JOptionPane.showInputDialog("Enter Course Title:");
        int credits = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Credits:"));

        if (courseID != null && title != null) {
            Course course = new Course(courseID, title, credits);
            courseRepository.add(course);
            University.addCourse(course);
            outputArea.append("Course Added: " + course + "\n");
        }
    }

    private void addAdminStaff() {
        String staffID = JOptionPane.showInputDialog("Enter Staff ID:");
        String name = JOptionPane.showInputDialog("Enter Staff Name:");
        String email = JOptionPane.showInputDialog("Enter Staff Email:");
        String dob = JOptionPane.showInputDialog("Enter Staff Date of Birth (yyyy-mm-dd):");
        String role = JOptionPane.showInputDialog("Enter Role:");
        String department = JOptionPane.showInputDialog("Enter Department:");

        if (staffID != null && name != null && email != null && dob != null && role != null && department != null) {
            AdministrativeStaff staff = new AdministrativeStaff(staffID, name, email, dob, role, department);
            adminStaffRepository.add(staff);
            outputArea.append("Administrative Staff Added: " + staff + "\n");
        }
    }

    private void assignTeacherToCourse() {
        String teacherID = JOptionPane.showInputDialog("Enter Teacher ID:");
        String courseID = JOptionPane.showInputDialog("Enter Course ID:");

        Teacher teacher = findTeacherByID(teacherID);
        Course course = findCourseByID(courseID);

        if (teacher != null && course != null) {
            teacher.assignCourse(course);
            outputArea.append("Teacher " + teacher.getName() + " assigned to Course " + course.getTitle() + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "Teacher or Course not found!");
        }
    }

    private void enrollStudentInCourse() {
        String studentID = JOptionPane.showInputDialog("Enter Student ID:");
        String courseID = JOptionPane.showInputDialog("Enter Course ID:");

        Student student = findStudentByID(studentID);
        Course course = findCourseByID(courseID);

        if (student != null && course != null) {
            student.enrollInCourse(course);
            outputArea.append("Student " + student.getName() + " enrolled in Course " + course.getTitle() + "\n");
        } else {
            JOptionPane.showMessageDialog(frame, "Student or Course not found!");
        }
    }

    private void displayAllData() {
        outputArea.setText("--- Students ---\n");
        for (Student student : studentRepository.getAll()) {
            outputArea.append(student + "\n");
        }
        outputArea.append("\n--- Teachers ---\n");
        for (Teacher teacher : teacherRepository.getAll()) {
            outputArea.append(teacher + "\n");
        }
        outputArea.append("\n--- Courses ---\n");
        for (Course course : courseRepository.getAll()) {
            outputArea.append(course + "\n");
        }
        outputArea.append("\n--- Administrative Staff ---\n");
        for (AdministrativeStaff staff : adminStaffRepository.getAll()) {
            outputArea.append(staff + "\n");
        }
    }

    private void saveDataToFile() {
        University.saveData("university_data.txt");
        JOptionPane.showMessageDialog(frame, "Data saved successfully!");
    }

    private void loadDataFromFile() {
        University.loadData("university_data.txt");
        JOptionPane.showMessageDialog(frame, "Data loaded successfully!");
    }

    private Student findStudentByID(String id) {
        return studentRepository.getAll().stream().filter(s -> s.getStudentID().equals(id)).findFirst().orElse(null);
    }

    private Teacher findTeacherByID(String id) {
        return teacherRepository.getAll().stream().filter(t -> t.getTeacherID().equals(id)).findFirst().orElse(null);
    }

    private Course findCourseByID(String id) {
        return courseRepository.getAll().stream().filter(c -> c.getCourseID().equals(id)).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SemesterProjectRunner::new);
    }
}
