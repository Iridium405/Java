package iridiumdev;

public class IncantationFactory {

    public Spell learnHealing() {
        return new Magic_Healing("Restore Health", "life");
    }

    public Spell learnDraining() {
        return new Magic_LifeDraining("Drain Health", "death");
    }

    public Spell learnResizingFireball() {
        return new Magic_Fireball("Resizing Fireball", "fire");
    }

    public Spell learnMultipliedFireball() {
        return new Magic_Fireball("Multiplied Fireball", "fire");
    }

    public Spell learnIceShard() {
        return new Magic_IceShard("Ice Shard", "ice");
    }
}
