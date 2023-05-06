package entity;

import world.World;

public abstract class Creature extends Entity {

    private Integer speed;
    private Integer HP;

    public Creature(Integer speed, Integer HP) {
        this.speed = speed;
        this.HP = HP;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getHP() {
        return HP;
    }

    abstract public void makeMove(World world);

}
