package Chain_Of_Responsibility_Design_Pattern;

import Chain_Of_Responsibility_Design_Pattern.Concrete_Approver.Director;
import Chain_Of_Responsibility_Design_Pattern.Concrete_Approver.HR;
import Chain_Of_Responsibility_Design_Pattern.Concrete_Approver.Manager;
import Chain_Of_Responsibility_Design_Pattern.Concrete_Approver.Supervisor;

public class Main {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver supervisor = new Supervisor();
        Approver hr = new HR();

        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);
        director.setNextApprover(hr);

        int leaveDays = 20;
        supervisor.approveRequest(leaveDays);
    }
}
