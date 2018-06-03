package iridiumdev;

public abstract class Spell {
    private String name;
    private String type;
    private int skillPointsInvested;

    public Spell(String name, String type, int skillPointsInvested) {
        this.name = name;
        this.type = type;
        this.skillPointsInvested = skillPointsInvested;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSkillPointsInvested() {
        return skillPointsInvested;
    }

    public void setSkillPointsInvested(int skillPointsInvested) {
        this.skillPointsInvested = skillPointsInvested;
    }
}
