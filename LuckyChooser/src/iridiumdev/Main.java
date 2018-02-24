package iridiumdev;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoje imię:");
        String name = scanner.nextLine();
        HumanPlayer player = new HumanPlayer(name);
        Messages messages = new Messages();
        CompPlayer comp = new CompPlayer();

        int roundCount = 1;
        System.out.println("Witaj " + name + "!" + "\nZmierzysz się z wirtualnym przeciwnikiem o imieniu "
                + comp.getCompName() + "!\n");
        messages.startMsg(comp.getCompName());

        while (roundCount >= 1 & roundCount <= 3) {
            System.out.println("Runda " + roundCount + ":");
            while (player.playerShots.size() <= 2) {
                int shot = scanner.nextInt();
                player.addPlayerLuckyShot(shot);
            }
            System.out.println("Oddane przez Ciebie strzały to: " + player.playerShots);
            comp.addCompLuckyShots();
            player.setPlayerTempPoints(shotsComparator(player.playerShots, comp.compShots));

            System.out.println("Punkty zdobyte w tej rundzie: " + player.getPlayerTempPoints() + "\n");
            player.addPoints();
            player.playerShots.clear();
            comp.compShots.clear();
            roundCount++;
        }
        messages.midMsg(player.getPlayerFinalPoints());

        while (roundCount >= 4 && roundCount <= 6) {
            System.out.println("Runda " + roundCount + ":");
            while (player.playerShots.size() <= 2) {
                int shot = scanner.nextInt();
                player.addPlayerLuckyShot(shot);
            }
            comp.addCompLuckyShots();
            System.out.println("Oddane przez Ciebie strzały to: " + player.playerShots);
            comp.setCompTempPoints(shotsComparator(comp.compShots, player.playerShots));
            comp.addPoints();
            player.playerShots.clear();
            comp.compShots.clear();
            roundCount++;
        }

        System.out.println("\nKoniec pojedynku!");
        finalResult(player.getPlayerFinalPoints(), comp.getCompFinalPoints());

    }

    public static int shotsComparator(ArrayList<Integer> attackingArrayList, ArrayList<Integer> defendingArrayList){
        int pointsGained = 0;
        if(!attackingArrayList.isEmpty() && !defendingArrayList.isEmpty()){
            for(int a =0; a <=2; a++) {
                for(int d =0; d <=2; d++) {
                    if (attackingArrayList.get(a) - defendingArrayList.get(d) == 0) {
                        pointsGained += 3;
                    }
                    if (attackingArrayList.get(a) - defendingArrayList.get(d) == 1 ||
                            attackingArrayList.get(a) - defendingArrayList.get(d) == -1){
                        pointsGained += 1;
                    }
                }
            }
        }
        return pointsGained;
    }

    public static int finalResult(int playerResults, int compResults) {
        int finalResult = playerResults - compResults;
        if(finalResult > 0) {
            System.out.println("Gratulacje! Twój przeciwnik padł martwy.\n" +
                    "Na Twoim koncie zapisuje się " + finalResult + " pkt.\n");
        } else if(finalResult == 0) {
            System.out.println("Obaj ciężko ranni odchodzicie, każdy w swoją stronę.\n" +
                    "Otrzymujesz " +finalResult + " pkt.\n");
        } else {
            System.out.println("Niestety, poległeś... Przeciwnik wypruł Ci bebechy.\n" +
                    "Na tablicy wyników będziesz figurował z " + finalResult + " pkt.\n");
        }
        return finalResult;
    }

}