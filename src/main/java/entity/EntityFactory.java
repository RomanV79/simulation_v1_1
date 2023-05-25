// deactivate for use abstract class by SpawnAction

//package entity;
//
//import java.util.Random;
//
//public class EntityFactory {
//
//    public static Entity createEntity(EntityType entityType){
//        Random random = new Random();
//
//        switch (entityType) {
//            case HERBIVORE:
//                return new Herbivore(random.nextInt(5) + 5, random.nextInt(10) + 10);
//            case PREDATOR:
//                return new Predator(random.nextInt(10) + 5, random.nextInt(5) + 5, random.nextInt(5) + 5);
//            case ROCK:
//                return new Rock();
//            case GRASS:
//                return new Grass();
//            case TREE:
//                return new Tree();
//
//            default:
//                return null;
//        }
//
//
//    }
//}
