package Chain_Of_Responsibility_Design_Pattern.Concrete_Approver;

import Chain_Of_Responsibility_Design_Pattern.Approver;

public class Manager extends Approver {
    @Override
    public void approveRequest(int leaveDays) {
        if(leaveDays <= 7) {
            System.out.println("Manager approved the leave.");
        }
        else if(nextApprover != null) {
            nextApprover.approveRequest(leaveDays);
        }
    }
}
