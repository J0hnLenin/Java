class Task2 {
    // 2.3.	Дан одномерный массив А состоящий из 2n элементов. 
    // Переставить элементы массива следующим образом: 
    // a[n+1], a[n+2], . . .,a[2n], a[n], a[n-1], . . ., a[1] 

    public void flip(int [] a, int i, int j){
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void printArray(int[] array, int length){
        for(int i=0; i<length; i++){
            System.out.printf("%d ", array[i]);
        }
        System.out.print("\n");
    }

    public void main(String[] args) {
        final int N = 5;
        int [] a = new int[2*N];
        
        for(int i=0; i<2*N; i++){
            a[i] = i;
        }
        printArray(a, 2*N);

        for(int i=0; i<N; i++){
            flip(a, i, 2*N - i - 1);
        }

        for(int i=0; i<(N/2); i++){
            flip(a, i, N - i - 1);
        }

        printArray(a, 2*N);
    }
}