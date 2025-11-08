package Chain_Of_Responsibility_Design_Pattern.Concrete_Approver;

import Chain_Of_Responsibility_Design_Pattern.Approver;

public class HR extends Approver{
    @Override
    public void approveRequest(int leaveDays) {
        System.out.println("HR: Leave request require further discussion.");
    }
}
