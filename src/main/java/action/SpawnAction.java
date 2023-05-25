package action;

import entity.Entity;
import world.Coordinates;
import world.World;

public abstract class SpawnAction<T extends Entity> extends Action {
    protected double maxQuantity;
    @Override
    public void perfom(World world) {
        double currentQuantity = 0;
        while (currentQuantity < maxQuantity) {
            Coordinates coordinates = world.getEmptyRandomCoordinates();
            world.setEntity(coordinates, spawnEntity(coordinates));
            currentQuantity++;
        }
    }

    protected abstract T spawnEntity(Coordinates coordinates);
}
