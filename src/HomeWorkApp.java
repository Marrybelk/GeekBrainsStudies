public class HomeWorkApp {

    public static void main (String[] args){

        printThreeWords();

        if (checkSumSign()){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

        System.out.println(printColor(0));

        compareNumbers(168, 89);

    }

    public static void printThreeWords(){
        System.out.println("_Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }

    public static boolean checkSumSign(){
        int a = 1;
        int b = -5;
        return (a + b >= 0);
    }

    public static String printColor(int value){
        if (value <= 0){
            return "Красный";
        } else if (0 < value && value <= 100){
            return "Жёлтый";
        } else {
            return "Зеленый";
        }
    }

    public static void compareNumbers(int a, int b){
        if (a >= b) {
            System.out.print("a >= b");
        } else {
            System.out.print("a < b");
        }
    }

}
