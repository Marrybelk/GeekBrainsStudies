public class Animal {
    String name;
    static int countAnimal;

    Animal(String name){
        this.name = name;
        countAnimal++;
    }

    void run(int lenght){
        System.out.println(name + " пробежал " + lenght + "м");
    }

    void swim(int lenght){
        System.out.println(name + " проплыл " + lenght + "м");
    }
}
