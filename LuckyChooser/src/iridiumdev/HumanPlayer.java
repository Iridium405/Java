package iridiumdev;

import java.util.ArrayList;

public class HumanPlayer {
    private String playerName;
    private int playerFinalPoints;
    private int playerTempPoints;
    ArrayList<Integer> playerShots = new ArrayList<>();

    public HumanPlayer(String playerName) {
        this.playerName = playerName;
        this.playerFinalPoints = 0;

    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerFinalPoints() {
        return playerFinalPoints;
    }

    public void setPlayerTempPoints(int playerTempPoints) {
        this.playerTempPoints = playerTempPoints;
    }

    public int getPlayerTempPoints() {
        return playerTempPoints;
    }

    public void addPlayerLuckyShot(int shot) {
        if(shot < 1 || shot >12) {
            System.out.println("Podaj liczby z przedziału od 1 do 12.\nNie oddano strzału.\n");
        } else if(playerShots.size() > 2){
            System.out.println("Możesz oddać tylko 3 strzały.\n");
        } else if(playerShots.contains(shot)) {
            System.out.println("Ta liczba została już raz wybrana w tej kolejce, wybierz inną.\n" +
                    "Nie oddano strzału.\n");
        } else {
            playerShots.add(shot);
            System.out.println("Oddano strzał.\n");
        }
    }

    public void addPoints(){
        this.playerFinalPoints += playerTempPoints;
    }

}