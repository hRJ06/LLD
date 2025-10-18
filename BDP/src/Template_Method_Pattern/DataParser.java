package Template_Method_Pattern;

abstract class DataParser {
    public final void parse() {
        openFile();
        parseData();
        closeFile();
    }

    protected void openFile() {
        System.out.println("Opening file.");
    }

    protected void closeFile() {
        System.out.println("Closing file");
    }

    protected abstract void parseData();

}
