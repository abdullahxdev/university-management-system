📚 University Management System

A Java OOP + Swing Desktop Application

📝 Overview

The University Management System is a Java-based desktop application built using Object-Oriented Programming (OOP) principles and Java Swing for the GUI.

The system allows administrators to manage:

Students

Teachers

Courses

Administrative Staff

It also supports assignments such as:

Enrolling students in courses

Assigning teachers to courses

Saving and loading all data to/from a file

This project demonstrates OOP concepts such as inheritance, polymorphism, encapsulation, interfaces, file serialization, static members, and repository design patterns.

✨ Features
👨‍🎓 Student Management

Add new students

Enroll students in courses

Store grades

Track total number of students

View all student details

👩‍🏫 Teacher Management

Add teachers

Assign teachers to courses

Generate teacher workload reports

Track total number of teachers

📘 Course Management

Add new courses

Assign teachers to courses

View enrolled students

🧑‍💼 Administrative Staff

Add administrative staff

Store department & role information

💾 File Operations

Save all system data (students, teachers, courses) using serialization

Load previously saved data

🖥️ Graphical User Interface

Built entirely with Java Swing, featuring:

Buttons for all major operations

Form dialogs for data entry

Output display panel

Simple, user-friendly layout

🏗️ Project Structure
/semesterproject
│
├── SemesterProjectRunner.java     # Main application GUI
├── University.java                # Central data manager + file handling
├── Repository.java                # Generic repository for objects
│
├── Person.java                    # Base class
├── Student.java                   # Student entity
├── Teacher.java                   # Teacher entity
├── AdministrativeStaff.java       # Staff entity
├── Course.java                    # Course entity
│
└── Reportable.java                # Interface for reports

📦 How to Run
1. Clone the Repository
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name

2. Compile the Project
javac semesterproject/*.java

3. Run the Application
java semesterproject.SemesterProjectRunner

🧪 OOP Concepts Demonstrated
Concept	Usage in Project
Inheritance	Student, Teacher, AdministrativeStaff extend Person
Polymorphism	Reportable interface and overridden toString() methods
Encapsulation	Private fields + getters/setters
Static Members	Total student/teacher counters
Collections	Lists for courses, grades, repositories
Serialization	Save/load system data using ObjectInputStream & ObjectOutputStream
Design Patterns	Repository pattern, separation of concerns
📂 Data Persistence

The system saves all entities to a text file:

university_data.txt


Saved data includes:
✔ Students
✔ Teachers
✔ Courses
✔ Enrollments
✔ Teacher-course assignments

🚀 Future Improvements (Optional Ideas)

Edit/Delete records

Search filters in the GUI

Import/export data to CSV

Improve UI styling

Add login system

Add GPA calculation and grade management UI