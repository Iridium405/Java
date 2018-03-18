package iridiumdev;

public class Enemy extends Character {

    public Enemy(String name, double hitPoints, double energy, double stamina, int expGivenWhenDead, int strength, int defence, int quickness, int power, int protection, int focus) {
        super(true, name, hitPoints, energy, stamina, expGivenWhenDead, strength, defence, quickness, power, protection, focus, true);
    }

    public static Enemy randomEnemy(int playerLevel, int random) {
        switch(playerLevel) {
            case 1:
                switch (random) {
                    case 1:
                        Enemy enemyLv_01_1 = new Enemy("Goblin Marauder", 60, 0, 60, 40, 3, 2, 4, 1, 2, 1);
                        return enemyLv_01_1;
                    case 2:
                        Enemy enemyLv_01_2 = new Enemy("Goblin Shaman", 50, 70, 20, 60, 1, 2, 1, 3, 2, 4);
                        return enemyLv_01_2;
                    case 3:
                        Enemy enemyLv_01_3 = new Enemy("Goblin Assassin", 20, 50, 50, 80, 5, 2, 5, 5, 2, 5);
                        return enemyLv_01_3;
                    default:
                        return null;
                }
            case 2:
                switch (random) {
                    case 1:
                        Enemy enemyLv_02_1 = new Enemy("Orc Impaler", 100, 20, 80, 80, 5, 5, 3, 2, 3, 2);
                        return enemyLv_02_1;
                    case 2:
                        Enemy enemyLv_02_2 = new Enemy("Orc Enchanter", 70, 120, 40, 120, 4, 4, 2, 6, 4, 5);
                        return enemyLv_02_2;
                    case 3:
                        Enemy enemyLv_03_3 = new Enemy("Orc Berserker", 120, 100, 150, 200, 7, 1, 4, 3, 1, 1);
                        return enemyLv_03_3;
                    default:
                        return null;
                }

            default: return null;
        }
    } // method tested.
}
