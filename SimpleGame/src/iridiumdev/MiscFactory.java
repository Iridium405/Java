package iridiumdev;

public class MiscFactory {
    private Misc miscFound;

    public Misc miscellaneous(int random){
        switch (random){
            case 1:
                return miscFound = new Misc("Zepsuty kompas",1);
            case 2:
                return miscFound = new Misc("Potłuczony zestaw alchemika", 2);
            case 3:
                return miscFound = new Misc("Stary zegar", 10);
            case 4:
                return miscFound = new Misc("Brudne szmaty", 2);
            case 5:
                return miscFound = new Misc("Szklany kielich", 3);
            case 6:
                return miscFound = new Misc("Pozłacany naszyjnik", 20);
            case 7:
                return miscFound = new Misc("Aksamitna chusta", 35);
            case 8:
                return miscFound = new Misc("Drewniany róg", 7);
            case 9:
                return miscFound = new Misc("Róg z kości słoniowej", 70);
            case 10:
                return miscFound = new Misc("Złoty pierścień z szafirem", 250);
            default:
                System.out.println("Null");
                return null;
        }
    }

    public Misc getMiscFound() {
        return miscFound;
    }

    public void setMiscFound(Misc miscFound) {
        this.miscFound = miscFound;
    }
}
