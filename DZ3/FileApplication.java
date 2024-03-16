package DZ3;

import java.io.*;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;

public class FileApplication {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько файлов вы хотите склеить?");
        int num = Integer.parseInt(scanner.nextLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("C:\\Users\\topor\\IdeaProjects\\untitled\\src\\DZ3\\final.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream mainFile = new FileOutputStream(file);
        for (int i = 0; i < num; i++) {
            System.out.println("Введите путь к файлу");
            String file1 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(file1);
            byte[] buffer = new byte[fileInputStream.available()]; // буфер размером с файл
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer); // считываешь буфер и заносишь туда байты из файла
            }

            mainFile.write(buffer);
            fileInputStream.close();
        }

        System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(Path.of("C:\\Users\\topor\\IdeaProjects\\untitled\\src\\DZ3\\final.txt"))));
        mainFile.close();
    }
}
