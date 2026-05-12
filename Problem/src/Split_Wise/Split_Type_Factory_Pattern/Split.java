package Split_Wise.Split_Type_Factory_Pattern;

import java.util.List;
import java.util.Map;

import Split_Wise.Utility.User;

public interface Split {
    Map<User, Double> calculateSplit(double amount, List<User> participant, Map<String, Object> splitDetail);
}
