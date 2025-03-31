// Вариант 2
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in; 
        HolidayCamp camp;

        // Заполнение из файла
        try {
            in = new Scanner(new File("file.txt"));
            camp = new HolidayCamp(in);
            camp.print();        
            in.close();
        } catch (FileNotFoundException e) {    
            System.out.print("File not found");
        }

        // Заполнение случайными значениями
        System.out.println();
        camp = new HolidayCamp();
        camp.print();

        // Заполнение из консоли
        System.out.println();
        in = new Scanner(System.in);
        camp = new HolidayCamp(in, System.out);
        System.out.println();
        camp.print();
    }
}
