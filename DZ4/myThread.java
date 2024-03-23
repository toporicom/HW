package DZ4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class myThread implements Runnable{
    private Car car;
    private String path;

    public myThread(Car car, String path) {
        this.car = car;
        this.path = path;
    }

    @Override
    public void run() {
        if (this.path != null && car != null) {
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(this.path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(car);
                oos.close();
                System.out.println("Успешно");
            } catch (IOException ex){
                System.out.println("Error:" + this.path);
            }
        }
    }
}
