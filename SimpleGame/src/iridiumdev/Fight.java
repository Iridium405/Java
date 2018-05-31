package iridiumdev;

import java.util.ArrayList;
import java.util.Scanner;

public class Fight {
    private boolean active = true;
    private boolean physicalAttackMenuActive = true;
    private Player player;
    private int numberOfEnemies;
    private int enemiesEngaged;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;
    private Dice dice = new Dice();

    private Scanner scanner = new Scanner(System.in);
    private EnemyFactory enemies = new EnemyFactory();
    private ArrayList<Enemy> enemyList = new ArrayList<>();



    public Fight(Player player, int numberOfEnemies) {
        switch(numberOfEnemies){
            case 1:
                enemiesEngaged = 1;
                this.enemy1 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                enemyList.add(enemy1);
                System.out.println("Single enemy appears:\n" + enemy1.getName());
                break;
            case 2:
                enemiesEngaged = 2;
                this.enemy1 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                enemyList.add(enemy1);
                this.enemy2 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                enemyList.add(enemy2);
                System.out.println("Two enemies ahead:\n" + enemy1.getName() + ", " + enemy2.getName());
                break;
            case 3:
                enemiesEngaged = 3;
                this.enemy1 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                enemyList.add(enemy1);
                this.enemy2 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                enemyList.add(enemy2);
                this.enemy3 = enemies.randomEnemy(player.getLevel(), dice.throwDice(3));
                enemyList.add(enemy3);
                System.out.println("Triple threat stand against you:\n" + enemy1.getName() + ", " +
                        enemy2.getName() + ", " + enemy3.getName());
                break;
//            case 4:
//                enemiesEngaged = 4;
//                this.enemy1 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy2 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy3 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                this.enemy4 = Enemy.randomEnemy(player.getLevel(),dice.throwDice(3));
//                break;
//            case 5:
//                enemiesEngaged = 5;
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

    public boolean isPhysicalAttackMenuActive() {
        return physicalAttackMenuActive;
    }

    public void setPhysicalAttackMenuActive(boolean physicalAttackMenuActive) {
        this.physicalAttackMenuActive = physicalAttackMenuActive;
    }

    public void menu(){
        System.out.println("Number of enemies: " + enemiesEngaged);
        Enemy enemyTarget;
//        checkInitiative();
        System.out.println("\n1. Attack.\n" +
                "2. Cast Spell.\n" +
                "3. Use inventory.\n" +
                "4. Defend.\n" +
                "5. Run away.");
        int x = scanner.nextInt();

        if (x == 1) {
            while (physicalAttackMenuActive){
                physicalAttackMenu();
            }
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

//        enemy.lifeCheck();
    }

    private void physicalAttack(Player player, Enemy enemy){
        int actualDamage = player.makePhysicalDamage() - enemy.getDefence();
        enemy.setHitPoints(enemy.getHitPoints() - actualDamage);
        System.out.println(enemy.getName() + " - " + enemy.getHitPoints() + " HP remains.");
    }

    private void physicalAttackMenu() {
        String y = scanner.nextLine();
        if (enemiesEngaged == 1){
            System.out.println("1. Confirm attack.\n" +
                    "2. Go back.");
            switch (y){
                case "1":
                    physicalAttack(player, enemy1);
                    break;
                case "2":
                    setPhysicalAttackMenuActive(false);
                    break;
                default:
                    System.out.println("Option unavailable.");
            }
        } else if (enemiesEngaged == 2) {
            System.out.println("Choose enemy:");
            for (Enemy enemy : enemyList) {
                System.out.println(enemyList.indexOf(enemy) + 1 + ". " + enemy.getName());
            }
            System.out.println("3. Go back");
            switch (y) {
                case "1":
                    physicalAttack(player, enemy1);
                    break;
                case "2":
                    physicalAttack(player, enemy2);
                    break;
                case "3":
                    setPhysicalAttackMenuActive(false);
                    break;
                default:
                    System.out.println("Option unavailable.");
            }
        } else if (enemiesEngaged == 3) {
            System.out.println("Choose enemy: ");
            for (Enemy enemy : enemyList) {
                System.out.println(enemyList.indexOf(enemy) + 1 + ". " + enemy.getName());
            }
            System.out.println("4. Go back.");
            switch (y){
                case "1":
                    physicalAttack(player, enemy1);
                    break;
                case "2":
                    physicalAttack(player, enemy2);
                    break;
                case "3":
                    physicalAttack(player, enemy3);
                    break;
                case "4":
                    setPhysicalAttackMenuActive(false);
                    break;
                default:
                    System.out.println("Option unavailable.");
            }
        }
    }
}
