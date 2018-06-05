package iridiumdev;

public abstract class Spell {
    private String name;
    private String type;
    private int abilityPointsInvested;

    public Spell(String name, String type, int abilityPointsInvested) {
        this.name = name;
        this.type = type;
        this.abilityPointsInvested = abilityPointsInvested;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAbilityPointsInvested() {
        return abilityPointsInvested;
    }

    public void setAbilityPointsInvested(int abilityPointsInvested) {
        this.abilityPointsInvested = abilityPointsInvested;
    }

    public void investAbilityPoint(int amount){
        this.abilityPointsInvested += amount;
    }
}
