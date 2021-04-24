import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp3 {

    public static void main (String[] args){

        //п.1
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray1(task1(array1));

        //п.2
        int[] array2 = new int[100];
        printArray1(task2(array2));

        //п.3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray1(task3(array3));

        //п.4
        int[][] array4 = new int[7][7];
        printArray2(task4(array4));

        //п.5
        printArray1(task5(5, 123));

        //п.6
        int[] array6 = initialArrayRandom();
        System.out.println("Минимальное значение массива array6 = " + task6Min(array6));
        System.out.println("Максимальное значение массива array6 = " + task6Max(array6));

        //п.7
        int[] array7 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("В массиве array7 есть место, где сумма значений справа равна сумме слева? -" + task7(array7));

        //п.8
        int[] array8 = {1, 2, 3, 4, 5, 6, 7, 8};
        printArray1(task8(array8, -3));
    }

    public static int[] task1 (int array[]){
        for (int i = 0; i < array.length; i++){
            if (array[i] == 1){
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        return array;
    }

    public static int[] task2 (int array[]){
        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] task3 (int array[]){
        for (int i = 0; i < array.length; i++){
            if (array[i] < 6){
                array[i] = array[i] * 2;
            }
        }
        return array;
    }

    public static int[][] task4(int array[][]){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                if ((i == j) || (i + j == array.length - 1)){
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

    public static int[] task5(int len, int initialValue){
        int[] array5 = new int[len];
        Arrays.fill(array5, initialValue);
        return array5;
    }

    public static int task6Min(int array[]){
        int min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static int task6Max(int array[]){
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static boolean task7(int array[]){
        boolean result = false;
        for (int i = 0; i < array.length - 1; i++){
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i + 1; j++){
                sumLeft+= array[j];
            }
            for (int k = i + 1; k < array.length; k++){
                sumRight+= array[k];
            }
            if (sumLeft == sumRight) {
                result = true;
            }
        }
        return result;
    }

    public static int[] task8 (int array[], int n){
        boolean direction;
        if (n < 0){
            direction = false;
            n = -n;
        } else {
            direction = true;
        }
        int lastIndex = array.length - 1;
        for (int i = 0; i < n; i++){
            int temp = (direction ? array[lastIndex] : array[0]);
            for (int j = 0; j < lastIndex; j++){
                if (direction){
                    array[lastIndex - j] = array[lastIndex - j - 1];
                } else {
                    array[j] = array[j + 1];
                }
            }
            if (direction){
                array[0] = temp;
            } else {
                array[lastIndex] = temp;
            }
        }
        return array;
    }

    public static void printArray1 (int array[]){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArray2 (int array[][]){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] initialArrayRandom (){
        Random random = new Random();
        int[] array = new int[random.nextInt(15)];
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
        }
        printArray1(array);
        return array;
    }

}
