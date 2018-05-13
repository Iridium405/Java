package iridiumdev;

public class Sword extends Weapon {

    private String type;

    public Sword(String name, int minDamage, int maxDamage) {
        super(name, minDamage, maxDamage);
        this.type = "sword";
    }

    public String getType() {
        return type;
    }
}
