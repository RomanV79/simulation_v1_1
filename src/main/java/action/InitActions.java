package action;

import world.World;
import world.WorldRender;

public class InitActions extends Action {

    @Override
    public void perfom(World world) {
        world.getStartEntitySet();
        WorldRender.render(world);
    }
}
