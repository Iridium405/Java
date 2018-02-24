package iridiumdev;

import java.util.ArrayList;
import java.lang.Math;

public class CompPlayer {
    private String compName;
    private int compFinalPoints;
    private int compTempPoints;
    ArrayList<Integer> compShots = new ArrayList<>();

    public CompPlayer() {
        this.compName = generateName();
        this.compFinalPoints = 0;
    }

    public String getCompName() {
        return compName;
    }

    public int getCompTempPoints() {
        return compTempPoints;
    }

    public void setCompTempPoints(int compTempPoints) {
        this.compTempPoints = compTempPoints;
    }

    public int getCompFinalPoints() {
        return compFinalPoints;
    }

    public ArrayList<Integer> getCompShots() {
        return compShots;
    }

    public String generateName() {
        String compName = "Unknown";
        int random = (int)(Math.random() * 9 + 1);
        switch(random) {
            case 1:
                compName = "Stary Franklin";
                break;
            case 2:
                compName = "Połamany George";
                break;
            case 3:
                compName = "Krzywy Steve";
                break;
            case 4:
                compName = "Jednoręki Mike";
                break;
            case 5:
                compName = "Głuchy Bob";
                break;
            case 6:
                compName = "Zezowaty Chris";
                break;
            case 7:
                compName = "Młody Gregory";
                break;
            case 8:
                compName = "Dziurawy Jon";
                break;
            case 9:
                compName = "Nikczemny Mervin";
                break;
        }

        return compName;
    }

    public void addCompLuckyShots() {
        while(compShots.size() <= 2){
            if(!compName.equals("Nikczemny Mervin")) {
                int shot = (int)(Math.random() * 12 + 1);
                while(!compShots.contains(shot)){
                    compShots.add(shot);
                }
            } else {
                int shot = (int)(Math.random() * 20 + 1);
                while (!compShots.contains(shot)) {
                    compShots.add(shot);
                }
            }
        }

        System.out.println("Oddane przez przeciwnika o imieniu " + getCompName() + " strzały, to: " + compShots);
    }

    public void addPoints(){
        this.compFinalPoints += compTempPoints;
    }

}