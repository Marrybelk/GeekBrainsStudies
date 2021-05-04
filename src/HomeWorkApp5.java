public class HomeWorkApp5 {
    public static void main(String[] args) {
        Employees employee1 = new Employees("Иванов Иван Иванович", "Аккаунт-менеджер", "79001231212", 55000, 31);
        System.out.println(employee1.getFio());
        System.out.println(employee1.getPosition());

        Employees[] employees = new Employees[5];
        employees[0] = new Employees("Петров Александр Сергеевич", "Аккаунт-менеджер", "79001231212", 55000, 36);
        employees[1] = new Employees("Кулябина Ольга Константиновна", "Тестировщик", "89200001234", 60000, 18);
        employees[2] = new Employees("Першина Лариса Александровна", "Аналитик", "79884562312", 72000, 43);
        employees[3] = new Employees("Лукин Андрей Андреевич", "Front-end разработчик", "79087680909", 84000, 41);
        employees[4] = new Employees("Игнатов Артем Валериевич", "Back-end разработчик", "79139681010", 100000, 40);

        for (int i = 0; i < employees.length; i++){
            employees[i].printOldEmployees();
        }

        for (int i = 0; i < employees.length; i++) {
            employees[i].salaryIncrease();
        }
    }
}
