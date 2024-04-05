package DZ5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class HW5 {
    private static final Object monitor = new Object();
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread th1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        while (count % 3 != 0) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(this.getName());
                        count++;
                        monitor.notifyAll();
                    }
                }
            }
        };
        Thread th2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        while (count % 3 != 1) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(this.getName());
                        count++;
                        monitor.notifyAll();
                    }
                }
            }
        };
        Thread th3 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        while (count % 3 != 2) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(this.getName());
                        count++;
                        monitor.notifyAll();
                    }
                }
            }
        };
        System.out.println("""
                Агамогланов Фархад, рибо-04-22, 1 вариант
                """);
        th1.start();
        th2.start();
        th3.start();
        if(scanner.hasNext()){
            System.exit(0);
        }
    }
}
