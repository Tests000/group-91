package input.random;

import input.EmployeesAdd;
import models.Employee;
import factories.ListFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEmployeeAdd implements EmployeesAdd {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    @Override
    public List<Employee> inputEmployees(int performancesCount) {
        List<Employee> employeeList = ListFactory.createList();

        for (int i = 0; i < Employee.EMPLOYEES_NUMBER; i++){
            int firstPerformanceIndex = random.nextInt(1, performancesCount + 1);
            int secondPerformanceIndex = random.nextInt(1, performancesCount + 1);
            employeeList.add(new Employee(firstPerformanceIndex, secondPerformanceIndex));
        }

        return employeeList;
    }
}
