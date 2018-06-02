package iridiumdev;

public class EnemyFactory {

    public Enemy randomEnemy(int playerLevel, int random) {
        switch(playerLevel) {
            case 1:
                switch (random) {
                    case 1:
                        return new Enemy("Goblin Marauder", 30, 0, 60, 40,
                                3, 2, 4, 1, 2, 1);
                    case 2:
                        return new Enemy("Goblin Shaman", 25, 70, 20, 60,
                                1, 2, 1, 3, 2, 4);
                    case 3:
                        return new Enemy("Goblin Assassin", 10, 50, 50, 80,
                                5, 2, 5, 5, 2, 5);
                    default:
                        System.out.println("Null");
                        return null;
                }
            case 2:
                switch (random) {
                    case 1:
                        return new Enemy("Orc Impaler", 50, 20, 80, 80,
                                5, 5, 3, 2, 3, 2);
                    case 2:
                        return new Enemy("Orc Enchanter", 35, 120, 40, 120,
                                4, 4, 2, 6, 4, 5);
                    case 3:
                        return new Enemy("Orc Berserker", 60, 100, 150, 200,
                                7, 1, 4, 3, 1, 1);
                    default:
                        System.out.println("Null");
                        return null;
                }
            case 3:
                switch (random) {
                    case 1:
                        return new Enemy("Vampire Bloodsucker", 50, 40, 100, 120,
                                7, 4, 5, 3, 3, 2);
                    case 2:
                        return new Enemy("Vampire Cultist", 40, 120, 40, 150,
                                3, 3, 2, 7, 5, 5);
                    case 3:
                        return new Enemy("Vampire Count", 75, 150, 150, 400,
                                7, 5, 6, 7, 5, 6);
                    default:
                        return null;
                }
            default: return null;
        }
    }

}
