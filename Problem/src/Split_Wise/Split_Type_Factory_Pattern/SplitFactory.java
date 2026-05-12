package Split_Wise.Split_Type_Factory_Pattern;

import Split_Wise.Split_Type_Factory_Pattern.Concrete_Split.EqualSplit;
import Split_Wise.Split_Type_Factory_Pattern.Concrete_Split.PercentageSplit;

public class SplitFactory {
    public static Split createSplit(String splitType) {
        switch (splitType) {
            case "EQUAL":
                return new EqualSplit();
            case "PERCENTAGE":
                return new PercentageSplit();
            default:
                throw new IllegalArgumentException("Invalid Split Type - " + splitType);
        }
    }
}
