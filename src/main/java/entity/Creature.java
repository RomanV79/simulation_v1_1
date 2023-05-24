package entity;

import utils.PathBuilder;
import world.Coordinates;
import world.World;
import world.WorldRender;

import java.util.List;

public abstract class Creature extends Entity {

    private Integer speed;
    private Integer HP;

    PathBuilder pathBuilder = new PathBuilder();

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

    public void makeMove(World world) {
        Coordinates coordinates = this.coordinates;
        List<Coordinates> path = pathBuilder.getPath(coordinates, this, world);

        int length;
        if (this.getSpeed() >= (path.size())) {
            length = path.size();
        } else {
            length = this.getSpeed();
        }

        for (int i = 1; i < length; i++) {
            world.removeEntity(path.get(i - 1));
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
