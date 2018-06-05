package iridiumdev;

import java.util.ArrayList;
import java.util.Scanner;

public class Fight {
    private boolean active = true;
    private boolean physicalAttackMenuActive = true;
    private boolean energyAttackMenuActive = true;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;
    private Dice dice = new Dice();

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private int enemiesEngaged = enemyList.size();


    public Fight(Player player, int numberOfEnemies) {
        EnemyFactory enemies = new EnemyFactory();
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

    public int getEnemiesEngaged() {
        return enemiesEngaged;
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

    private void setPhysicalAttackMenuActive(boolean physicalAttackMenuActive) {
            this.physicalAttackMenuActive = physicalAttackMenuActive;
    }

    public boolean isEnergyAttackMenuActive() {
        return energyAttackMenuActive;
    }

    public void setEnergyAttackMenuActive(boolean energyAttackMenuActive) {
        this.energyAttackMenuActive = energyAttackMenuActive;
    }

    public void menu(Player player) {
        if (enemiesEngaged == 0){
            setActive(false);
        } else {
            System.out.println("Number of enemies: " + enemiesEngaged);
//            checkInitiative();
            System.out.println("\n1. Attack. - done.\n" +
                    "2. Cast Spell. - in progress.\n" +
                    "3. Use inventory. - undone.\n" +
                    "4. Defend. - undone.\n" +
                    "5. Run away.");
            setPhysicalAttackMenuActive(true);
            int x = scanner.nextInt();
            if (x == 1) {
                while (physicalAttackMenuActive && enemiesEngaged > 0) {
                    physicalAttackMenu(player);
                }
            } else if (x == 2) {
                while (energyAttackMenuActive && enemiesEngaged > 0) {
                    energyAttackMenu(player);
                }
            } else if (x == 3) {
                System.out.println("You used your inventory.");
            } else if (x == 4) {
                System.out.println("You raises all your defenses up.");
            } else if (x == 5) {
                System.out.println("You ran away.");
                setActive(false);
            }
        }
    }

    private void physicalAttack(Player player, Enemy enemy){
        if (enemiesEngaged < 1) {
            setPhysicalAttackMenuActive(false);
        }
        int damage = player.makePhysicalDamage() + player.getWeapon().getPhysicalQuality();
        enemy.setHitPoints(enemy.getHitPoints() - damage);
        System.out.println(damage + " damage made.");
        System.out.println(enemy.getName() + " - " + enemy.getHitPoints() + " HP remains.");
        player.lifeCheck();
        enemy.lifeCheck();
        if(!enemy.isAlive()) {
            System.out.println(enemy.getName() + " has been killed." +
                    "\nYou gained " + enemy.getExpGivenWhenDead() + " exp.");
            player.setExperience(player.getExperience() + enemy.getExpGivenWhenDead());
            player.levelChecking();
            System.out.println("Total exp: " + player.getExperience() + ". Your current level: " + player.getLevel());
            System.out.println("Total skill points unspent: " + player.getAbilityPoints());
            enemyList.remove(enemy);
            enemyList.trimToSize();
            enemiesEngaged -= 1;
        }
    }

    private void energyAttack(Player player, Enemy enemy){

    }

    private void physicalAttackMenu(Player player) {
        if (enemiesEngaged == 1){
            System.out.println("1. Confirm attack (" + enemyList.get(0).getName() + ")\n" +
                    "2. Go back");
            int y = scanner.nextInt();
            switch (y){
                case 1:
                    physicalAttack(player, enemyList.get(0));
                    break;
                case 2:
                    setPhysicalAttackMenuActive(false);
                    break;
            }
        } else if (enemiesEngaged == 2) {
            System.out.println("Choose enemy:");
            for (Enemy enemy : enemyList) {
                System.out.println(enemyList.indexOf(enemy) + 1 + ". " + enemy.getName());
            }
            System.out.println("3. Go back");
            int y = scanner.nextInt();
            switch (y) {
                case 1:
                    physicalAttack(player, enemyList.get(0));
                    break;
                case 2:
                    physicalAttack(player, enemyList.get(1));
                    break;
                case 3:
                    setPhysicalAttackMenuActive(false);
                    break;
            }
        } else if (enemiesEngaged == 3) {
            System.out.println("Choose enemy: ");
            for (Enemy enemy : enemyList) {
                System.out.println(enemyList.indexOf(enemy) + 1 + ". " + enemy.getName());
            }
            System.out.println("4. Go back.");
            int y = scanner.nextInt();
            switch (y){
                case 1:
                    physicalAttack(player, enemyList.get(0));
                    break;
                case 2:
                    physicalAttack(player, enemyList.get(1));
                    break;
                case 3:
                    physicalAttack(player, enemyList.get(2));
                    break;
                case 4:
                    setPhysicalAttackMenuActive(false);
                    break;
            }
        }
    }

    private void energyAttackMenu(Player player) {
        if (enemiesEngaged == 1){
            System.out.println("1. Confirm spell casting (" + enemyList.get(0).getName() + ")\n" +
                    "2. Go back");
            int y = scanner.nextInt();
            switch (y){
                case 1:
                    energyAttack(player, enemyList.get(0));
                    break;
                case 2:
                    setPhysicalAttackMenuActive(false);
                    break;
            }
        } else if (enemiesEngaged == 2) {
            System.out.println("Choose enemy:");
            for (Enemy enemy : enemyList) {
                System.out.println(enemyList.indexOf(enemy) + 1 + ". " + enemy.getName());
            }
            System.out.println("3. Go back");
            int y = scanner.nextInt();
            switch (y) {
                case 1:
                    energyAttack(player, enemy1);
                    break;
                case 2:
                    energyAttack(player, enemy2);
                    break;
                case 3:
                    setPhysicalAttackMenuActive(false);
                    break;
            }
        } else if (enemiesEngaged == 3) {
            System.out.println("Choose enemy: ");
            for (Enemy enemy : enemyList) {
                System.out.println(enemyList.indexOf(enemy) + 1 + ". " + enemy.getName());
            }
            System.out.println("4. Go back.");
            int y = scanner.nextInt();
            switch (y){
                case 1:
                    energyAttack(player, enemy1);
                    break;
                case 2:
                    energyAttack(player, enemy2);
                    break;
                case 3:
                    energyAttack(player, enemy3);
                    break;
                case 4:
                    setPhysicalAttackMenuActive(false);
                    break;
            }
        }
    }
}
