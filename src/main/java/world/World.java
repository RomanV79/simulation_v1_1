package world;

import entity.*;

import java.util.*;

public class World {
    public static final Integer worldRow = 15;
    public static final Integer worldColumn = 30;
    public static final Integer qntOfEntityStartPercent = 10;

    private HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Coordinates coordinates, Entity entity){
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
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

    public <T> List<T> getEntitiesOfType(Class<T> type){
        List<T> list = new ArrayList<>();
        for (Map.Entry<Coordinates, Entity> item: getEntities().entrySet()) {
            if (type.isInstance(item.getValue())) {
                list.add((T) item.getValue());
            }
        }
        return list;
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
        return entity instanceof Grass;
    }
    public boolean isHerbivore(Entity entity){
        return entity instanceof Herbivore;
    }
}
