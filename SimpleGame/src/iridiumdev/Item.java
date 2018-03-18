package iridiumdev;

public abstract class Item {
    private String name;
    private String type;
    private int quantity;
    private int increaseBy;
    private int decreaseBy;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Item(String name, int quantity, int increaseBy, int decreaseBy) {
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

    public int usePotion(Item potion) {
            if (type.equals("Potion")&& getQuantity() >= 1 && increaseBy >= 1) {
                setQuantity(potion.getQuantity() - 1);
                return increaseBy;
            } else if (type.equals("Potion")&& getQuantity() >= 1 && decreaseBy >= 1) {
                setQuantity(potion.getQuantity() - 1);
                return decreaseBy;
            } else {
                System.out.println("Use potion-type item.");
                return 0;
            }
    }

}

/*
rozszerzy klasy broni, zbroi, przedmiotów użytecznych, materiałów
 */