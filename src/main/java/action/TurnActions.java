package action;

import entity.*;
import world.World;
import java.util.List;
import java.util.Random;

public class TurnActions extends Action {
    private boolean isNextStepExist = true;
    public boolean isNextStepExist() {
        return isNextStepExist;
    }
//    public void turnAction(World world) {
//        Random random = new Random();
//        List<Creature> creatureList = world.getEntitiesOfType(Creature.class);
//        List<Grass> grassList = world.getEntitiesOfType(Grass.class);
//        List<Herbivore> herbivoreList = world.getEntitiesOfType(Herbivore.class);
//        if (grassList.isEmpty() || herbivoreList.isEmpty()) {
//            isNextStepExist = false;
//            System.out.println("Закончились объекты ради которых можно двигаться.");
//            System.out.println("Травоядные съели всю траву или хищники съели всех травоядных");
//        } else {
//            int n = random.nextInt(creatureList.size());
//            Creature randomCreature = creatureList.get(n);
//            if (randomCreature instanceof Herbivore) {
//                Herbivore herbivore = (Herbivore) randomCreature;
//                herbivore.makeMove(world);
//            }
//            if (randomCreature instanceof Predator) {
//                Predator predator = (Predator) randomCreature;
//                predator.makeMove(world);
//            }
//        }
//    }

    @Override
    public void perfom(World world) {
        Random random = new Random();
        List<Creature> creatureList = world.getEntitiesOfType(Creature.class);
        List<Grass> grassList = world.getEntitiesOfType(Grass.class);
        List<Herbivore> herbivoreList = world.getEntitiesOfType(Herbivore.class);
        if (grassList.isEmpty() || herbivoreList.isEmpty()) {
            isNextStepExist = false;
            System.out.println("Закончились объекты ради которых можно двигаться.");
            System.out.println("Травоядные съели всю траву или хищники съели всех травоядных");
        } else {
            int n = random.nextInt(creatureList.size());
            Creature randomCreature = creatureList.get(n);
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
}
