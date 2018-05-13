package iridiumdev;

public class Fight {
    private int numberOfEnemies;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;

    public Dice fightDice = new Dice();

    public Fight(Player player, int numberOfEnemies) {
        switch(numberOfEnemies){
            case 1:
                this.enemy1 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
                break;
            case 2:
                this.enemy1 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
                this.enemy2 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
                break;
            case 3:
                this.enemy1 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
                this.enemy2 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
                this.enemy3 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
                break;
//            case 4:
//                this.enemy1 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy2 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy3 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy4 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                break;
//            case 5:
//                this.enemy1 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy2 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy3 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy4 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
//                this.enemy5 = Enemy.randomEnemy(player.getLevel(),fightDice.throwDice(3));
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
}
