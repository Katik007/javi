package org.knit.solutions.lab1;

public class Senior extends Approver {
    @Override
    protected boolean canApprove(int diff) {
        return (diff<=50) && (diff < 100);
    }

    @Override
    protected void approve(Problem problem) {
        System.out.println("Старший менеджер решил задачу: " + problem.getDescription() + "; diff - " + problem.getDiff());
    }
}

