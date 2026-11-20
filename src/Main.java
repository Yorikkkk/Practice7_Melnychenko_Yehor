import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Створюємо директора та фірму
        Employee director = new Employee("Олександр", "Коваленко", 85000.0);
        Firm firm = new Firm("TechSolutions", director);

        // 2. Створюємо перший відділ (розробки) та його працівників
        Employee devHead = new Employee("Ірина", "Мельник", 65000.0);
        Department devDept = new Department("Відділ розробки", devHead);
        devDept.addEmployee(new Employee("Дмитро", "Бондаренко", 55000.0));
        // Співробітник із ЗП вищою, ніж у начальника відділу (72000 > 65000)
        devDept.addEmployee(new Employee("Максим", "Ткаченко", 72000.0));

        // 3. Створюємо другий відділ (маркетингу) та його працівників
        Employee mktHead = new Employee("Олена", "Шевченко", 50000.0);
        Department mktDept = new Department("Відділ маркетингу", mktHead);
        mktDept.addEmployee(new Employee("Анна", "Кравченко", 35000.0));
        mktDept.addEmployee(new Employee("Сергій", "Мороз", 40000.0));

        // Додаємо відділи до фірми
        firm.addDepartment(devDept);
        firm.addDepartment(mktDept);

        // Перевірка Задачі 1 (for-each)
        System.out.println("=== Задача 1: Максимальна заробітна платня ===");
        System.out.println("Максимальна ЗП на фірмі: " + firm.findMaxSalary() + " грн\n");

        // Перевірка Задачі 2 (типізований ітератор)
        System.out.println("=== Задача 2: Відділи, де ЗП працівника вища за ЗП начальника ===");
        List<Department> targetDepartments = firm.findDepartmentsWithHigherPaidEmployees();
        for (Department d : targetDepartments) {
            System.out.println("- " + d);
        }
        System.out.println();

        // Перевірка Задачі 3 (нетипізований ітератор)
        System.out.println("=== Задача 3: Список усіх співробітників фірми ===");
        List<Employee> allEmployees = firm.getAllEmployees();
        for (Employee e : allEmployees) {
            System.out.println("- " + e);
        }
    }
}