package iridiumdev;

import java.util.ArrayList;

public class Equipment {

    private ArrayList<Potion> potionEquipment = new ArrayList<>();

        public boolean addPotion(Potion potion, int amount){
        if (potionEquipment.contains(potion)) {
            if (potion.getQuantity() + amount >= 10) {
                int fullEquipment = 10 - potion.getQuantity();
                potion.setQuantity(potion.getQuantity() + fullEquipment);
                System.out.println("[" + fullEquipment + "/" + amount + "] " + potion.getName() +
                        " added. Your equipment is full of that stuff.");
                return true;
            } else {
                potion.setQuantity(potion.getQuantity()+ amount);
                System.out.println("\n" + potion.getName() + " [" + amount + "] added to equipment.");
                return true;
            }
        } else {
            potionEquipment.add(potion);
            potion.setQuantity(+ amount);
            System.out.println("\n" + potion.getName() + " [" + amount + "] added to equipment.");
            return true;
        }
    }

        public int sizeOfPotionEquipment(){
            return this.potionEquipment.size();
        }

        private String contentOfPotionEquipment(){
            System.out.println("\nPotions:");
            for (Potion potion : this.potionEquipment) {
                System.out.println(potionEquipment.indexOf(potion)+". " + potion.getName() +
                        " [" + Integer.toString(potion.getQuantity()) + "]");
            }
            return null;
    }

        public Potion getPotion(int index){
        return this.potionEquipment.get(index);
    }

        public Potion removePotion(int index){
        return this.potionEquipment.remove(index);
    }



    private ArrayList<Weapon> weaponEquipment = new ArrayList<>();

        public boolean addWeapon(Weapon weapon) {
        if (weaponEquipment.contains(weapon)) {
            System.out.println("You got that weapon in your inventory.");
            return false;
        } else {
            weaponEquipment.add(weapon);
            System.out.println("\n" + weapon.getName() + " added to equipment.");
            return true;
        }
    }

        private String contentOfWeaponEquipment(){
            System.out.println("\nWeapons:");
            for (Weapon weapon : this.weaponEquipment) {
                System.out.println(weaponEquipment.indexOf(weapon)+". " + weapon.getName() +
                        " [" + Double.toString(weapon.getMinDamage()) +
                        "-" + Double.toString(weapon.getMaxDamage()) + "]");
            }
            return null;
        }

        public Weapon getWeapon(int index){
        return this.weaponEquipment.get(index);
    }

        public Weapon removeWeapon(int index){
        return this.weaponEquipment.remove(index);
    }



    private ArrayList<Armour> armourEquipment = new ArrayList<Armour>();

        public boolean addArmour(Armour armour) {
            if (armourEquipment.contains(armour)) {
                System.out.println("You got that armour in your inventory.");
                return false;
            } else {
                armourEquipment.add(armour);
                System.out.println("\n" + armour.getName() + " added to equipment.");
                return true;
            }
        }

        private String contentOfArmourEquipment() {
            System.out.println("\nArmour:");
            for (Armour armour : this.armourEquipment) {
                System.out.println(armourEquipment.indexOf(armour)+". " + armour.getName() +
                        " [d:" + Double.toString(armour.getDefence()) +
                        "/ p:" + Double.toString(armour.getProtection()) + "]");
            }
            return null;
        }

        public Armour getArmour(int index){
        return this.armourEquipment.get(index);
    }

        public Armour removeArmour(int index){
        return this.armourEquipment.remove(index);
    }


    public void inventoryContent(){
        System.out.println("\n     INVENTORY:");
            contentOfWeaponEquipment();
            contentOfArmourEquipment();
            contentOfPotionEquipment();
    }








}

/*
Zrobić metodę randomowych przedmiotów klasy Weapon, które otrzymywaliby przeciwnicy do walki.
 */
