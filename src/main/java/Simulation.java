import action.InitActions;
import action.TurnActions;
import world.World;

public class Simulation {

    public static void main(String[] args) {
        World world = new World();

        Simulation simulation = new Simulation();
        simulation.startSimulation(world);

        simulation.nextTurn(world);

    }

    private void nextTurn(World world) {
        TurnActions turnActions = new TurnActions();
        turnActions.turnAction(world);
    }

    public void startSimulation(World world){
        InitActions initActions = new InitActions();
        initActions.initAction(world);

        TurnActions turnActions = new TurnActions();
        while (turnActions.isNextStepExist()) {
            nextTurn(world);
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