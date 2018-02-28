package iridiumdev;

public abstract class Weapon {
    private String weaponName;
    private double weaponDamage;
    private double weaponEndurance;

    public Weapon(String weaponName, double weaponDamage, double weaponEndurance) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.weaponEndurance = weaponEndurance;
    }
}
