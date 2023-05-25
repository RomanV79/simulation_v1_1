package entity;

import world.Coordinates;
import world.World;

public class Predator extends Creature {
    protected Integer power;
    public Predator(Coordinates coordinates) {
        this.speed = World.random.nextInt(10) + 10;
        this.HP = World.random.nextInt(5) + 5;
        this.power = World.random.nextInt(5) + 5;
        this.coordinates = coordinates;
    }
}
