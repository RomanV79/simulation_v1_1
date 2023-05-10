package start;

import action.InitActions;
import action.TurnActions;
import utils.KeyHandler;
import world.World;

public class Simulation {
    private volatile boolean isPause = false;

    public void setPause(boolean pause) {
        isPause = pause;
    }

    public static void main(String[] args) throws InterruptedException {
        World world = new World();
        Simulation simulation = new Simulation();
        KeyHandler keyHandler = new KeyHandler(simulation);
        Thread thread = new Thread(keyHandler);
        thread.start();

        simulation.startSimulation(world);

    }

    private synchronized void nextTurn(TurnActions turnActions, World world) {
        turnActions.turnAction(world);
    }
    public void startSimulation(World world) throws InterruptedException {
        InitActions initActions = new InitActions();
        initActions.initAction(world);

        TurnActions turnActions = new TurnActions();
        while (turnActions.isNextStepExist()) {
            while (isPause) {
                Thread.sleep(500);
            }
            nextTurn(turnActions, world);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}