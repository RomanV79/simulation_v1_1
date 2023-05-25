package action;

import entity.Predator;
import world.Coordinates;
import world.World;

public class PredatorSpawnAction extends SpawnAction<Predator>{

    @Override
    protected Predator spawnEntity(Coordinates coordinates) {
        return new Predator(coordinates);
    }

    public PredatorSpawnAction(World world) {
        double percent = 2;
        super.maxQuantity = world.getSize() * percent / 100;
    }
}
