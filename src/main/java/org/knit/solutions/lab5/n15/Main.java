package org.knit.solutions.lab5.n15;

// Пример использования
public class Main {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image2.png");

        System.out.println("Первое отображение image1:");
        image1.display();
        System.out.println("Второе отображение image1 (без повторной загрузки):");
        image1.display();

        System.out.println("Отображение image2:");
        image2.display();
    }
}