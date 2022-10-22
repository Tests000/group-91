package input.console;

import input.EmployeesAddFromInputStream;
import models.Employee;
import factories.ListFactory;
import java.util.List;
import java.util.logging.Logger;

public class ConsoleEmployeesAddFromInputStream implements EmployeesAddFromInputStream {
    private final Logger logger;

    public ConsoleEmployeesAddFromInputStream(Logger logger){
        this.logger = logger;
    }
    @Override
    public List<Employee> inputEmployees(int performancesCount){
        List<Employee> employeeList = ListFactory.createList();
        ConsoleInput consoleInput = new ConsoleInput(logger);

        int employeesCount = consoleInput.inputIntInRange(
                "Введите количество добавляемых работников",
                1,
                Employee.EMPLOYEES_NUMBER
        );

        for (int i = 0; i < employeesCount; i++){
            employeeList.add(Employee.fromConsole(consoleInput, performancesCount));
        }

        return employeeList;
    }
}
