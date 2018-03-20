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
                System.out.println(potion.getName() + " [" + amount + "] added to equipment.");
                return true;
            }
        } else {
            potionEquipment.add(potion);
            potion.setQuantity(+ amount);
            System.out.println(potion.getName() + " [" + amount + "] added to equipment.");
            return true;
        }
    }

        public int sizeOfPotionEquipment(){
        return this.potionEquipment.size();
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
            System.out.println("Your got that weapon in your inventory.");
            return false;
        } else {
            weaponEquipment.add(weapon);
            System.out.println(weapon.getName() + " added to your equipment.");
            return true;
        }
    }

        public int sizeOfWeaponEquipment(){
        return this.weaponEquipment.size();
    }

        public Weapon getWeapon(int index){
        return this.weaponEquipment.get(index);
    }

        public Weapon removeWeapon(int index){
        return this.weaponEquipment.remove(index);
    }

}

/*
Zrobić metodę randomowych przedmiotów klasy Weapon, które otrzymywaliby przeciwnicy do walki.
 */
