# 📚 University Management System

A comprehensive Java desktop application built with Object-Oriented Programming principles and Swing GUI for managing university operations.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Principles-green?style=for-the-badge)

## 📝 Overview

The University Management System is a desktop application designed to streamline administrative tasks in educational institutions. Built using Java Swing and core OOP principles, it provides an intuitive interface for managing students, teachers, courses, and administrative staff.

## ✨ Key Features

### 👨‍🎓 Student Management
- Add and register new students
- Enroll students in multiple courses
- Track student grades and academic progress
- Maintain student records with automatic ID generation
- View comprehensive student information

### 👩‍🏫 Teacher Management
- Register new teaching staff
- Assign teachers to specific courses
- Generate detailed workload reports
- Track total number of faculty members
- View teacher-course assignments

### 📘 Course Management
- Create and manage course offerings
- Assign instructors to courses
- View enrolled students per course
- Track course capacity and enrollment

### 🧑‍💼 Administrative Staff
- Add administrative personnel
- Store department information
- Maintain role and responsibility records

### 💾 Data Persistence
- Save all system data using Java serialization
- Load previously saved sessions
- Automatic data backup to `university_data.txt`
- Persistent storage of students, teachers, courses, and enrollments

### 🖥️ User Interface
- Clean, intuitive Swing-based GUI
- Interactive buttons for all operations
- Form dialogs for data entry
- Real-time data display panel
- User-friendly navigation

## 🏗️ Project Architecture

```
semesterproject/
│
├── SemesterProjectRunner.java    # Main application entry point & GUI
├── University.java                # Core data manager & file operations
├── Repository.java                # Generic repository pattern implementation
│
├── Person.java                    # Abstract base class for all people
├── Student.java                   # Student entity with grades & courses
├── Teacher.java                   # Teacher entity with assigned courses
├── AdministrativeStaff.java       # Administrative staff entity
├── Course.java                    # Course entity with enrollment
│
└── Reportable.java                # Interface for generating reports
```

## 🎯 OOP Principles Demonstrated

| Concept | Implementation |
|---------|---------------|
| **Inheritance** | `Student`, `Teacher`, and `AdministrativeStaff` extend `Person` base class |
| **Polymorphism** | `Reportable` interface with multiple implementations |
| **Encapsulation** | Private fields with public getters/setters |
| **Abstraction** | Abstract `Person` class and `Reportable` interface |
| **Static Members** | Class-level counters for students and teachers |
| **Collections** | Lists for courses, grades, and repositories |
| **Serialization** | Object persistence using `Serializable` interface |
| **Design Patterns** | Repository pattern for data management |

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command line

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/university-management-system.git
   cd university-management-system
   ```

2. **Compile the project**
   ```bash
   javac semesterproject/*.java
   ```

3. **Run the application**
   ```bash
   java semesterproject.SemesterProjectRunner
   ```

### Alternative: Using an IDE
1. Import the project into your IDE
2. Set the main class as `SemesterProjectRunner`
3. Run the project

## 📖 Usage Guide

### Adding a Student
1. Click the "Add Student" button
2. Enter student name and ID
3. Optionally enroll in courses
4. Click "Save"

### Enrolling Students in Courses
1. Select a student from the list
2. Choose available courses
3. Click "Enroll"

### Assigning Teachers to Courses
1. Click "Assign Teacher"
2. Select teacher and course
3. Confirm assignment

### Saving Data
1. Click "Save Data" to persist all information
2. Data is saved to `university_data.txt`

### Loading Data
1. Click "Load Data" on startup
2. All previous data will be restored

## 📂 Data Storage

The system uses Java serialization to save data in the following format:
- **File**: `university_data.txt`
- **Contents**:
  - Student records with enrollments and grades
  - Teacher information with course assignments
  - Course details with enrolled students
  - Administrative staff records

## 🧪 Technical Details

### Class Hierarchy
```
Person (Abstract)
├── Student
├── Teacher
└── AdministrativeStaff

Reportable (Interface)
├── Teacher
└── Student
```

### Key Components

**Repository Pattern**
- Generic repository for managing collections
- Type-safe operations
- Easy data access and manipulation

**University Class**
- Central data manager
- Handles file I/O operations
- Coordinates between entities

**GUI Components**
- JFrame for main window
- JButton for actions
- JTextArea for display
- JDialog for forms

## 🔧 Future Enhancements

- [ ] Edit and delete records functionality
- [ ] Advanced search and filter options
- [ ] CSV import/export capabilities
- [ ] Enhanced UI with modern styling
- [ ] User authentication and role-based access
- [ ] Automated GPA calculation
- [ ] Email notification system
- [ ] Report generation (PDF/Excel)
- [ ] Database integration (MySQL/PostgreSQL)
- [ ] Multi-language support

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built as a semester project demonstrating OOP concepts
- Inspired by real-world university management systems
- Thanks to the Java Swing documentation and community

## 📞 Support

For issues, questions, or suggestions:
- Open an issue on GitHub
- Contact via email
- Submit a pull request

---

**⭐ If you find this project helpful, please give it a star!**
