package org.knit.solutions.lab5.n15;

import java.util.concurrent.TimeUnit;

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Загрузка изображения: " + filename + " с сервера...");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Изображение: " + filename + " загружено.");
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения: " + filename);
    }
}
