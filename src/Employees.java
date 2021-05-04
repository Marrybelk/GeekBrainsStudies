public class Employees {
    private String fio;
    private String position;
    private String phone;
    private int salary;
    private int age;
    private int id;
    static int generateId = 0;

    Employees(String fio, String position, String phone, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        generateId++;
        this.id = generateId;
    }

    void printOldEmployees(){
        if(this.age > 40){
            System.out.println("Сотрудник старше 40 лет:");
            System.out.println("ФИО: " + getFio() + "\nДолжность: " + getPosition() + "\nТелефон: " + getPhone() + "\nЗаработная плата: " + getSalary() + "\nВозраст: " + getAge() + "\nID: " + getId());
        }
    }

    void salaryIncrease(){
        if (age > 35){
            salary += 10000;
            System.out.println("Сотруднику подняли ЗП: " + fio + " " + salary + "р.");
        }
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}
