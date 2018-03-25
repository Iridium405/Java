package iridiumdev;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Mechanics m = new Mechanics();

        Player player = new Player("Dust",100,100,100,
                5,5,1,5,5,1);

        Weapon shortSword = new Weapon("Short Sword",2,4);
        player.equipment.addWeapon(shortSword);

        Armour magicChainmail = new Armour("Magic Chainmail", 5,4);
        player.equipment.addArmour(magicChainmail);

        Potion minorHealingPotion = new Potion("Minor Healing Potion",50,0);
        player.equipment.addPotion(minorHealingPotion,10);

        Weapon woodenClaws = new Weapon("Wooden Claws",1,4);
        Armour leatherArmour = new Armour("Leather Armour", 2,1);

        player.equipment.inventoryContent();

        ArrayList<Character> actionQueue = new ArrayList<>();

        while(player.getLevel() <= 3 && player.isAlive()){
            player.levelChecking();

            Enemy enemy = Enemy.randomEnemy(player.getLevel(), m.dice(3));
            enemy.equipment.addWeapon(woodenClaws);
            enemy.equipment.addArmour(leatherArmour);

            System.out.println("\n                         Enemy: " + enemy.getName() + "\n");
            System.out.println("   Initiative:");

            m.actionOrder(player,enemy,actionQueue);

            System.out.println("\n   Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1) + "\n");
            System.out.println("\n   BATTLE LOG: \n");

            m.combat(actionQueue.get(0),actionQueue.get(1));

            m.addExperience(player,enemy.getExpGivenWhenDead());
            actionQueue.clear();
            player.levelChecking();

            System.out.println(player.getName() + " has " + player.getExperience() + " exp and level "
                    + player.getLevel() + ".\n---------------------------------------------------\n");
        }

    }
}

/*
TODO: Generator losowych wydarzeń -> Spotkanie przeciwnika, spotkanie NPC, znalezienie przedmiotu.
TODO: Action Points -> gracz może wykonać określoną ilość czynności w trakcie tury.
 */
