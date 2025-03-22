package org.knit.solutions.lab1;

public abstract class Approver {
    protected Approver nextApprover;

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public void processRequest(Problem problem) {
        if (canApprove(problem.getDiff())) {
            approve(problem);
        } else if (nextApprover != null) {
            nextApprover.processRequest(problem);
        } else {
            System.out.println("Ни один менеджер не смог одобрить проблему: " + problem.getDescription() + "; diff - " + problem.getDiff());
        }
    }

    protected abstract boolean canApprove(int diff);

    protected abstract void approve(Problem problem);
}
