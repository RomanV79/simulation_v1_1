package entity;

import world.Coordinates;
import world.World;

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        this.speed = World.random.nextInt(5) + 5;
        this.HP = World.random.nextInt(10) + 10;
        this.coordinates = coordinates;
    }

}