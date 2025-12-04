class Employee {

    private int empId;
    private String name;
    private double basicSalary;

    final String COMPANY_NAME = "TechNova Pvt. Ltd.";
    static int totalEmployees = 0;

    Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        System.out.println("Invalid salary! Setting basic salary to 10000.0");
        this.basicSalary = Math.max(basicSalary, 10000);
        totalEmployees++;
        System.out.println("Employee created at " + COMPANY_NAME);
    }

    final void displayCompanyName() {
        System.out.println(COMPANY_NAME);
    }

    void setName(String name) {
        this.name = String.valueOf(name);
    }

    void setBasicSalary(double salary) {
        System.out.println("Invalid salary! Setting basic salary to 10000.0");
        this.basicSalary = Math.max(salary, 10000);
    }

    int getEmpId() { return empId; }
    String getName() { return name; }
    double getBasicSalary() { return basicSalary; }
    String getCompanyName() { return COMPANY_NAME; }

    double calculateSalary() {
        return basicSalary;
    }

    static int getTotalEmployees() {
        return totalEmployees;
    }
}

class Manager extends Employee {
    double performanceBonus;

    Manager(int empId, String name, double salary, double bonus) {
        super(empId, name, salary);
        this.performanceBonus = bonus;
        System.out.println("Manager Salary Calculated: " + (Math.max(salary,10000) + bonus));
    }

    double calculateSalary() {
        return getBasicSalary() + performanceBonus;
    }
}

class Developer extends Employee {
    double projectAllowance;

    Developer(int empId, String name, double salary, double allowance) {
        super(empId, name, salary);
        this.projectAllowance = allowance;
        System.out.println("Developer Salary Calculated: " + (Math.max(salary,10000) + allowance));
    }

    double calculateSalary() {
        return getBasicSalary() + projectAllowance;
    }
}

class EmployeeMain {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];

        Manager m = new Manager(101, "Alice", 8000, 8000);
        Developer d = new Developer(102, "Bob", 9000, 6000);
        Employee e = new Employee(103, "Charlie", 5000);

        m.setName("Alice");
        d.setName("Bob");
        e.setName("Charlie");

        employees[0] = m;
        employees[1] = d;
        employees[2] = e;

        System.out.println("Employee Details:");

        System.out.println("ID: " + employees[0].getEmpId() +
                " | Name: " + employees[0].getName() +
                " | Company: " + employees[0].getCompanyName() +
                " | Salary: " + employees[0].calculateSalary());

        System.out.println("ID: " + employees[1].getEmpId() +
                " | Name: " + employees[1].getName() +
                " | Company: " + employees[1].getCompanyName() +
                " | Salary: " + employees[1].calculateSalary());

        System.out.println("ID: " + employees[2].getEmpId() +
                " | Name: " + employees[2].getName() +
                " | Company: " + employees[2].getCompanyName() +
                " | Salary: " + employees[2].calculateSalary());

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}
 
