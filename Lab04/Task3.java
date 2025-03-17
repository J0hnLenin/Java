import java.util.Arrays;
import java.util.Set;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Task3 {
    // 3.8. Дан двухмерный массив размерности n x m. 
    // Определить есть ли в массиве одинаковые элементы. 
    public static boolean check(int[][] a, int N, int M){
        // Set<Integer> unic = Arrays.stream(a)
        //     .flatMapToInt(Arrays::stream)
        //     .boxed()
        //     .collect(Collectors.toSet());
        // return unic.size() != N*M;
        LinkedList<Integer> unic = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(unic.contains(a[i][j]))
                    return true;
                unic.add(a[i][j]);
            }
        }
        return false;
    }
    public void main(String[] args) {
        final int N = 5;
        final int M = 6;
        int [][] a = new int[N][M];
        
        // Заполняем массив так, чтобы были одинаковые элементы
        System.out.println("Массив:");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                a[i][j] = i+j;
                System.out.printf("%d ", a[i][j]);
            }
            System.out.print("\n");
        }
        System.out.printf("Есть одинаковые элементы: %b\n\n",check(a, N, M));

        // Заполняем массив так, чтобы были разные элементы
        System.out.println("Массив:");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                a[i][j] = 3*i+5*j;
                System.out.printf("%d ", a[i][j]);
            }
            System.out.print("\n");
        }
        System.out.printf("Есть одинаковые элементы: %b\n\n",check(a, N, M));

        
    }
}
