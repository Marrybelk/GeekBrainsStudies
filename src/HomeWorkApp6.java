public class HomeWorkApp6 {

    public static void main(String[] args){
        Dog dog1 = new Dog("Шарик");
        Cat cat1 = new Cat("Мурзик");

        dog1.run(15);
        dog1.run(600);

        dog1.swim(8);
        dog1.swim(11);

        cat1.run(5);
        cat1.run(300);
        cat1.swim(9);

        Cat cat2 = new Cat("Василий");
        Cat cat3 = new Cat("Матроскин");

        Dog dog2 = new Dog("Бобик");
        Dog dog3 = new Dog("Джек");
        Dog dog4 = new Dog("Харлей");

        System.out.println("Всего животных " + Animal.countAnimal);
        System.out.println("Всего собак " + Dog.countDog);
        System.out.println("Всего котов " + Cat.countCat);
    }
}
