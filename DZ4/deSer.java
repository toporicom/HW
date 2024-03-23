package DZ4;

import java.io.*;

public class deSer implements Runnable{
    private String path;
    public deSer(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        if (this.path != null && new File(this.path).exists()) {
            FileInputStream fis;
            try {
                fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Car car = (Car) ois.readObject();
                ois.close();
                System.out.println(car.toString());
                System.out.println(path);

            } catch (IOException | ClassNotFoundException ex){
                System.out.println("Error:" + this.path);
                System.out.println(ex.getMessage());
            }
        }
    }
}
