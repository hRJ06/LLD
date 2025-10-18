package Template_Method_Pattern;

public class ExcelParser extends DataParser{
    @Override
    protected void parseData() {
        System.out.println("Parsing Excel data.");
    }
}
