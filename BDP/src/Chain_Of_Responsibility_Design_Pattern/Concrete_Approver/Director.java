package Chain_Of_Responsibility_Design_Pattern.Concrete_Approver;

import Chain_Of_Responsibility_Design_Pattern.Approver;

public class Director extends Approver{
    @Override
    public void approveRequest(int leaveDays) {
        if(leaveDays <= 14) {
            System.out.println("Director approved the leave.");
        }
        else if(nextApprover != null) {
            nextApprover.approveRequest(leaveDays);
        } else {
            System.out.println("Leave request denied.");
        }
    }
}
