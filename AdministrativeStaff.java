
package semesterproject;
import java.util.List;
public class AdministrativeStaff extends Person implements Reportable{
    private String staffID;
    private String role;
    private String department;
    public AdministrativeStaff(String staffID, String name, String email, String dateOfBirth, String role, String department) {
        super(name, email, dateOfBirth);
        this.staffID = staffID;
        this.role = role;
        this.department = department;
    }
    public String getStaffID() { return staffID; }
    public void setStaffID(String staffID) { this.staffID = staffID; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String generateReport(List<Person> people) {
        StringBuilder report = new StringBuilder("Report:\n");
        for (Person person : people) {
            report.append(person.toString()).append("\n");
        }
        return report.toString();
    }
    
    @Override
    public void displayDetails() {
        System.out.println(this.toString());
    }
    
   @Override
    public String toString() {
        return "Admin Staff: " + staffID + ", Name: " + getName() + ", Role: " + role + ", Department: " + department;
    }
    
     public String generateReport() {
        return "Administrative Staff Report:\n" +
               "Staff ID: " + staffID + "\n" +
               "Name: " + getName() + "\n" +
               "Role: " + role + "\n" +
               "Department: " + department + "\n";
    }
     
      @Override
    public void exportToFile(String filename) {
        System.out.println("Exporting administrative staff report to file: " + filename);
    }
}

