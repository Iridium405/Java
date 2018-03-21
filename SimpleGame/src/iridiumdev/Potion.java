package iridiumdev;

public class Potion{

    private String name;
    private String type;
    private int quantity;
    private int increaseBy;
    private int decreaseBy;
    //TODO: private double value;

    public Potion(String name, int increaseBy, int decreaseBy) {
        this.name = name;
        this.type = "Potion";
        this.quantity = quantity;
        this.increaseBy = increaseBy;
        this.decreaseBy = decreaseBy;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIncreaseBy() {
        return increaseBy;
    }

    public int getDecreaseBy() {
        return decreaseBy;
    }

    public int usePotion(Potion potion) {
        if (this.getQuantity() >= 1 && increaseBy >= 1) {
            setQuantity(potion.getQuantity() - 1);
            return increaseBy;
        } else if (this.getQuantity() >= 1 && decreaseBy >= 1) {
            setQuantity(potion.getQuantity() - 1);
            return decreaseBy;
        } else{
            System.out.println("Cannot use potion.");
            return 0;
        }
    }



    //public void quantityCheck
}
