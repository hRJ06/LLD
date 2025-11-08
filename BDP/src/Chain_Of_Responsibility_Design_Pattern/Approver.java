package Chain_Of_Responsibility_Design_Pattern;

public abstract class Approver {
    protected Approver nextApprover;
    public void setNextApprover(Approver approver) {
        this.nextApprover = approver;
    }
    public abstract void approveRequest(int leaveDays);
}
