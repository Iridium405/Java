package iridiumdev;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Dice mainDice = new Dice();
    private static Player player = new Player("Dust", 100, 100, 100,
            5, 5, 1, 5, 5, 1);


    public static void menu(){
        System.out.println("\n1. Continue your journey." +
                "\n2. Check your inventory." +
                "\n3. Quit.");
        int x = scanner.nextInt();

        if (x == 1) {
            randomEvent(player, mainDice.throwDice(8));
        } else if (x == 2) {
            player.equipment.inventoryContent();
        } else if (x == 3) {
            System.exit(0);
        }

    }

    public static void main(String[] args) {

        while (true) {
            menu();
        }



        /*Mechanics m = new Mechanics();

        player.equipment.inventoryContent();

        ArrayList<Character> actionQueue = new ArrayList<>();

        while (player.getLevel() <= 3 && player.isAlive()) {
            player.levelChecking();

            Enemy enemy = Enemy.randomEnemy(player.getLevel(), m.dice(3));

            System.out.println("\n                         Enemy: " + enemy.getName() + "\n");
            System.out.println("   Initiative:");

            m.actionOrder(player, enemy, actionQueue);

            System.out.println("\n   Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1) + "\n");
            System.out.println("\n   BATTLE LOG: \n");

            m.combat(actionQueue.get(0), actionQueue.get(1));

            m.addExperience(player, enemy.getExpGivenWhenDead());
            actionQueue.clear();
            player.levelChecking();

            System.out.println(player.getName() + " has " + player.getExperience() + " exp and level "
                    + player.getLevel() + ".\n--------------------------------------------------------------------------\n"+
                                          "--------------------------------------------------------------------------\n");
        }*/



/*      while (player.isAlive()) {                      // [game body]

            TODO: randomEventMenu();                        // podstawowe menu akcji w grze

                TODO: 1. randomEvent();                         // losowe spotkania - NPC, Enemy lub Item
                        TODO: 1.1 randomNpcEncounter();             // później również baza danych NPC (ludzie i istoty)
                                    1.1.1 conversation();
                                    1.1.2 quest();
                                    1.1.3 trade();
                        TODO: 1.2 randomEnemyEncounter();           // później również baza danych Enemy
                                    1.2.1 combat();
                                    1.2.2 flee();
                        TODO: 1.3 randomItemDrop();                 // później również baza danych Item
                                    1.3.1 checkItem();
                                    1.3.2 take();
                                    1.3.3 leave();

                TODO: 2. inventoryContent();
                        TODO: 2.1 equip();          // jedno-elementowe tablice w ekwipunku - do każdej można przypisać jeden przedmiot danego TYPU
                        TODO: 2.2 unequip();        // usunięcie przedmiotu z AKTYWNEGO ekwipunku, pod warunkiem, że jest wolne miejsce
                        TODO: 2.3 remove();         // zniszczenie przedmiotu

                TODO: 3. quitGame();

          }

            while(combatEvent) {

            }
*/


    }

    public static void randomEvent(Player player, int random) {
        switch(random){
            case 1:
                Fight fight = new Fight(player, mainDice.throwDice(3));
                while(fight.isActive()){
                    fight.menu();
                }
                break;
            case 2:
                System.out.println("You see a caravan of carts heading to you.");
                new NpcMeeting();
                break;
            case 3:
                System.out.println("You found something!");
                Findings findings = new Findings();
                findings.randomWeapon();
                System.out.println("It's " + findings.getWeaponFound().getName() + ", and you keep it.");
                player.equipment.addWeapon(findings.getWeaponFound());
                break;
            case 4:
                System.out.println("Dangerous situation occurred.");
                new Situation();
                break;
            default:
                System.out.println("This time nothing happened.");
                break;
        }
    }

}

/*
TODO: Generator losowych wydarzeń -> Spotkanie przeciwnika, spotkanie NPC, znalezienie przedmiotu.
TODO: Action Points -> gracz może wykonać określoną ilość czynności w trakcie tury.
 */
