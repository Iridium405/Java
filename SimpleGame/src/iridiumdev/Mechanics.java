package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Mechanics {

    ArrayList<Integer> initRolls = new ArrayList<>();

    public void combat(Character highInit, Character lowInit) {         // highInit - player with higher initiative; lowInit - the opposite;
        int turnCount = 1;

        while (highInit.isAlive() || lowInit.isAlive()) {               // checking if both sides (player and enemy) are still alive

            System.out.println("   Turn " + turnCount);

            int weaponDamage = highInit.equipment.getWeapon(0).makeDamage();
            int physicalDamage = highInit.getStrength() + weaponDamage;                                            // Physical Damage = natural "Strength" + random damage made by weapon
            int physicalDefence = lowInit.getDefence() + lowInit.equipment.getArmour(0).getDefence();        // Defence from physical damage = natural "Defence" + cumulative Armour from equipment
            double damageModificator;

            if(isStatHigher(physicalDamage,physicalDefence) && isStatDoubled(initRolls.get(0), initRolls.get(1))){
                    damageModificator = 1.5;
                } else if(isStatHigher(physicalDamage,physicalDefence)) {
                    damageModificator = 1;
                } else if(!isStatHigher(physicalDamage,physicalDefence) && isStatDoubled(initRolls.get(0), initRolls.get(1))) {
                    damageModificator = 1;
                } else {
                    damageModificator = 0.5;
            }

            double highInitDamage = physicalDamage * damageModificator;

            lowInit.setHitPoints(lowInit.getHitPoints() - highInitDamage);

            System.out.println(highInit.getName() + " made " + highInitDamage + " damage [" + weaponDamage
                    + " using " + highInit.equipment.getWeapon(0).getName() + "]" +
                    "\nDamage modificator: " + damageModificator +
                    " (Physical Damage: " + physicalDamage + "; Physical Defence: " + physicalDefence + ")");
            System.out.println(lowInit.getName() + " has " + lowInit.getHitPoints() +
                    " HP remaining.\n");

            if (lowInit.equipment.sizeOfPotionEquipment() > 0 && !lowInit.isEnemy()) {
                usePotion(lowInit, "HitPoints", lowInit.equipment.getPotion(0));
                checkingPotionEquipment(lowInit, lowInit.equipment.getPotion(0));
            }


            if (!lowInit.isAlive()) {
                System.out.println(highInit.getName() + " won with " + highInit.getHitPoints() +
                        " HP remaining.");
                break;
            }

            weaponDamage = lowInit.equipment.getWeapon(0).makeDamage();
            physicalDamage = lowInit.getStrength() + weaponDamage;
            physicalDefence = highInit.getDefence() + highInit.equipment.getArmour(0).getDefence();

            if(isStatHigher(physicalDamage,physicalDefence)){
                damageModificator = 1;
            } else {
                damageModificator = 0.5;
            }

            double lowInitDamage = physicalDamage * damageModificator;

            highInit.setHitPoints(highInit.getHitPoints() - lowInitDamage);

            System.out.println(lowInit.getName() + " made " + lowInitDamage + " damage [" + weaponDamage
                    + " using " + lowInit.equipment.getWeapon(0).getName() + "]" +
                    "\nDamage modificator: " + damageModificator +
                    " (Physical Damage: " + physicalDamage + "; Physical Defence: " + physicalDefence + ")");
            System.out.println(highInit.getName() + " has " + highInit.getHitPoints() +
                    " HP remaining.\n");


            if (highInit.equipment.sizeOfPotionEquipment() > 0 && !highInit.isEnemy()) {
                usePotion(highInit, "HitPoints", highInit.equipment.getPotion(0));
                checkingPotionEquipment(highInit, highInit.equipment.getPotion(0));
            }

            turnCount++;

            if (!highInit.isAlive()) {
                System.out.println(lowInit.getName() + " won with " + lowInit.getHitPoints() +
                        " HP remaining.");
                break;
            }
        }
    }

    public void actionOrder(Character char_1, Character char_2, ArrayList<Character> arrayList){
        int char_1_BaseStat = higherStat(char_1.getQuickness(), char_1.getFocus());
        int char_2_BaseStat = higherStat(char_2.getQuickness(), char_2.getFocus());

        int char_1_Initiative = char_1_BaseStat + dice(6);
        int char_2_Initiative = char_2_BaseStat + dice(6);

        if(char_1_Initiative >= char_2_Initiative){
            arrayList.add(0,char_1);
            arrayList.add(1,char_2);
            initRolls.add(char_1_Initiative);
            initRolls.add(char_2_Initiative);

            System.out.println(char_1.getName() + " rolls " + char_1_Initiative + " [" + char_1_BaseStat + " base]");
            System.out.println(char_2.getName() + " rolls " + char_2_Initiative + " [" + char_2_BaseStat + " base]");
        } else if(char_1_Initiative < char_2_Initiative){
            arrayList.add(0, char_2);
            arrayList.add(1, char_1);
            initRolls.add(char_2_Initiative);
            initRolls.add(char_1_Initiative);

            System.out.println(char_2.getName() + " rolls " + char_2_Initiative + " [" + char_2_BaseStat + " base]");
            System.out.println(char_1.getName() + " rolls " + char_1_Initiative + " [" + char_1_BaseStat + " base]");
        }
    }

    public int dice(int numberOfSides){
        Random dice = new Random();
        return dice.nextInt(numberOfSides) +1;
    }

    public void addExperience(Player player, int amount){
        if(player.isAlive()){
            player.setExperience(player.getExperience() + amount);
            System.out.println(player.getName() + " received " + amount + " exp.");
        } else if(!player.isAlive()){
            System.out.println(player.getName() + " lost.");
        }
    }

    public void usePotion(Character player, String attributeAffected, Potion potion) {
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

    public void checkingPotionEquipment(Character player, Potion potion ){
        if(potion.getQuantity() == 0){
            player.equipment.removePotion(0);
        }
    }

    public int higherStat(int characterStat_1, int characterStat_2){
        if(characterStat_1 >= characterStat_2){
            return characterStat_1;
        } else {
            return characterStat_2;
        }
    }

    public boolean isStatHigher(int characterStat_1, int characterStat_2){
        if(characterStat_1 >= characterStat_2){
            return true;
        } else {
            return false;
        }
    }

    public boolean isStatDoubled(int characterStat_1, int characterStat_2){
        if (characterStat_1 - characterStat_2 >= characterStat_2){
            return true;
        } else {
            return false;
        }
    }

    public void strike(){

    }

}
  /*
  TODO: Przebudować metodę combat() i actionOrder(), tak aby kolejność była sprawdzana po każdej turze ataku
        (pozwoli to wprowadzić eliksiry zwiększające i zmniejszające prędkość i koncentrację)


        Walka:
        1. Atak podstawowy
        2. Atak specjalny (FightingSkills, MagicSkills)
        3. Obrona
        4. Ucieczka (porównanie atrybutu quickness gracza z atrybutami quickness i focus przeciwnika
                        - jeśli to drugie jest wyższe, przeciwnik wykona ostatni atak
                        przed opuszczeniem pola bitwy przez gracza)

        */