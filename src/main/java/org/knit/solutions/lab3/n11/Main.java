package org.knit.solutions.lab3.n11;

// Пример работы в Main классе
public class Main {
    public static void main(String[] args) {
        // Создаем акции
        Stock teslaStock = new Stock("Tesla", 850.00);
        Stock appleStock = new Stock("Apple", 500.00);
        Stock mercStock = new Stock("Mercedes", 1000.00);

        // Создаем наблюдателей
        MobileApp mobileAppUser1 = new MobileApp("User1");
        MobileApp mobileAppUser2 = new MobileApp("User2");
        EmailNotifier emailNotifier1 = new EmailNotifier("user1@google.com");
        EmailNotifier emailNotifier2 = new EmailNotifier("user2@google.com");

        // Подписываем наблюдателей на акцию "Tesla"
        teslaStock.addObserver(mobileAppUser1);
        teslaStock.addObserver(emailNotifier1);

        // Подписываем наблюдателей на акцию "Apple"
        appleStock.addObserver(mobileAppUser2);
        appleStock.addObserver(emailNotifier2);

        // Подписываем наблюдателей на акцию "Mercedes"
        mercStock.addObserver(mobileAppUser1);
        mercStock.addObserver(emailNotifier1);

        System.out.println("Первоначальная цена Tesla: $" + teslaStock.getPrice());
        System.out.println("Первоначальная цена Apple: $" + appleStock.getPrice());
        System.out.println("Первоначальная цена Mercedes: $" + mercStock.getPrice());
        System.out.println();
        // Изменяем цену акции "Tesla"
        teslaStock.setPrice(855.50);
        System.out.println();

        // Изменяем цену акции "Apple"
        appleStock.setPrice(172.00);
        System.out.println();

        // Изменяем цену акции "Mercedes"
        mercStock.setPrice(955.00);
        System.out.println();

        // Отписываем emailNotifier1 от акции "Tesla"
        teslaStock.removeObserver(emailNotifier1);
        System.out.println("Отписываем emailNotifier1 от Tesla.");
        System.out.println();

        // Снова меняем цену акции "Tesla" - только mobileAppUser1 получит уведомление
        teslaStock.setPrice(860.20);
        System.out.println();
    }
}