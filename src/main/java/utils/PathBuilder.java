package utils;

import entity.Creature;
import entity.Herbivore;
import entity.Predator;
import world.Coordinates;
import world.World;

import java.util.*;

public class PathBuilder {

    public List<Coordinates> getPath(Coordinates coordinates, Creature creature, World world) {
        Queue<Coordinates> cellQueue = new LinkedList<>();
        Set<Coordinates> visitedCells = new HashSet<>();
        // ключ - текущая ячейка, значение - ее родитель
        HashMap<Coordinates, Coordinates> parents = new HashMap<>();
        cellQueue.add(coordinates);
        Coordinates target = null;

        Coordinates currentCell;
        stopSearch:
        while(!cellQueue.isEmpty()) {
            currentCell = cellQueue.remove();
            visitedCells.add(currentCell);
            List<Coordinates> neighbourCell = getNeighbourCell(currentCell);
            for (Coordinates item: neighbourCell) {
                if (world.isCellEmpty(item) && !visitedCells.contains(item)) {
                    cellQueue.add(item);
                    parents.put(item, currentCell);
                } else {
                    if ((creature instanceof Predator) && world.isHerbivore(world.getEntity(item))) {
                        target = item;
                        parents.put(item, currentCell);
                        break stopSearch;
                    }
                    if ((creature instanceof Herbivore) && world.isGrass(world.getEntity(item))) {
                        target = item;
                        parents.put(item, currentCell);
                        break stopSearch;
                    }
                }
            }
        }

        List<Coordinates> path = new ArrayList<>();
        path.add(target);
        Coordinates temp = target;
        while (path.get(path.size() - 1) != coordinates) {
            temp = parents.get(temp);
            path.add(temp);
        }
        Collections.reverse(path);

        return path;
    }

    private List<Coordinates> getNeighbourCell(Coordinates coordinates) {
        int row;
        int column;
        List<Coordinates> list = new ArrayList<>();

        if ((row = coordinates.row - 1) >= 0) { list.add(new Coordinates(row, coordinates.column));}
        if ((row = coordinates.row + 1) < World.worldRow) { list.add(new Coordinates(row, coordinates.column));}
        if ((column = coordinates.column - 1) >= 0) { list.add(new Coordinates(coordinates.row, column));}
        if ((column = coordinates.column + 1) < World.worldColumn) { list.add(new Coordinates(coordinates.row, column));}

        return list;
    }
}
