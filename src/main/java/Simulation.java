import action.InitActions;
import action.TurnActions;
import world.World;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        World world = new World();
        Simulation simulation = new Simulation();

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

            nextTurn(turnActions, world);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void pauseSimulation(){

    }
}