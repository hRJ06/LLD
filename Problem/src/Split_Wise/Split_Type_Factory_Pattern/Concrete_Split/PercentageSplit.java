package Split_Wise.Split_Type_Factory_Pattern.Concrete_Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Split_Wise.Split_Type_Factory_Pattern.Split;
import Split_Wise.Utility.User;

public class PercentageSplit implements Split {

    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participant, Map<String, Object> splitDetail) {
        Map<User, Double> percentages = (Map<User, Double>) splitDetail.get("percentage");
        Map<User, Double> split = new HashMap<>();

        for(User user : participant) {
            double percentage = percentages.getOrDefault(user, 0.0);
            split.put(user, amount * percentage / 100.0);
        }
        return split;
    }
}
