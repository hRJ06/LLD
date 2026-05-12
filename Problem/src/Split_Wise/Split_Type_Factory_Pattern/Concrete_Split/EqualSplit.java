package Split_Wise.Split_Type_Factory_Pattern.Concrete_Split;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Split_Wise.Split_Type_Factory_Pattern.Split;
import Split_Wise.Utility.User;

public class EqualSplit implements Split { 

    @Override
    public Map<User, Double> calculateSplit(double amount, List<User> participant, Map<String, Object> splitDetail) {
        double amountPerPerson = amount / participant.size();
        Map<User, Double> split = new HashMap<>();
        for(User user : participant) {
            split.put(user, amountPerPerson);
        }
        return split;
    }
}
