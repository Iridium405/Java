package iridiumdev;

import java.util.Random;

public class Dice {

    public int throwDice (int numberOfSides){
        Random dice = new Random();
        return dice.nextInt(numberOfSides) +1;
    }
}
