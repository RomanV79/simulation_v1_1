package world;

import entity.*;

import java.util.HashMap;
import java.util.Random;

public class World {
    public static final Integer worldRow = 15;
    public static final Integer worldColumn = 30;
    public static final Integer qntOfEntityStartPercent = 10;

    private HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity){
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public HashMap<Coordinates, Entity> getEntities() {
        return entities;
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void getStartEntitySet(){
        Random random = new Random();
        int qntOfTypeEntity = EntityType.values().length;
        int eachOfEntityType = (worldRow * worldColumn * qntOfEntityStartPercent / 100) / qntOfTypeEntity;
        for (EntityType item: EntityType.values()) {
            for (int i = 0; i < eachOfEntityType; i++) {
                Coordinates coordinates;
                do {
                    coordinates = new Coordinates(random.nextInt(worldRow), random.nextInt(worldColumn));
                } while (!isCellEmpty(coordinates));

                Entity entity = EntityFactory.createEntity(item);
                setEntity(coordinates, entity);
            }
        }
    }

    public boolean isGrass(Entity entity){

        return (entity != null) && entity.getClass().getSimpleName().equals("Grass");
    }
    public boolean isHerbivore(Entity entity){
        return (entity != null) && entity.getClass().getSimpleName().equals("Herbivore");
    }
}
