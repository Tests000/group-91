import controllers.PerformancesEmployeesController;

public class TestTime {
    public static long Test(){
        long startTime = System.currentTimeMillis();

        PerformancesEmployeesController performancesEmployeesController = new PerformancesEmployeesController(
                null,
                10000
        );

        performancesEmployeesController.addEmployeesByRandom();
        performancesEmployeesController.addEmployeesByRandom();

        performancesEmployeesController.getMaxPopularPerformances();
        performancesEmployeesController.getPerformancesNotTickets();

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
