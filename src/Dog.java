public class Dog extends Animal{
    static int countDog = 0;

    Dog(String name){
        super(name);
        countDog++;
    }

    @Override
    void run(int lenght){
        if (lenght <= 500){
            super.run(lenght);
        } else {
            System.out.println(name + " не может пробежать больше 500 метров");
        }
    }

    @Override
    void swim(int lenght){
        if (lenght <= 10){
            super.swim(lenght);
        } else {
            System.out.println(name + " не может проплыть больше 10 метров");
        }
    }

}
