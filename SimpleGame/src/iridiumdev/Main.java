package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Dust",100,100,100, 0,5,5,5,5,5,5);

        Enemy enemy_01 = Enemy.randomEnemy(player.getLevel(),dice(3));
        //Enemy enemy_02 = Enemy.randomEnemyLv_01(dice(3));
        //Enemy enemy_03 = Enemy.randomEnemyLv_02(dice(3));

        System.out.println("Przeciwnik: \n" + enemy_01.getName());
        player.levelChecking();
        System.out.println("Poziom gracza: " + player.getLevel());
        player.setExperience(450);
        player.levelChecking();
        System.out.println("Poziom gracza: " + player.getLevel());

    }

    public static void combat(Player player, Enemy enemy){

    }


    public static int dice(int numberOfWalls){
        Random dice = new Random();
        return dice.nextInt(numberOfWalls) +1;
    } //method dice() - checked.




}


/*
        Walka:
        1. Atak podstawowy
        2. Atak specjalny (IFightingSkills, IMagicSkills)
        3. Obrona
        4. Ucieczka

        Ustalanie kolejności wykonywania czynności: sprawdzenie, który z atrybutów jest wyższy
        - quickness czy focus - wybranie większego + rzut kostką k6
        */