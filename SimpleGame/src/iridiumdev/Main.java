package iridiumdev;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Dust",100,100,100, 0,5,5,
                4,5,5,4);
        ArrayList<Character> actionQueue = new ArrayList<>();
        Enemy enemy_01 = Enemy.randomEnemy(player.getLevel(),dice(3));

        System.out.println(" Enemy: " + enemy_01.getName() + "\n");
        actionOrder(player,enemy_01,actionQueue);
        System.out.println("\n Action order: \n" + actionQueue.get(0) + "\n" + actionQueue.get(1));

        combat(actionQueue.get(0), actionQueue.get(1));

    }

    public static void combat(Character firstIn_ActionOrder, Character SecondIn_ActionOrder){
        /*
        FiAO <strength lub power> dodane do <podstawowych obrażeń broni lub umiejętności> i <rzutu kostką>
        SiAO <defence lub protection>
         */
    }

    public static void actionOrder(Character char_1, Character char_2, ArrayList<Character> arrayList){
        int char_1_BaseStat = char_1.higherStat(char_1.getQuickness(), char_1.getFocus());
        int char_2_BaseStat = char_2.higherStat(char_2.getQuickness(), char_2.getFocus());

        int char_1_Initiative = char_1_BaseStat + dice(6);
        int char_2_Initiative = char_2_BaseStat + dice(6);

        if(char_1_Initiative >= char_2_Initiative){
            arrayList.add(0,char_1);
            arrayList.add(1,char_2);
            System.out.println(char_1.getName() + " rolls " + char_1_Initiative + " [" + char_1_BaseStat + " base]");
            System.out.println(char_2.getName() + " rolls " + char_2_Initiative + " [" + char_2_BaseStat + " base]");
        } else if(char_1_Initiative < char_2_Initiative){
            arrayList.add(0, char_2);
            arrayList.add(1, char_1);
            System.out.println(char_2.getName() + " rolls " + char_2_Initiative + " [" + char_2_BaseStat + " base]");
            System.out.println(char_1.getName() + " rolls " + char_1_Initiative + " [" + char_1_BaseStat + " base]");
        }
    }

        /*
        - Zmienić actionOrder() -> po pierwszym rzucie kością każdej ze stron, ta która rzuciła więcej wybiera swój lepszy
        atrybut (Quickness vs Focus), który użyją obie strony przy drugim rzucie, który to dopiero rzut ostatecznie ustali kolejność!

        - Dodać metodę sprawdzającą, czy char_1 jest pierwszy na liście.
        Jeśli nie jest, wtedy char_2 używa combat() jako pierwszy.
        */


    public static int dice(int numberOfWalls){
        Random dice = new Random();
        return dice.nextInt(numberOfWalls) +1;
    } // method tested.




}


/*
        Walka:
        1. Atak podstawowy
        2. Atak specjalny (FightingSkills, MagicSkills)
        3. Obrona
        4. Ucieczka (porównanie atrybutu quickness gracza z atrybutami quickness i focus przeciwnika
                        - jeśli to drugie jest wyższe, przeciwnik wykona ostatni atak przed opuszczeniem pola bitwy przez gracza)


        */