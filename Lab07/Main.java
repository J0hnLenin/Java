// Вариант 2
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Personnel> list = new ArrayList<Personnel>();
        list.add(new Worker(
            "Владислав Сидоров", 
            LocalDate.now(), 
            20000, 
            true));
        list.add(new Engineer(
            "Василий Смирнов", 
            LocalDate.now(), 
            25000, 
            true, 
            "высокая"));

        ArrayList<String> projects = new ArrayList<String>();
        projects.add("проект1");
        projects.add("проект2");
        list.add(new Administrator(
            "Андрей Жилин", 
            LocalDate.now(), 
            60000, 
            projects, 
            new ArrayList<Personnel>()));
        
        for (Personnel personnel: list) {
            System.out.println(personnel);
            if (personnel instanceof Worker){
                ((Worker)personnel).work();
            }
            
            if (personnel instanceof Administrator){
                ((Administrator)personnel).manage();
            }
        }
        System.out.println();
        System.out.println(findByName(list, "Владислав Сидоров"));
    }

    static public Personnel findByName(ArrayList<Personnel> list, String key){
        for (Personnel personnel: list) {
            if(personnel.getName() == key){
                return personnel;
            }
        }
        return null;
    }
}
