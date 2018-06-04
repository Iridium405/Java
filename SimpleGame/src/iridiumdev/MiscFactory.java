package iridiumdev;

public class MiscFactory {

    public Misc miscellaneous(int random){
        switch (random){
            case 1:
                return new Misc("Zepsuty kompas",1);
            case 2:
                return new Misc("Potłuczony zestaw alchemika", 2);
            case 3:
                return new Misc("Stary zegar", 10);
            case 4:
                return new Misc("Brudne szmaty", 2);
            case 5:
                return new Misc("Szklany kielich", 3);
            case 6:
                return new Misc("Pozłacany naszyjnik", 20);
            case 7:
                return new Misc("Aksamitna chusta", 35);
            case 8:
                return new Misc("Drewniany róg", 7);
            case 9:
                return new Misc("Róg z kości słoniowej", 70);
            case 10:
                return new Misc("Złoty pierścień z szafirem", 250);
            default:
                System.out.println("Null");
                return null;
        }
    }
}
