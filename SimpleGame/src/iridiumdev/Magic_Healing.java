package iridiumdev;

public class Magic_Healing extends Spell implements IHealing {

    public Magic_Healing(String name, String type) {
        super(name, type, 0);
    }

    @Override
    public void minorHealing(Player player) {
        if (getAbilityPointsInvested() >= 1 && getAbilityPointsInvested() < 3) {
            player.setEnergy(player.getEnergy() - 20);
            player.setHitPoints(player.getHitPoints() + 20);
        } else {
            System.out.println("You don't know that skill.");
        }
    }

    @Override
    public void regularHealing(Player player) {
        if (getAbilityPointsInvested() >= 3 && getAbilityPointsInvested() < 7) {
            player.setEnergy(player.getEnergy() - 60);
            player.setHitPoints(player.getHitPoints() + 50);
        } else {
            System.out.println("You don't know that skill.");
        }
    }

    @Override
    public void majorHealing(Player player) {
        if (getAbilityPointsInvested() >= 8 && getAbilityPointsInvested() < 14) {
            player.setEnergy(player.getEnergy() - 140);
            player.setHitPoints(player.getHitPoints() + 100);
        } else {
            System.out.println("You don't know that skill.");
        }
    }

    @Override
    public void extremeHealing(Player player) {
        if (getAbilityPointsInvested() >= 15) {
            player.setEnergy(player.getEnergy() - 300);
            player.setHitPoints(player.getHitPoints() + 250);
        } else {
            System.out.println("You don't know that skill.");
        }
    }

    /*@Override
    public void lifeDrain(Player player, Enemy enemy) {
        player.setEnergy(player.getEnergy() - 80);
        enemy.setHitPoints(enemy.getHitPoints() - 20);
        player.setHitPoints(player.getHitPoints() + 40);
    }

    @Override
    public void lifeDevour(Player player, Enemy enemy) {
        player.setEnergy(0);
        player.setHitPoints(enemy.getHitPoints());
        player.setExperience(player.getExperience() - player.getLevel()*300);
        enemy.setHitPoints(0);
    }

    @Override
    public void smallFireball(Player player, Enemy enemy) {
        int minDamage = 5;
        int maxDamage = 10;
        player.setEnergy(player.getEnergy() - 20);
        enemy.setHitPoints(enemy.getHitPoints() - ThreadLocalRandom.current().nextInt(minDamage,maxDamage +1));
    }

     smallFireball / mediumFireball / largeFireball     / hugeFireball     / enormousFireball
    doubleFireball(2) / tripleFireball(3) / quintupleFireball(5) / septupleFireball(7) / undecupleFireball(11)

    *Przesunąć do Magic_Draining lub Magic_Fireball*/
}
