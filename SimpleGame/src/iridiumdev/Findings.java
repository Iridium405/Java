package iridiumdev;

public class Findings {

    private Dice findingDice = new Dice();
    private WeaponFactory weapons = new WeaponFactory();
    private Weapon weaponFound;

    public Weapon randomWeapon(){
        switch(findingDice.throwDice(10)){
            case 1:
                return weaponFound = weapons.sword_001;
            case 2:
                return weaponFound = weapons.sword_002;
            case 3:
                return weaponFound = weapons.sword_003;
            case 4:
                return weaponFound = weapons.sword_004;
            case 5:
                return weaponFound = weapons.sword_005;
            case 6:
                return weaponFound = weapons.hammer_001;
            case 7:
                return weaponFound = weapons.hammer_002;
            case 8:
                return weaponFound = weapons.spear_001;
            case 9:
                return weaponFound = weapons.spear_002;
            case 10:
                return weaponFound = weapons.spear_003;
            default:
                return null;
        }
    }

    public Weapon getWeaponFound() {
        return weaponFound;
    }
}
