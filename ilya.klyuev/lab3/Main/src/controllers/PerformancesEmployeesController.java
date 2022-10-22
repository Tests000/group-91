package controllers;

import input.EmployeesAddFromInputStream;
import input.EmployeesAdd;
import input.random.RandomEmployeeAdd;
import models.Employee;
import models.Performance;
import factories.ListFactory;

import java.util.Iterator;
import java.util.List;

public class PerformancesEmployeesController {
    private final List<Employee> employeeList = ListFactory.createList();
    private final List<Performance> performanceList;

    private final EmployeesAdd employeesInputFromAddStream;
    private final RandomEmployeeAdd randomEmployeeInput;

    // будем кешировать ответы, чтобы не считать при повторном запросе
    private List<Performance> maxPopularPerformances = null;
    private List<Performance> performancesNotTickets = null;

    public PerformancesEmployeesController
            (EmployeesAddFromInputStream employeesInputFromInputStream,
             RandomEmployeeAdd randomEmployeeInput,
             int performancesCount){

        this.employeesInputFromAddStream = employeesInputFromInputStream;
        this.randomEmployeeInput = randomEmployeeInput;

        performanceList = Performance.getPerformancesByCount(performancesCount);
    }

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public List<Performance> getMaxPopularPerformances(){
        if (maxPopularPerformances != null)
            return maxPopularPerformances;

        int maxTicketsCount = 0;

        // calculate max
        Iterator<Performance> iterator = performanceList.listIterator();
        while (iterator.hasNext()){
            maxTicketsCount = Math.max(maxTicketsCount, iterator.next().getTicketsCount());
        }

        maxPopularPerformances = ListFactory.createList();

        // select max
        iterator = performanceList.listIterator();
        while (iterator.hasNext()){
            Performance performance = iterator.next();
            if (performance.getTicketsCount() == maxTicketsCount)
                maxPopularPerformances.add(performance);
        }

        return maxPopularPerformances;
    }

    public List<Performance> getPerformancesNotTickets(){
        if (performancesNotTickets != null)
            return performancesNotTickets;

        performancesNotTickets = ListFactory.createList();

        for (Performance performance : performanceList) {
            if (performance.getTicketsCount() == 0)
                performancesNotTickets.add(performance);
        }

        return performancesNotTickets;
    }

    public void addEmployeesFromInputStream(){
        var newEmployees = employeesInputFromAddStream.inputEmployees(performanceList.size());
        addEmployees(newEmployees);
    }

    public void addEmployeesByRandom(){
        var newEmployees = randomEmployeeInput.inputEmployees(performanceList.size());
        addEmployees(newEmployees);
    }

    private void addEmployees(List<Employee> newEmployees){
        employeeList.addAll(newEmployees);

        for (Employee employee : newEmployees) {
            performanceList.get(employee.getFirstPerformanceIndex() - 1).addTicket();
            performanceList.get(employee.getSecondPerformanceIndex() - 1).addTicket();
        }

        resetPerformancesCache();
    }

    private void resetPerformancesCache(){
        maxPopularPerformances = null;
        performancesNotTickets = null;
    }
}
