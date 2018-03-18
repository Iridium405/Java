package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Dust",100,100,100,1,0,
                5,5,5,5,5,5);

        ArrayList<Character> actionQueue = new ArrayList<>();

        Potion minorHealingPotion = new Potion("Minor Healing Potion",4,50,0);
        player.equipment.add(minorHealingPotion);

        while(player.getLevel() <= 2 && player.isAlive()){
            player.levelChecking();

            Enemy enemy = Enemy.randomEnemy(player.getLevel(), dice(3));

            System.out.println("\n                         Enemy: " + enemy.getName() + "\n");
            System.out.println("   Initiative:");

            actionOrder(player,enemy,actionQueue);

            System.out.println("\n   Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1) + "\n");
            System.out.println("\n   BATTLE LOG: \n");

            combat(actionQueue.get(0), actionQueue.get(1));

            addExperience(player,enemy.getExpGivenWhenDead());
            actionQueue.clear();
            player.levelChecking();

            System.out.println(player.getName() + " has " + player.getExperience() + "exp. and level " + player.getLevel() + "\n");
        }

    }

    public static void combat(Character higherIniciative, Character lowerIniciative){

        while(higherIniciative.isAlive() || lowerIniciative.isAlive()) {

            double higherIniciativeDamage = higherIniciative.getStrength() + dice(6); // + weapon.getDamage()
            lowerIniciative.setHitPoints(lowerIniciative.getHitPoints() - higherIniciativeDamage);

            System.out.println(higherIniciative.getName() + " made " + higherIniciativeDamage + " damage.");
            System.out.println(lowerIniciative.getName() + " has " + lowerIniciative.getHitPoints() + " HP remained.\n");

            if(lowerIniciative.equipment.size()>0 && !lowerIniciative.isEnemy()){
                useHealingPotion(lowerIniciative, lowerIniciative.equipment.get(0));
                checkingEquipment(lowerIniciative, lowerIniciative.equipment.get(0));
            }

            if(!lowerIniciative.isAlive()){
                System.out.println(higherIniciative.getName() + " won with " + higherIniciative.getHitPoints() + " HP remaining.");
                break;
            }

            double lowerIniciativeDamage = lowerIniciative.getStrength() + dice(6);
            higherIniciative.setHitPoints(higherIniciative.getHitPoints() - lowerIniciativeDamage);

            System.out.println(lowerIniciative.getName() + " made " + lowerIniciativeDamage + " damage.");
            System.out.println(higherIniciative.getName() + " has " + higherIniciative.getHitPoints() + " HP remained.\n");

            if(higherIniciative.equipment.size()>0 && !higherIniciative.isEnemy()) {
                useHealingPotion(higherIniciative, higherIniciative.equipment.get(0));
                checkingEquipment(higherIniciative, higherIniciative.equipment.get(0));
            }

            if(!higherIniciative.isAlive()){
                System.out.println(lowerIniciative.getName() +" won with " + lowerIniciative.getHitPoints() + " HP remaining.");
                break;
            }
        }

        /*
        HigherInit <strength lub power> dodane do <podstawowych obrażeń broni lub umiejętności> i <rzutu kostką>
        LowerInit <defence lub protection> ?
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
        - Zmienić actionOrder() -> każda strona rzuca d6, ta która rzuciła więcej wybiera swój lepszy atrybut
            (Quickness vs Focus). Obie strony użyją wybranego przez zwycięzcę pierwszego rzutu jako modyfikator przy drugim rzucie.
            Drugi rzut + modyfikator decydują o kolejności.

        - Dwukrotna przewaga wartości inicjatywy będzie skutkować dodatkowym atakiem w turze (lub dodatkowymi obrażeniami, np. +50%).
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
    } // method tested.

    public static void useHealingPotion(Character player, Potion potion) {
        if(player.isAlive() && player.getHitPoints() < 50){
            player.setHitPoints(player.getHitPoints() + potion.usePotion(potion));
            System.out.println(potion.getName() + " used. " + player.getName() + " has " + player.getHitPoints() +
                    " HP. Potions remained: " + potion.getQuantity() + "\n");
        }
    }

    public static void checkingEquipment(Character player, Potion potion){
        if(potion.getQuantity() == 0){
            player.equipment.remove(0);
        }
    }                                           //TODO -> wprowadzić >wyszukiwanie< Itemu, którego ilość = 0 i usuwanie go z listy. (Najpierw lista generyczna!)

}


/*
        Walka:
        1. Atak podstawowy
        2. Atak specjalny (FightingSkills, MagicSkills)
        3. Obrona
        4. Ucieczka (porównanie atrybutu quickness gracza z atrybutami quickness i focus przeciwnika
                        - jeśli to drugie jest wyższe, przeciwnik wykona ostatni atak przed opuszczeniem pola bitwy przez gracza)


        */