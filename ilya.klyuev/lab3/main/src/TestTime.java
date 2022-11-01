import controllers.PerformancesEmployeesController;

public class TestTime {
    public static long test(int randomGenerationsCount){
        long startTime = System.currentTimeMillis();

        PerformancesEmployeesController performancesEmployeesController = new PerformancesEmployeesController(
                null
        );

        for (int i = 0; i < randomGenerationsCount; i++){
            performancesEmployeesController.addEmployeesTicketsByRandom();
        }

        performancesEmployeesController.getMaxPopularPerformances();
        performancesEmployeesController.getPerformancesNotTickets();

        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
