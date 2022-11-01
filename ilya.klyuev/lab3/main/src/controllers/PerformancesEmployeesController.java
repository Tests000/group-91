package controllers;

import input.EmployeesAddFromInputStream;
import random.RandomEmployeeGenerator;
import models.Employee;
import models.Performance;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PerformancesEmployeesController {
    public static final int MAX_EMPLOYEES_NUMBER = 12000;

    private final EmployeesAddFromInputStream employeesInputFromAddStream;

    // будем кешировать ответы, чтобы не считать при повторном запросе
    private Set<Performance> maxPopularPerformances = null;
    private Set<Performance> performancesNotTickets = null;

    public PerformancesEmployeesController(EmployeesAddFromInputStream employeesInputFromInputStream){

        this.employeesInputFromAddStream = employeesInputFromInputStream;
    }

    public Set<Performance> getMaxPopularPerformances(){
        if (maxPopularPerformances != null){
            return maxPopularPerformances;
        }

        int maxTicketsCount = 0;

        // calculate max
        for (var performance : Performance.values()){
            maxTicketsCount = Math.max(maxTicketsCount, performance.getTicketsCount());
        }

        maxPopularPerformances = new HashSet<>();

        // select max
        for(var performance : Performance.values()){
            if (performance.getTicketsCount() == maxTicketsCount){
                maxPopularPerformances.add(performance);
            }
        }

        return maxPopularPerformances;
    }

    public Set<Performance> getPerformancesNotTickets(){
        if (performancesNotTickets != null){
            return performancesNotTickets;
        }

        performancesNotTickets = new HashSet<>();

        for (Performance performance : Performance.values()) {
            if (performance.getTicketsCount() == 0){
                performancesNotTickets.add(performance);
            }
        }

        return performancesNotTickets;
    }

    public void addEmployeesFromInputStream(){
        var newEmployees = employeesInputFromAddStream.inputEmployees(MAX_EMPLOYEES_NUMBER);
        updatePerformances(newEmployees);
    }

    public void addEmployeesByRandom(){
        var newEmployees =  RandomEmployeeGenerator.generateEmployees(MAX_EMPLOYEES_NUMBER);
        updatePerformances(newEmployees);
    }

    private void updatePerformances(List<Employee> newEmployees){
        for (Employee employee : newEmployees) {
            employee.getFirstPerformance().addTicket();
            employee.getSecondPerformance().addTicket();
        }
        resetPerformancesCache();
    }

    private void resetPerformancesCache(){
        maxPopularPerformances = null;
        performancesNotTickets = null;
    }
}
