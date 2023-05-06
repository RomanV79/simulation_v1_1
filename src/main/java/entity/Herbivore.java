package entity;

import utils.PathBuilder;
import world.Coordinates;
import world.World;
import world.WorldRender;

import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(Integer speed, Integer HP) {
        super(speed, HP);
    }

    @Override
    public void makeMove(World world) {
        Coordinates coordinates = this.coordinates;
        PathBuilder pathBuilder = new PathBuilder();
        List<Coordinates> path = pathBuilder.getPath(coordinates, this, world);

        int length;
        if (this.getSpeed() >= (path.size())) {
            length = path.size();
        } else {
            length = this.getSpeed();
        }

        for (int i = 1; i < length; i++) {
            world.getEntities().remove(path.get(i - 1));
            world.setEntity(path.get(i), this);
            WorldRender.render(world);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}