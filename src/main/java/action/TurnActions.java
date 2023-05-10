package action;

import entity.*;
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
        List<Grass> grassList = getGrassList(world);
        List<Creature> herbivoreList = getHerbivoreList(world);
        if (grassList.isEmpty() || herbivoreList.isEmpty()) {
            isNextStepExist = false;
            System.out.println("Закончились объекты ради которых можно двигаться.");
            System.out.println("Травоядные съели всю траву или хищники съели всех травоядных");
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
    private List<Grass> getGrassList(World world){
        world.getEntities();
        List<Grass> grassList = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> item: world.getEntities().entrySet()) {
            if (item.getValue() instanceof Grass) {
                grassList.add((Grass) item.getValue());
            }
        }
        return grassList;
    }
    private List<Creature> getHerbivoreList(World world){
        world.getEntities();
        List<Creature> herbivoreList = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> item: world.getEntities().entrySet()) {
            if (item.getValue() instanceof Predator) {
                herbivoreList.add((Creature) item.getValue());
            }
        }
        return herbivoreList;
    }

}
