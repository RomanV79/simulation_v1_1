package utils;

import start.Simulation;

import java.util.Scanner;

public class KeyHandler implements Runnable {
    private final Simulation simulation;

    public KeyHandler(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String userInstruction = "";
        while (true) {
            userInstruction = scanner.nextLine();
            if (userInstruction.equals("0")) {
                simulation.setPause(false);
            }
            if (userInstruction.equals("1")) {
                simulation.setPause(true);
            }
        }

    }
}
