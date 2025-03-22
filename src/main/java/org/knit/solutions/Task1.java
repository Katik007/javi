package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.lab1.*;

@TaskDescription(taskNumber = 1, taskDescription = "Задача про менеджеров")
public class Task1 implements Solution{
    @Override
    public void execute() {
        // Создаем обработчиков
        Approver junior = new Junior();
        Approver senior = new Senior();
        Approver director = new Director();

        // Устанавливаем цепочку: junior -> senior -> director
        junior.setNextApprover(senior);
        senior.setNextApprover(director);

        // Запросы на одобрение разных сумм
        junior.processRequest(new Problem("Маленькая проблема, которую легко выполнит мл.менеджер", 20));   // Младший менеджер одобряет
        junior.processRequest(new Problem("Средняя проблема, которую легко выполнит ст.менеджер", 50));  // Старший менеджер одобряет
        junior.processRequest(new Problem("Серьезная проблема, которую директор с легкостью выполнит", 100)); // Директор одобряет
        junior.processRequest(new Problem("Очень сложная проблема, над которой директор подумает", 500)); // Директор одобряет
        junior.processRequest(new Problem("Невыполнимая задача", 600)); // Превышает лимит – запрос отклонен}
    }
}
