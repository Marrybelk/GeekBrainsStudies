package HomeWorkApp7;

import java.util.Scanner;

public class Battle {

    public static int round = 1;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int weaponLightSoldier = 0;
        do {
            System.out.println("Выберите оружие для LightSoldier:\n1 - меч\n2 - палка\n3 - пистолет");
            weaponLightSoldier = scanner.nextInt();
        } while (weaponLightSoldier != 1 && weaponLightSoldier != 2 && weaponLightSoldier != 3);

        LightSoldier lightSoldier = new LightSoldier("LightSoldier", 15, 25f, 100f, weaponLightSoldier);

        int weaponDarkSoldier = 0;
        do {
            System.out.println("Выберите оружие для DarkSoldier:\n1 - меч\n2 - палка\n3 - пистолет");
            weaponDarkSoldier = scanner.nextInt();
        } while (weaponDarkSoldier != 1 && weaponDarkSoldier != 2 && weaponDarkSoldier != 3);

        DarkSoldier darkSoldier = new DarkSoldier("DarkSoldier", 30, 5f, 150f, weaponDarkSoldier);

        while (!lightSoldier.isDeadHero() || !darkSoldier.isDeadHero()){
            System.out.println("*** Round " + round + " ***\n");

            lightSoldier.attack(darkSoldier);

            if (darkSoldier.isDeadHero()) {
                 System.out.println(lightSoldier.getName() + " win!");
                 break;
            }
            System.out.println(darkSoldier.getMeInfo());

            darkSoldier.attack(lightSoldier);

            if (lightSoldier.isDeadHero()) {
                System.out.println(darkSoldier.getName() + " win!");
                break;
            }
            System.out.println(lightSoldier.getMeInfo());

            if (round % 2 == 0) {
                lightSoldier.healSelf();
            } else if (round % 3 == 0) {
                darkSoldier.healSelf();
            }
            round++;

        }
    }
}
