package action;

import entity.Creature;
import entity.Entity;
import entity.Herbivore;
import entity.Predator;
import world.Coordinates;
import world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TurnActions {
    private boolean isNextStepExist = true;
    public boolean isNextStepExist() {
        return isNextStepExist;
    }
    public void turnAction(World world) {
        Random random = new Random();
        List<Creature> creatureList = getCreatureList(world);
        if (creatureList.isEmpty()) {
            isNextStepExist = false;
        } else {
            Creature randomCreature = creatureList.get(random.nextInt(creatureList.size() - 1));
            if (randomCreature instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) randomCreature;
                herbivore.makeMove(world);
            }
            if (randomCreature instanceof Predator) {
                Predator predator = (Predator) randomCreature;
                predator.makeMove(world);
            }
        }
    }

    private List<Creature> getCreatureList(World world){
        world.getEntities();
        List<Creature> creatureList = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> item: world.getEntities().entrySet()) {
            if (item.getValue() instanceof Creature) {
                creatureList.add((Creature) item.getValue());
            }
        }
        return creatureList;
    }

}
