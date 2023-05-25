package action;

import entity.Tree;
import world.Coordinates;
import world.World;

public class TreeSpawnAction extends SpawnAction<Tree>{
    @Override
    protected Tree spawnEntity(Coordinates coordinates) {
        return new Tree(coordinates);
    }

    public TreeSpawnAction(World world) {
        double percent = 2;
        super.maxQuantity = world.getSize() * percent / 100;
    }
}
