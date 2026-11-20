import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Firm {
    private String name;
    private Employee director; // Директор фірми
    private List<Department> departments; // Список відділів

    public Firm(String name, Employee director) {
        this.name = name;
        this.director = director;
        this.departments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * Задача 1: Знайти значення максимальної заробітної платні з усіх працівників,
     * включаючи начальників та директора.
     * Метод перегляду (c): типізований цикл «for-each».
     */
    public double findMaxSalary() {
        double maxSalary = director != null ? director.getSalary() : 0.0;

        for (Department dept : departments) {
            if (dept.getHead() != null && dept.getHead().getSalary() > maxSalary) {
                maxSalary = dept.getHead().getSalary();
            }
            for (Employee emp : dept.getEmployees()) {
                if (emp.getSalary() > maxSalary) {
                    maxSalary = emp.getSalary();
                }
            }
        }
        return maxSalary;
    }

    /**
     * Задача 2: Визначити відділ(и), в якому хоча б один зі співробітників
     * отримує заробітну платню вищу за платню свого начальника.
     * Метод перегляду (b): типізований ітератор.
     */
    public List<Department> findDepartmentsWithHigherPaidEmployees() {
        List<Department> result = new ArrayList<>();

        Iterator<Department> deptIterator = departments.iterator();
        while (deptIterator.hasNext()) {
            Department dept = deptIterator.next();
            double headSalary = dept.getHead().getSalary();

            Iterator<Employee> empIterator = dept.getEmployees().iterator();
            while (empIterator.hasNext()) {
                Employee emp = empIterator.next();
                if (emp.getSalary() > headSalary) {
                    result.add(dept);
                    break; // Достатньо хоча б одного такого співробітника у відділі
                }
            }
        }
        return result;
    }

    /**
     * Задача 3: Скласти список усіх співробітників фірми, включаючи начальників та директора.
     * Метод перегляду (a): нетипізований ітератор.
     */
    @SuppressWarnings("rawtypes")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();

        if (director != null) {
            allEmployees.add(director);
        }

        Iterator deptIterator = departments.iterator();
        while (deptIterator.hasNext()) {
            Department dept = (Department) deptIterator.next();
            if (dept.getHead() != null) {
                allEmployees.add(dept.getHead());
            }

            Iterator empIterator = dept.getEmployees().iterator();
            while (empIterator.hasNext()) {
                Employee emp = (Employee) empIterator.next();
                allEmployees.add(emp);
            }
        }
        return allEmployees;
    }
}