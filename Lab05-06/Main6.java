// Вариант 2
import java.util.ArrayList;

public class Main6 {
    public static void main(String[] args) {
        Integer numberOfCamps = 30;
        ArrayList<HolidayCamp> camps = new ArrayList<HolidayCamp>();
        for (int i = 0; i < numberOfCamps; i++) {
            camps.add(new HolidayCamp());
        }
        
        System.out.println("Элементы, где есть символ а:");
        camps.stream().filter(x -> x.toString().indexOf("a") >= 0).forEach(System.out::println);
        System.out.println();
        
        System.out.println("Элементы, хэш которых делится на 10:");
        camps.stream().map(x -> x.hashCode()).filter(x -> x%10 == 0).forEach(System.out::println);
        System.out.println();
        
        System.out.println("Дописали _abacaba к первым 3-м элементам:");
        camps.stream().peek(x -> {x.setTitle(x.getTitle() + "_abacaba");}).limit(3).forEach(System.out::println);
        System.out.println();
        
        System.out.println("Вывели последние 3-м элемента:");
        camps.stream().skip(camps.size() - 3).forEach(System.out::println);
        System.out.println();

        System.out.println("Преобразовали в массив первые 6 элементов:");
        var arr = camps.stream().limit(6).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);   
        }
        System.out.println();

        System.out.print("Максимальное количество маршрутов: ");
        System.out.println(camps.stream().map(x -> x.getRoutes().size()).max(Integer::compare).get());
        
        System.out.print("Есть ли кэмп, где больше 4 маршрутов: ");
        System.out.println(camps.stream().anyMatch(x -> x.getRoutes().size() > 4));

        System.out.print("Правда ли, что количество маршрутов у каждого кэмпа меньше 4: ");
        System.out.println(camps.stream().allMatch(x -> x.getRoutes().size() <= 4));
    }
}
