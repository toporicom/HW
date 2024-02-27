package HW;

import java.util.*;

public class AutoSrv {
    public static void main(String[] args) {
        System.out.println("Агамогланов Фархад РИБО-04-22 1 вариант");
        Scanner scan = new Scanner(System.in);
        int numberOfCars = scan.nextInt();
        scan.nextLine();
        Car[] cars = new Car[numberOfCars];
        for (int i = 0; i < numberOfCars; i++){
            cars[i] = new Car(scan.nextLine());
            cars[i].setName(cars[i].getName().replaceAll("а", "о"));
            cars[i].setName(cars[i].getName().replaceAll("i", "e"));
            cars[i].setName(cars[i].getName().toLowerCase());
        }
        Arrays.stream(cars).map(Car::getName).forEach(System.out::println);
    }
}
