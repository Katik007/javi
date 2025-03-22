package org.knit.solutions.lab1;

public class Main {
    public static void main(String[] args) {
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

