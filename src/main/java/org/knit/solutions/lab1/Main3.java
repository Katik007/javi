package org.knit.solutions.lab1;
public class Main3 {
    public static void main(String[] args) {
        try {
            Transport businessCar = Factory.createTransport("business");
            System.out.println(businessCar.getSpecifications());

            Transport familyVan = Factory.createTransport("family");
            System.out.println(familyVan.getSpecifications());

            Transport motorbike = Factory.createTransport("delivery");
            System.out.println(motorbike.getSpecifications());

            Transport unknown = Factory.createTransport("kuku");
            System.out.println(unknown.getSpecifications());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
