package HomeWorkApp7;

import java.util.Random;

public class Soldier {
    protected String name;
    protected float attack;
    protected float defense;
    protected float hp;
    Weapon weapon;
    private Random random = new Random();

    public Soldier(String name, float attack, float defense, float hp, int weapon) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        if (hp < 0) {
            this.hp = -hp;
        } else {
            this.hp = hp;
        }
        if (weapon == 1) {
            this.weapon = new Sword();
        } else if (weapon == 2){
            this.weapon = new Stick();
        } else if (weapon == 3){
            this.weapon = new Gun();
        }

        System.out.println("К бою готов - " + this.name +
                " (атака " + this.attack +
                ", защита " + this.defense +
                ", здоровье " + this.hp +
                "), оружие - " + this.weapon.type +
                " (урон " + this.weapon.damage +
                ", состояние " + this.weapon.condition +
                ", коэффициэнт разрушения " + this.weapon.breakingFactor +
                ")");
    }

    public void attack(Soldier enemy){
        float dealDamage;
        if(enemy != this){
            if (this.weapon.getCondition() > 0) {
                dealDamage = this.attack + this.weapon.getDamage() - enemy.defense;
                if (dealDamage < 0)
                    dealDamage = 0;
                enemy.hp -= dealDamage;
                System.out.println(this.name + " нанёс удар > " + enemy.name + " >> " + dealDamage + " dmg.");
                this.weapon.updateCondition(this);
            } else {
                dealDamage = this.attack - enemy.defense;
                if(dealDamage < 0)
                    dealDamage = 0;
                enemy.hp -= dealDamage;
                System.out.println(this.name + " нанёс удар > " + enemy.name + " >> " + dealDamage + " dmg.");
            }
        } else {
            System.out.println("It's me");
        }
    }

    public void healSelf(){
        float summaryHeal = 0.5f * this.defense + 1;
        this.hp += summaryHeal;
        System.out.println(this.name + " восстановился на " + summaryHeal + "hp. Теперь hp " + this.hp + "\n");
    }

    public String getMeInfo() {
        return this.name + ": hp " + this.hp + ", состояние оружия " + this.weapon.getCondition() + "\n";
    }

    public boolean isDeadHero() {
        return this.hp <= 0;
    }

    public String getName() {
        return name;
    }
}
