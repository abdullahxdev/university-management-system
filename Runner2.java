package semesterproject;

public class Runner2 {
    public static void main (String[]args){
        
        Repository<Student> studentRepository = new Repository<>();
        Repository<Teacher> teacherRepository = new Repository<>();
        Repository<Course> courseRepository = new Repository<>();

        Student student1 = new Student("S001", "Alice Johnson", "alice@example.com", "2001-09-12");
        Student student2 = new Student("S002", "Bob Anderson", "bob@example.com", "2002-03-18");

        Teacher teacher1 = new Teacher("T001", "John Doe", "john@example.com", "1980-06-15", "Computer Science");
        Teacher teacher2 = new Teacher("T002", "Jane Smith", "jane@example.com", "1985-07-22", "Mathematics");

        Course course1 = new Course("CS101", "Introduction to Java", 3);
        Course course2 = new Course("CS102", "Data Structures", 4);

        studentRepository.add(student1);
        studentRepository.add(student2);

        teacherRepository.add(teacher1);
        teacherRepository.add(teacher2);

        courseRepository.add(course1);
        courseRepository.add(course2);

        System.out.println("\n--- All Students in Repository ---");
        for (Student student : studentRepository.getAll()) {
            System.out.println(student);
        }

        System.out.println("\n--- All Teachers in Repository ---");
        for (Teacher teacher : teacherRepository.getAll()) {
            System.out.println(teacher);
        }

        System.out.println("\n--- All Courses in Repository ---");
        for (Course course : courseRepository.getAll()) {
            System.out.println(course);
        }

        courseRepository.remove(course1);

        System.out.println("\n--- All Courses After Removal ---");
        for (Course course : courseRepository.getAll()) {
            System.out.println(course);
        }
        
        student1.addGrade(95.0);
        student2.addGrade(90.0);
        
        course1.addStudent(student1);
        course1.addStudent(student2);
        
        
        System.out.println("\n--- Median Grade for " + course1.getTitle() + " ---");
        Double medianGrade = course1.calculateMedianGrade();
        if (medianGrade != null) {
            System.out.println("Median Grade: " + medianGrade);
        }
    }
}
