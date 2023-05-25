package action;

import world.World;
import world.WorldRender;

import java.util.ArrayList;
import java.util.List;

public class InitActions extends Action {

    private List<SpawnAction> listInit = new ArrayList<>();

    @Override
    public void perfom(World world) {
        listInit.add(new GrassSpawnAction(world));
        listInit.add(new TreeSpawnAction(world));
        listInit.add(new RockSpawnAction(world));
        listInit.add(new HerbovoreSpawnAction(world));
        listInit.add(new PredatorSpawnAction(world));
    }

    public void init(World world) {
        perfom(world);
        for (Action item: listInit) {
            item.perfom(world);
        }
        WorldRender.render(world);
    }
}
