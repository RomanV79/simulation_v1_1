package action;

import world.World;
import world.WorldRender;

public class InitActions extends Action {

    public void initAction(World world){
        world.getStartEntitySet();

        WorldRender worldRender = new WorldRender();
        worldRender.render(world);
    }
}
