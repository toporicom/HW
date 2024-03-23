package DZ4;

import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static Car addCar(){
        System.out.println("Введите имя автомобиля:");
        String name = scanner.nextLine();
        System.out.println("Введите марку автомобиля:");
        String mark = scanner.nextLine();
        System.out.println("Введите год выпуска автомобиля:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите массу автомобиля:");
        int mass = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите длину автомобиля:");
        int length = Integer.parseInt(scanner.nextLine());
        Car car = new Car(name, mark, age, mass, length);
        return car;
    }

    public static void main(String[] args) {
        Car car = addCar();
        System.out.println("Введите путь сохранения: ");
        String path = scanner.nextLine();
        myThread sr = new myThread(car, path + "\\Object.ser");
        Thread th = new Thread(sr);
        deSer dsr = new deSer(path + "\\Object.ser");
        Thread th2 = new Thread(dsr);
        try {
            th.start();
            th.join();
            th2.start();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
