package world;

import entity.Entity;
import utils.ClearScreen;

import static world.World.worldColumn;
import static world.World.worldRow;

public class WorldRender {

    public static final String ANSI_RESET_COLOR = "\u001b[0m";
    public static final String ANSI_COW = "\ud83d\udc2e";
    public static final String ANSI_WOLF = "\ud83d\udc3a";
    public static final String ANSI_GRASS = "\ud83c\udf40";
    public static final String ANSI_ROCK = "\ud83e\udea8";
    public static final String ANSI_TREE = "\ud83c\udf34";
    public static final String ANSI_EMPTY = "\u25ab\ufe0f";
    public static final String ANSI_BACKGROUND = "\033[48;2;250;250;250m"; // grey


    public static void render(World world) {
        // for windows
        ClearScreen.clrscr();
        // for linux
/*        System.out.print("\033[H\033[2J");
        System.out.flush();*/

        for (int i = 0; i < worldRow; i++) {
            String line = "";
            for (int j = 0; j < worldColumn; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (world.isCellEmpty(coordinates)) {
                    line += setEmptySprite();
                } else {
                    line += setFullSprite(world.getEntity(coordinates));
                }

            }
            line += ANSI_RESET_COLOR;
            System.out.println(line + ANSI_RESET_COLOR);
        }
        System.out.println();
        System.out.println("Pause - enter 1");
        System.out.println("Continue - enter 0");
    }

    private static String setEmptySprite(){
        return ANSI_BACKGROUND + ANSI_EMPTY;
    }
    private static String setFullSprite(Entity entity){
        String result = "";
        switch (entity.getClass().getSimpleName()) {
            case "Herbivore":
                result = ANSI_BACKGROUND + ANSI_COW;
                break;
            case "Predator":
                result = ANSI_BACKGROUND + ANSI_WOLF;
                break;
            case "Grass":
                result = ANSI_BACKGROUND + ANSI_GRASS;
                break;
            case "Rock":
                result = ANSI_BACKGROUND + ANSI_ROCK;
                break;
            case "Tree":
                result = ANSI_BACKGROUND + ANSI_TREE;
                break;
            default:
                break;
        }

        return result;
    }
}
