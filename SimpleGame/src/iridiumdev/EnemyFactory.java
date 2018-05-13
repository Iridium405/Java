package iridiumdev;

public class EnemyFactory {

    private Enemy enemyLv_01_1 = new Enemy("Goblin Marauder", 60, 0, 60, 40,
            3, 2, 4, 1, 2, 1);
    private Enemy enemyLv_01_2 = new Enemy("Goblin Shaman", 50, 70, 20, 60,
            1, 2, 1, 3, 2, 4);
    private Enemy enemyLv_01_3 = new Enemy("Goblin Assassin", 20, 50, 50, 80,
            5, 2, 5, 5, 2, 5);

    private Enemy enemyLv_02_1 = new Enemy("Orc Impaler", 100, 20, 80, 80,
            5, 5, 3, 2, 3, 2);
    private Enemy enemyLv_02_2 = new Enemy("Orc Enchanter", 70, 120, 40, 120,
            4, 4, 2, 6, 4, 5);
    private Enemy enemyLv_02_3 = new Enemy("Orc Berserker", 120, 100, 150, 200,
            7, 1, 4, 3, 1, 1);

    private Enemy enemyLv_03_1 = new Enemy("Vampire Bloodsucker", 100, 40, 100, 120,
            7, 4, 5, 3, 3, 2);
    private Enemy enemyLv_03_2 = new Enemy("Vampire Cultist", 80, 120, 40, 150,
            3, 3, 2, 7, 5, 5);
    private Enemy enemyLv_03_3 = new Enemy("Vampire Count", 150, 150, 150, 400,
            7, 5, 6, 7, 5, 6);


    public Enemy randomEnemy(int playerLevel, int random) {
        switch(playerLevel) {
            case 1:
                switch (random) {
                    case 1:
                        return enemyLv_01_1;
                    case 2:
                        return enemyLv_01_2;
                    case 3:
                        return enemyLv_01_3;
                    default:
                        System.out.println("Null");
                        return null;
                }
            case 2:
                switch (random) {
                    case 1:
                        return enemyLv_02_1;
                    case 2:
                        return enemyLv_02_2;
                    case 3:
                        return enemyLv_02_3;
                    default:
                        System.out.println("Null");
                        return null;
                }
            case 3:
                switch (random) {
                    case 1:
                        return enemyLv_03_1;
                    case 2:
                        return enemyLv_03_2;
                    case 3:
                        return enemyLv_03_3;
                    default:
                        return null;
                }
            default: return null;
        }
    }

}
