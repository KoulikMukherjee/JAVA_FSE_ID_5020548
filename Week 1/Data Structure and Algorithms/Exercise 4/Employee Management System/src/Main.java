public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee("E1", "John", "WebDeveloper", 75000));
        manager.addEmployee(new Employee("E2", "Rose", "UI/UX Designer", 65000));
        manager.addEmployee(new Employee("E3", "Martha", "Employee Manager", 85000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for employee with ID E1:");
        Employee employee = manager.searchEmployeeById("E1");
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting employee with ID E2:");
        manager.deleteEmployeeById("E2");

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}