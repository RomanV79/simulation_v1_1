package entity;

public class Predator extends Creature {
    private Integer power;
    public Predator(Integer speed, Integer HP, Integer power) {
        super(speed, HP);
        this.power = power;
    }
}
