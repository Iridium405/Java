package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Dust",100,100,100,1,0,
                5,5,5,5,5,5);

        ArrayList<Character> actionQueue = new ArrayList<>();

        Potion minorHealingPotion = new Potion("Minor Healing Potion",50,0);
        player.equipment.addPotion(minorHealingPotion,5);

        Weapon longSword = new Weapon("Excellent Long Sword",9,12);
        player.equipment.addWeapon(longSword);

        while(player.getLevel() <= 3 && player.isAlive()){
            player.levelChecking();

            Enemy enemy = Enemy.randomEnemy(player.getLevel(), dice(3));

            System.out.println("\n                         Enemy: " + enemy.getName() + "\n");
            System.out.println("   Initiative:");

            actionOrder(player,enemy,actionQueue);

            System.out.println("\n   Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1) + "\n");
            System.out.println("\n   BATTLE LOG: \n");

            combat(actionQueue.get(0),actionQueue.get(1),player.equipment.getWeapon(0));

            addExperience(player,enemy.getExpGivenWhenDead());
            actionQueue.clear();
            player.levelChecking();

            System.out.println(player.getName() + " has " + player.getExperience() + "exp and level "
                    + player.getLevel() + "\n");
        }

    }

    public static void combat(Character higherInitiative, Character lowerInitiative, Weapon playerWeapon){


        while(higherInitiative.isAlive() || lowerInitiative.isAlive()) {

                int weaponDamage = 0;
                if(!higherInitiative.isEnemy()){
                    weaponDamage = playerWeapon.makeDamage();
                }
                int higherInitiativeDamage = higherInitiative.getStrength() + weaponDamage + dice(6);
                lowerInitiative.setHitPoints(lowerInitiative.getHitPoints() - higherInitiativeDamage);

                System.out.println(higherInitiative.getName() + " made " + higherInitiativeDamage + " damage [" + weaponDamage + " using weapon]");
                System.out.println(lowerInitiative.getName() + " has " + lowerInitiative.getHitPoints() +
                        " HP remaining.\n");


            if(lowerInitiative.equipment.sizeOfPotionEquipment() > 0 && !lowerInitiative.isEnemy()){
                usePotion(lowerInitiative,"HitPoints", lowerInitiative.equipment.getPotion(0));
                checkingPotionEquipment(lowerInitiative, lowerInitiative.equipment.getPotion(0));
            }

            if(!lowerInitiative.isAlive()){
                System.out.println(higherInitiative.getName() + " won with " + higherInitiative.getHitPoints() +
                        " HP remaining.");
                break;
            }
                weaponDamage = 0;
                if(!lowerInitiative.isEnemy()){
                    weaponDamage = playerWeapon.makeDamage();
                }
                int lowerInitiativeDamage = lowerInitiative.getStrength() + weaponDamage + dice(6);
                higherInitiative.setHitPoints(higherInitiative.getHitPoints() - lowerInitiativeDamage);

                System.out.println(lowerInitiative.getName() + " made " + lowerInitiativeDamage + " damage [" + weaponDamage + " using weapon]");
                System.out.println(higherInitiative.getName() + " has " + higherInitiative.getHitPoints() +
                        " HP remaining.\n");


            if(higherInitiative.equipment.sizeOfPotionEquipment() > 0 && !higherInitiative.isEnemy()) {
                usePotion(higherInitiative,"HitPoints", higherInitiative.equipment.getPotion(0));
                checkingPotionEquipment(higherInitiative, higherInitiative.equipment.getPotion(0));
            }

            if(!higherInitiative.isAlive()){
                System.out.println(lowerInitiative.getName() +" won with " + lowerInitiative.getHitPoints() +
                        " HP remaining.");
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
        -? Zmienić actionOrder() -> każda strona rzuca d6, ta która rzuciła więcej wybiera swój lepszy atrybut
            (Quickness vs Focus). Obie strony użyją wybranego przez zwycięzcę pierwszego rzutu jako modyfikator
            przy drugim rzucie. Drugi rzut + modyfikator decydują o kolejności.

        - Dwukrotna przewaga wartości inicjatywy będzie skutkować dodatkowym atakiem w turze
            (lub dodatkowymi obrażeniami, np. +50%).
        */


    public static int dice(int numberOfSides){
        Random dice = new Random();
        return dice.nextInt(numberOfSides) +1;
    } // method tested.

    public static void addExperience(Player player, int amount){
        if(player.isAlive()){
            player.setExperience(player.getExperience() + amount);
            System.out.println(player.getName() + " received " + amount + " exp.");
        } else if(!player.isAlive()){
            System.out.println(player.getName() + " lost.");
        }
    } // method tested.

    public static void usePotion(Character player, String attributeAffected, Potion potion) {
        if(player.isAlive() && attributeAffected.equals("HitPoints") && player.getHitPoints() < 50){
            player.setHitPoints(player.getHitPoints() + potion.usePotion(potion));
            System.out.println(potion.getName() + " used. " + player.getName() + " has " + player.getHitPoints() +
                    " HP. Potions remained: " + potion.getQuantity() + "\n");
        } if(player.isAlive() && attributeAffected.equals("Energy") && player.getEnergy() < 20) {
            player.setEnergy(player.getEnergy() + potion.usePotion(potion));
            System.out.println(potion.getName() + " used. " + player.getName() + " has " + player.getEnergy() +
                    " energy. Potions remained: " + potion.getQuantity() + "\n");
        } if(player.isAlive() && attributeAffected.equals("Stamina") && player.getStamina() < 20) {
            player.setStamina(player.getStamina() + potion.usePotion(potion));
            System.out.println(potion.getName() + " used. " + player.getName() + " has " + player.getStamina() +
                    " stamina. Potions remained: " + potion.getQuantity() + "\n");
        }
    }

    public static void checkingPotionEquipment(Character player, Potion potion ){
        if(potion.getQuantity() == 0){
            player.equipment.removePotion(0);
        }
    }

}


/*
        Walka:
        1. Atak podstawowy
        2. Atak specjalny (FightingSkills, MagicSkills)
        3. Obrona
        4. Ucieczka (porównanie atrybutu quickness gracza z atrybutami quickness i focus przeciwnika
                        - jeśli to drugie jest wyższe, przeciwnik wykona ostatni atak
                        przed opuszczeniem pola bitwy przez gracza)


        */