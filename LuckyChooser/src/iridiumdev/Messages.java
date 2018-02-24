package iridiumdev;

public class Messages {

    public void startMsg(String enemyName) {
        System.out.println("Naprzeciw Ciebie stoi mistrz rewolweru - " + enemyName + ", poszukiwany żywy lub martwy." +
                "\nOddaj w jego stronę trzy strzały - wybierz liczby z przedziału od 1 do 12.\n" +
                "Pamiętaj! " + enemyName + " spróbuje zestrzelić Twoje kule w locie!\n");
    }

    public void midMsg(int score) {
        System.out.println("Dobra robota! Udało Ci się zdobyć " + score + " punktów!\n" +
                "Teraz przeciwnik atakuje, postaraj się przewidzieć gdzie będzie strzelał,\n" +
                "aby stracić jak najmniej zdobytych punktów.\n");
    }
}