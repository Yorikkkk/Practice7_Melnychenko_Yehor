import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Employee head; // Начальник відділу
    private List<Employee> employees; // Список працівників

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String toString() {
        return "Відділ '" + name + "' (Начальник: " + head.getFirstName() + " " + head.getLastName() + ")";
    }
}