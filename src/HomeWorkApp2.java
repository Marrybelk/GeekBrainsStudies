public class HomeWorkApp2 {

    public static void main (String[] args){

        //п.1
        System.out.println("Сумма чисел находится в пределах от 10 до 20 включительно? -" + numberLimit(1, 19));

        //п.2
        positiveOrNegative(-5);

        //п.3
        if (positiveOrNegative2(8)){
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }

        //п.4
        printLine("Нет фантазии:)", 3);

        //п.5
        int year = 2020;
        System.out.println(year + " год високосный? -" + leapYear(year));


    }

    public static boolean numberLimit (int a, int b){
        return (a + b >= 10) && (a + b <= 20);
    }

    public static void positiveOrNegative(int a){
       System.out.println((a >= 0) ? "Число положительное" : "Число отрицательное");
    }

    public static boolean positiveOrNegative2(int a){
        return (a >= 0);
    }

    public static void printLine(String line, int count){
        for (int i = 0; i < count; i++){
            System.out.println(line);
        }
    }

    public static boolean leapYear(int year){
        return (year % 4 == 0) && (year % 100 !=0) || (year % 400 == 0);
    }
}
