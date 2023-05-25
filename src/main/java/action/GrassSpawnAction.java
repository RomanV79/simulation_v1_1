package action;

import entity.Grass;
import world.Coordinates;
import world.World;

public class GrassSpawnAction extends SpawnAction<Grass> {
    @Override
    protected Grass spawnEntity(Coordinates coordinates) {
        return new Grass(coordinates);
    }

    public GrassSpawnAction(World world) {
        double percent = 2;
        super.maxQuantity = world.getSize() * percent / 100;
    }
}
