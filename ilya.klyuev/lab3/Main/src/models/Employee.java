package models;

import input.console.ConsoleInput;

public class Employee {
    private final int firstPerformanceIndex;
    private final int secondPerformanceIndex;

    public static final int MAX_EMPLOYEES_NUMBER = 12000;

    public Employee(int firstPerformanceIndex, int secondPerformanceIndex){
        this.firstPerformanceIndex = firstPerformanceIndex;
        this.secondPerformanceIndex = secondPerformanceIndex;
    }

    public int getFirstPerformanceIndex(){
        return firstPerformanceIndex;
    }

    public int getSecondPerformanceIndex(){
        return secondPerformanceIndex;
    }

    public static Employee fromConsole(ConsoleInput consoleInput, int performancesCount){
        System.out.println("Введите информацию о выбраных спектаклях");

        int firstPerformanceIndex = consoleInput.inputIntInRange("Введите номер 1 спекталя", 1, performancesCount);
        int secondPerformanceIndex = consoleInput.inputIntInRange("Введите номер 2 спекталя", 1, performancesCount);

        return new Employee(firstPerformanceIndex, secondPerformanceIndex);
    }
}
