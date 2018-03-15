package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Dust",100,100,100,5,5,5,5,5,5);
        ArrayList<Enemy> enemies = new ArrayList<Enemy>(dice(6));

        for (int x =1; x < enemies.size(); x++){
            enemies.add(x,Enemy.randomEnemyLvl_1(dice(3)));
            System.out.println();
        }




      /*  Enemy enemy_01 = Enemy.randomEnemyLvl_1(dice(3));
        Enemy enemy_02 = Enemy.randomEnemyLvl_1(dice(3));
        Enemy enemy_03 = Enemy.randomEnemyLvl_1(dice(3));

        System.out.println("Przeciwnicy: \n" + enemies.get(0) + "\n" + enemy_02.getName() + "\n" + enemy_03.getName());
*/

    }

    public static void combat(Player player, Enemy enemy){

    }

   /* public static Enemy randomEnemyLvl_1(int random){
        switch(random){
            case 1:
                Enemy enemy_01 = new Enemy("Goblin Marauder", 60,0,60,20,3,2,4,1,2,1);
                return enemy_01;
            case 2:
                Enemy enemy_02 = new Enemy("Goblin Shaman", 50,70,20,30,1,2,1,3,2,4);
                return enemy_02;
            default:
                return null;
        }
    }*/

    public static int dice(int numberOfWalls){
        Random dice = new Random();
        return dice.nextInt(numberOfWalls) +1;
    } //metoda dice() - checked.


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