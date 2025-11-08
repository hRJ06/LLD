package Chain_Of_Responsibility_Design_Pattern.Concrete_Approver;

import Chain_Of_Responsibility_Design_Pattern.Approver;

public class Supervisor extends Approver {
    @Override
    public void approveRequest(int leaveDays) {
        if(leaveDays <= 3) {
            System.out.println("Supervisor approved the leave.");
        }
        else if(nextApprover != null) {
            nextApprover.approveRequest(leaveDays);
        }
    }
}
