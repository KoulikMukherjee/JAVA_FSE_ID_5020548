class EmployeeManager {
    private Employee[] employees;
    private int size;
    
    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array Overflow. Cannot add more employees.");
        }
    }
    
    public Employee searchEmployeeById(String employeeId) {
        for (Employee employee : employees) {
            if (employee != null && employee.getEmployeeId().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void deleteEmployeeById(String employeeId) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                String temp = employees[i].getEmployeeId();

                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[size - 1] = null;
                size--;
                System.out.println("Employee " + temp + " deleted.");
                found = true;
                break;
            }
        }
        if (!found) {System.out.println("Employee not found");}
    }
}