package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Dust",100,100,100,1,0,
                5,5,5,5,5,5);

        ArrayList<Character> actionQueue = new ArrayList<>();
        Potion minorHealingPotion = new Potion("Minor Healing Potion",3,50,0);


        while(player.getLevel() <= 2 && player.isAlive()){
            player.levelChecking();
            Enemy enemy = Enemy.randomEnemy(player.getLevel(), dice(3));
            System.out.println("                         Enemy: " + enemy.getName() + "\n");
            System.out.println("  Initiative:");
            actionOrder(player,enemy,actionQueue);
            System.out.println("\n  Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1) + "\n");

            combat(actionQueue.get(0), actionQueue.get(1));

            addExperience(player,enemy.getExpGivenWhenDead());
            actionQueue.clear();
            player.levelChecking();
            System.out.println("Dust has " + player.getExperience() + "exp. and level " + player.getLevel() + "\n");
            useHealingPotion(player,minorHealingPotion);
        }




    }

    public static void combat(Character firstIn_ActionOrder, Character secondIn_ActionOrder){

        while(firstIn_ActionOrder.isAlive() || secondIn_ActionOrder.isAlive()) {

            double firstInAO_Damage = firstIn_ActionOrder.getStrength() + dice(6);
            secondIn_ActionOrder.setHitPoints(secondIn_ActionOrder.getHitPoints() - firstInAO_Damage);

            System.out.println(firstIn_ActionOrder.getName() + " made " + firstInAO_Damage + " damage.");
            System.out.println(secondIn_ActionOrder.getName() + " has " + secondIn_ActionOrder.getHitPoints() + " health remained.\n");

            if(!secondIn_ActionOrder.isAlive()){
                System.out.println(firstIn_ActionOrder.getName() + " won with " + firstIn_ActionOrder.getHitPoints() + " health remaining.");

                break;
            }

            double secondInAO_Damage = secondIn_ActionOrder.getStrength() + dice(6);
            firstIn_ActionOrder.setHitPoints(firstIn_ActionOrder.getHitPoints() - secondInAO_Damage);

            System.out.println(secondIn_ActionOrder.getName() + " made " + secondInAO_Damage + " damage.");
            System.out.println(firstIn_ActionOrder.getName() + " has " + firstIn_ActionOrder.getHitPoints() + " health remained.\n");

            if(!firstIn_ActionOrder.isAlive()){
                System.out.println(secondIn_ActionOrder.getName() +" won with " + secondIn_ActionOrder.getHitPoints() + " health remaining.");
                break;
            }
        }

        /*
        FiAO <strength lub power> dodane do <podstawowych obrażeń broni lub umiejętności> i <rzutu kostką>
        SiAO <defence lub protection>
         */
    }

    public static void actionOrder(Character char_1, Character char_2, ArrayList<Character> arrayList){
        int char_1_BaseStat = char_1.higherStat(char_1.getQuickness(), char_1.getFocus());
        int char_2_BaseStat = char_2.higherStat(char_2.getQuickness(), char_2.getFocus());

        int char_1_Initiative = char_1_BaseStat + dice(6);
        int char_2_Initiative = char_2_BaseStat + dice(6);

        if(char_1_Initiative >= char_2_Initiative){
            arrayList.add(0,char_1);
            arrayList.add(1,char_2);
            System.out.println(char_1.getName() + " rolls " + char_1_Initiative + " [" + char_1_BaseStat + " base]");
            System.out.println(char_2.getName() + " rolls " + char_2_Initiative + " [" + char_2_BaseStat + " base]");
        } else if(char_1_Initiative < char_2_Initiative){
            arrayList.add(0, char_2);
            arrayList.add(1, char_1);
            System.out.println(char_2.getName() + " rolls " + char_2_Initiative + " [" + char_2_BaseStat + " base]");
            System.out.println(char_1.getName() + " rolls " + char_1_Initiative + " [" + char_1_BaseStat + " base]");
        }
    }

        /*
        - Zmienić actionOrder() -> po pierwszym rzucie kością każdej ze stron, ta która rzuciła więcej wybiera swój lepszy
            atrybut (Quickness vs Focus), który użyją obie strony przy drugim rzucie, który to dopiero rzut ostatecznie ustali kolejność!

        - Dwukrotna przewaga inicjatywy będzie skutkować dodatkowym atakiem w turze (lub dodatkowymi obrażeniami, np. +50%).

        - Dodać metodę sprawdzającą, czy char_1 jest pierwszy na liście.
            Jeśli nie jest, wtedy char_2 używa combat() jako pierwszy.
        */


    public static int dice(int numberOfSides){
        Random dice = new Random();
        return dice.nextInt(numberOfSides) +1;
    } // method tested.

    public static void addExperience(Player player, int amount){
        if(player.isAlive()){
            player.setExperience(player.getExperience() + amount);
            System.out.println(player.getName() + " received " + amount + "exp.");
        } else if(!player.isAlive()){
            System.out.println(player.getName() + " lost.");
        }
    }

    public static void useHealingPotion(Player player, Potion potion) {
        if(player.isAlive() && player.getHitPoints() < 50){
            player.setHitPoints(player.getHitPoints() + potion.usePotion(potion));
            System.out.println(potion.getName() + " used. "  + "Potions remained: " + potion.getQuantity() + "\n");
        }
    }




}


/*
        Walka:
        1. Atak podstawowy
        2. Atak specjalny (FightingSkills, MagicSkills)
        3. Obrona
        4. Ucieczka (porównanie atrybutu quickness gracza z atrybutami quickness i focus przeciwnika
                        - jeśli to drugie jest wyższe, przeciwnik wykona ostatni atak przed opuszczeniem pola bitwy przez gracza)


        */