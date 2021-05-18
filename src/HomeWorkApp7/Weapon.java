package HomeWorkApp7;

public class Weapon {
    String type;
    int damage;
    int condition;
    int breakingFactor;

    public Weapon(String type, int damage, int condition, int breakingFactor){
        this.type = type;
        this.damage = damage;
        this.condition = condition;
        this.breakingFactor = breakingFactor;
    }

    public void updateCondition(Soldier soldier){
        this.condition -= breakingFactor;
        if (this.condition <= 0)
            System.out.println(soldier.name + " потерял оружие...");
    }

    public int getCondition() {
        return condition;
    }

    public int getDamage() {
        return damage;
    }
}

