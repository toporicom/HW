package DZ3;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;

public class FileApplication {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько файлов вы хотите склеить?");
        int num = Integer.parseInt(scanner.nextLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу");
        String file1 = reader.readLine();
        File file = new File(Paths.get(file1).getParent() + "\\answer.txt");
        FileOutputStream mainFile = new FileOutputStream(file);
        for (int i = 0; i < num; i++) {
            if (i != 0){
                System.out.println("Введите путь к файлу");
                file1 = reader.readLine();
            }
            FileInputStream fileInputStream = new FileInputStream(file1);
            byte[] buffer = new byte[fileInputStream.available()];
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
            }

            mainFile.write(buffer);
            fileInputStream.close();
        }

        System.out.println(new String(Files.readAllBytes(Path.of(Paths.get(file1).getParent() + "\\answer.txt"))));
        mainFile.close();
    }
}
