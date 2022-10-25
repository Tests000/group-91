package input.random;

import models.Employee;
import factories.ListFactory;

import java.util.List;

public class RandomEmployeeAdd{
    private RandomEmployeeAdd(){

    }

    private static int generateRandomPerformance(int performanceCount)
    {
        return (int)(Math.random() * performanceCount) + 1;
    }

    public static List<Employee> generateEmployees(int employeesNumber, int performancesCount) {
        List<Employee> employeeList = ListFactory.createList();

        for (int i = 0; i < employeesNumber; i++){
            int firstPerformanceIndex = generateRandomPerformance(performancesCount);
            int secondPerformanceIndex = generateRandomPerformance(performancesCount);
            employeeList.add(new Employee(firstPerformanceIndex, secondPerformanceIndex));
        }

        return employeeList;
    }
}
