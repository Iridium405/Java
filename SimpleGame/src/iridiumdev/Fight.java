package iridiumdev;

import java.util.Scanner;

public class Fight {
    private boolean active = true;
    private int numberOfEnemies;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;

    private EnemyFactory enemies;
    private Dice dice;

    private Scanner scanner = new Scanner(System.in);



    public Fight(Player player, int numberOfEnemies) {
        switch(numberOfEnemies){
            case 1:
                this.enemy1 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                System.out.println("Single enemy appears:\n" + enemy1.getName());
                break;
            case 2:
                this.enemy1 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                this.enemy2 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                System.out.println("Two enemies ahead:\n" + enemy1.getName() + ", " + enemy2.getName());
                break;
            case 3:
                this.enemy1 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                this.enemy2 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                this.enemy3 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                System.out.println("Triple threat stand against you:\n" + enemy1.getName() + ", " +
                        enemy2.getName() + ", " + enemy3.getName());
                break;
//            case 4:
//                this.enemy1 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy2 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy3 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy4 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                break;
//            case 5:
//                this.enemy1 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy2 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy3 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy4 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy5 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                break;
            default:
                System.out.println("Fight error. Somebody should be found. Random number out of range.");

        }

    }

    public Enemy getEnemy1() {
        return enemy1;
    }

    public Enemy getEnemy2() {
        return enemy2;
    }

    public Enemy getEnemy3() {
        return enemy3;
    }

    public Enemy getEnemy4() {
        return enemy4;
    }

    public Enemy getEnemy5() {
        return enemy5;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void menu(){
//        checkInitiative();
        System.out.println("\n1. Attack.\n" +
                "2. Cast Spell.\n" +
                "3. Use inventory.\n" +
                "4. Defend.\n" +
                "5. Run away.");
        int x = scanner.nextInt();

        if (x == 1) {
            System.out.println("You made physical attack.");
        } else if (x == 2) {
            System.out.println("You cast a spell.");
        } else if (x == 3) {
            System.out.println("You used your inventory.");
        } else if (x == 4) {
            System.out.println("You raises all your defenses up.");
        } else if (x == 5) {
            System.out.println("You ran away.");
            setActive(false);
        }

//        enemy.lifeCheckValidation();
    }

}
