package iridiumdev;

public class Potion extends Item {

    private int increaseBy;
    private int decreaseBy;

    public Potion(String name, int quantity, int increaseBy, int decreaseBy) {
        super(name, quantity);
        this.increaseBy = increaseBy;
        this.decreaseBy = decreaseBy;
    }

    public int getIncreaseBy() {
        return increaseBy;
    }

    public int getDecreaseBy() {
        return decreaseBy;
    }

    public int usePotion(Potion potion){
        if(potion.increaseBy >= 1){
            potion.setQuantity(potion.getQuantity() - 1);
            return increaseBy;
        } if(potion.decreaseBy >= 1){
            potion.setQuantity(potion.getQuantity() - 1);
            return decreaseBy;
        } else {
            return 0;
        }
    }



    //public void quantityCheck
}
