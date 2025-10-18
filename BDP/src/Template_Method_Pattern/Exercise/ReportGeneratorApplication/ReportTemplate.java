package Template_Method_Pattern.Exercise.ReportGeneratorApplication;

abstract class ReportTemplate {
    public final void generateReport() {
        gatherData();
        processData();
        formatReport();
        printReport();
    }

    protected abstract void gatherData();
    protected abstract void processData();

    protected void formatReport() {
        System.out.println("Formatting the report with appropriate layout and style.");
    }
    protected void printReport() {
        System.out.println("Printing the report for final review and distribution.");
    }
}
