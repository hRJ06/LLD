package Template_Method_Pattern.Exercise.ReportGeneratorApplication;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReportTemplate salesReport = new SalesReport(sc);
        System.out.println("Generating Sales Report.");
        salesReport.generateReport();

        ReportTemplate employeeReport = new EmployeeReport(sc);
        System.out.println("Generating Sales Report.");
        employeeReport.generateReport();

        ReportTemplate inventoryReport = new InventoryReport(sc);
        System.out.println("Generating Sales Report.");
        inventoryReport.generateReport();
    }
}
