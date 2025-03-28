package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab2.n7.Warehouse;
import org.knit.solutions.lab2.n9.*;

import java.util.concurrent.*;


@TaskDescription(taskNumber = 7, taskDescription = "Задача «Конвейер сборки деталей» вместе с дополнениями")
public class Task29 implements Solution {
    @Override
    public void execute() {
        Factory factory = new Factory();
        factory.initProduction();
    }
}

