package Template_Method_Pattern;

public class ParserApplication {
    public static void main(String[] args) {
        DataParser jsonParser = new JSONParser();
        DataParser excelParser = new ExcelParser();
        jsonParser.parse();
        excelParser.parse();
    }
}
