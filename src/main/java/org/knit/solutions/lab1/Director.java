package org.knit.solutions.lab1;

public class Director extends Approver {
    @Override
    protected boolean canApprove(int diff) {
        return (100 <= diff) && (diff <= 500);
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Директор одобрил задачу: " + problem.getDescription() + "; diff - " + problem.getDiff());
    }
}
