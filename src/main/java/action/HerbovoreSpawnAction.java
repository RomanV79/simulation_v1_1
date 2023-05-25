package action;

import entity.Herbivore;
import world.Coordinates;
import world.World;

public class HerbovoreSpawnAction extends SpawnAction<Herbivore>{
    @Override
    protected Herbivore spawnEntity(Coordinates coordinates) {
        return new Herbivore(coordinates);
    }

    public HerbovoreSpawnAction(World world) {
        double percent = 2;
        super.maxQuantity = world.getSize() * percent / 100;

    }
}
