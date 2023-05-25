package action;

import entity.Rock;
import world.Coordinates;
import world.World;

public class RockSpawnAction extends SpawnAction<Rock> {
    @Override
    protected Rock spawnEntity(Coordinates coordinates) {
        return new Rock(coordinates);
    }

    public RockSpawnAction(World world) {
        double percent = 2;
        super.maxQuantity = world.getSize() * percent / 100;
    }
}
