package Template_Method_Pattern;

public class JSONParser extends DataParser{
    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data.");
    }
}
