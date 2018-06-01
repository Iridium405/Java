package iridiumdev;

import java.util.Scanner;

public class Main {
    private static int mainTurnCount = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static Dice mainDice = new Dice();
    private static Player player;

    private static void characterSelect(){
        boolean choiceMade = false;
        int wiseOldManPatience = 11;
        System.out.println(" 'But first... Tell me, who you are.'");
        while(!choiceMade) {

            System.out.println("\n1. A warrior named Dust." +
                    "\n2. An enchantress named Monyope." +
                    "\n3. An assassin called Nightshade.");

            String x = scanner.nextLine();

            if (x.equals("1")) {
                player = new Player("Dust", 100, 100, 100,
                        5, 5, 1, 5, 5, 1);
                System.out.println("WISE OLD MAN:\n 'Good luck then, Dusty boy. Hope you can achieve great things.'");
                choiceMade = true;
            } else if (x.equals("2")) {
                player = new Player("Monyope", 80, 130, 70,
                        4, 3, 2, 8, 7, 7);
                System.out.println("WISE OLD MAN:\n 'Monyope my sweetest, hope the elements will be on your side.'");
                choiceMade = true;
            } else if (x.equals("3")) {
                player = new Player("Nightshade", 90, 80, 80,
                        9, 5, 10, 8, 4, 10);
                System.out.println("WISE OLD MAN:\n 'Good luck my Nightshade. Hope the shadows never leave you in your need.'");
                choiceMade = true;
            } else {
                wiseOldManPatience -= 1;
                if(wiseOldManPatience == 11) {
                    System.out.println("WISE OLD MAN:\n 'You don't know, who you are...?'");
                } else if (wiseOldManPatience == 10) {
                    System.out.println("WISE OLD MAN:\n 'You REALLY don't know, who you are?");
                } else if (wiseOldManPatience == 9) {
                    System.out.println("WISE OLD MAN:\n 'You kiddin' me, right? Or testing my patience?!");
                } else if (wiseOldManPatience == 8) {
                    System.out.println("WISE OLD MAN:\n 'If you don't remember, hereby I'm giving you a name: RETARD!'");
                } else if (wiseOldManPatience == 7) {
                    System.out.println("WISE OLD MAN:\n 'Go on my brave Retard, I don't have all day!'");
                } else if (wiseOldManPatience == 6) {
                    System.out.println("WISE OLD MAN:\n 'Please, I'm begging you...'");
                } else if (wiseOldManPatience == 5) {
                    System.out.println("WISE OLD MAN:\n 'Ok, tell me - what kind of fuckin' bastard are you?'");
                } else if (wiseOldManPatience == 4) {
                    System.out.println("WISE OLD MAN:\n 'You know I can kill you instantly, if you annoy me enough?'");
                } else if (wiseOldManPatience == 3) {
                    System.out.println("WISE OLD MAN:\n 'Fuck off!'");
                } else if (wiseOldManPatience == 2) {
                    System.out.println("WISE OLD MAN:\n 'FUCK OFF RETARD!'");
                } else if (wiseOldManPatience == 1) {
                    System.out.println("WISE OLD MAN:\n 'Last warning you stupid fuck...'");
                } else if (wiseOldManPatience == 0) {
                    System.out.println("WISE OLD MAN:\n 'Ok, I'm done. Bye.");
                    System.out.println("\n\n\n");
                    System.out.println("Wise Old Man wasn't impressed. Nor am I. He killed you instantly...\n" +
                            "Which is good, otherwise I would do it you annoying fucktard.");
                    System.exit(666);
                }
            }
        }
        System.out.println("\nYour journey is about to begin.\n");
    }

    private static void menu(){
        System.out.println("\n1. Continue your journey." +
                "\n2. Check your inventory." +
                "\n3. Go home.");
        int x = scanner.nextInt();

        if (x == 1) {
            mainTurnCount += 1;
            randomEvent(player, mainDice.throwDice(8));
        } else if (x == 2) {
            player.equipment.inventoryContent();
            player.equipment.setMenuActive(true);
            while(player.equipment.isMenuActive()){
                player.equipment.menu();
            }
        } else if (x == 3) {
            System.out.println("You have safely came back.");
                if(mainTurnCount <= 5) {
                    System.out.println("WISE OLD MAN: 'That doesn't last long. Have you ever left home?'");
//                    System.out.println("Turns: " + mainTurnCount);
                } else if (mainTurnCount >5 && mainTurnCount <= 50) {
                    System.out.println("WISE OLD MAN: 'You were on a small escapade, don't you?'");
                    System.out.println("Turns: " + mainTurnCount);
                } else if (mainTurnCount > 50 && mainTurnCount <= 100) {
                    System.out.println("WISE OLD MAN: 'That's what everybody calls an adventure!'");
                    System.out.println("Turns: " + mainTurnCount);
                } else if (mainTurnCount >100) {
                    System.out.println("'That was hell of a journey!' - says Wise Old Man, as you travelled within 5km from your home.");
                    System.out.println("Unfortunately, you died the next morning because of heart attack. Shame.");
                    System.out.println("Turns: " + mainTurnCount);
                }
            System.exit(0);
        }

    }

    private static void randomEvent(Player player, int random) {
        switch(random){
            case 1:
                System.out.println("You see a caravan of carts heading to you.");
                new NpcMeeting();
                break;
            case 2:
                System.out.println("You found something!");
                Findings findings = new Findings();
                findings.randomWeapon();
                System.out.println("It's " + findings.getWeaponFound().getName() + ", do you want to keep it?");
                System.out.println("1. Yes\n2. No");
                int x = scanner.nextInt();
                if (x == 1) {
                    player.setWeapon(findings.getWeaponFound());
                    System.out.println("Weapon equipped.");
                    //player.equipment.addWeapon(findings.getWeaponFound());
                } else {
                    System.out.println("You left that item behind.");
                }
                break;
            case 3:
                System.out.println("Dangerous situation occurred.");
                new Situation();
                break;
            case 4:
                Fight fight = new Fight(player, mainDice.throwDice(1));
                while(fight.isActive()){
                    fight.menu(player);
                }
                break;
            default:
                System.out.println("This time nothing happened.");
                break;
        }
    }

    public static void main(String[] args) {

        System.out.println("WISE OLD MAN:\n 'Are you REALLY sure you want to start a journey into extremely dangerous lands?'");
        String x = scanner.nextLine();

        if (x.toLowerCase().equals("no") || x.toLowerCase().equals("n")){
            System.out.println("Shame.");
            System.exit(0);
        } else {
            System.out.println("WISE OLD MAN:\n 'Very well!'");
            characterSelect();
        }

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



}

/*
TODO: Generator losowych wydarzeń -> Spotkanie przeciwnika, spotkanie NPC, znalezienie przedmiotu.
TODO: Action Points -> gracz może wykonać określoną ilość czynności w trakcie tury.
 */
