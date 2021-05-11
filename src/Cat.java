public class Cat extends Animal{
    static int countCat;

    Cat(String name){
        super(name);
        countCat++;
    }

    @Override
    void run(int lenght){
        if (lenght <= 200){
            super.run(lenght);
        } else {
            System.out.println(name + " не может пробежать больше 200 метров");
        }
    }

    @Override
    void swim(int lenght){
        System.out.println(name + " не плавает");
    }
}
