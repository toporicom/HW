package HW2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HW2 {
    public static ArrayList<Cars> cars = new ArrayList<>() {{
        add(new Cars("Volvo s90", 2015, "x001xx"));
        add(new Cars("Lada Vesta", 2020, "x002xx"));
        add(new Cars("Kia Rio", 2012, "x003xx"));
    }};
    private static Scanner scan = new Scanner(System.in);

    public static void start() {
        System.out.println("Выберите действие: ");
        System.out.println("1: добавить новый автомобиль в список \n" +
                "2: удалить автомобиль из списка по его регистрационному номеру \n" +
                "3: удалить все автомобили из списка \n" +
                "4: вывести весь список \n" +
                "5: выход \n");
        int choose = scan.nextInt();
        scan.nextLine();
        switch (choose) {
            case 1: {
                addCar();
                break;
            }
            case 2: {
                delBySerial();
                break;
            }
            case 3: {
                delAll();
                break;
            }
            case 4: {
                outAllArr();
                break;
            }
            case 5:
                break;
        }
    }

    private static void outAllArr() {
        cars.forEach(System.out::println);
        start();
    }

    private static boolean ifThereThisCar(String serial) {
        return cars.stream().anyMatch(x -> x.getSerial().equals(serial));
    }

    public static void addCar() {
        System.out.println("Введите марку машины");
        String mark = scan.nextLine();
        System.out.println("Введите год выпуска машины");
        int age = scan.nextInt();
        System.out.println("Введите регистрационный номер машины");
        scan.nextLine();
        String serial = scan.nextLine();
        while (ifThereThisCar(serial)) {
            System.out.println("Такой регистрационный номер машины уже имеется, введите другой");
            serial = scan.nextLine();
        }

        cars.add(new Cars(mark, age, serial));
        start();
    }

    private static void delBySerial() {
        System.out.println("Введите регистрационный номер машины");
        String serialNum = scan.nextLine();
        Iterator<Cars> iter = cars.iterator();
        while (iter.hasNext()) {
            Cars c = iter.next();
            if (c.getSerial().equals(serialNum)) iter.remove();
        }
        start();
    }

    private static void delAll() {
        cars.clear();
        start();
    }

    public static void main(String[] args) {
        start();
    }
}
