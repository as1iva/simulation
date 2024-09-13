package core;

import actions.initActions.InitActions;
import actions.turnActions.MoveEntitiesAction;
import actions.turnActions.ReplantGrassAction;
import map.Map;
import map.MapRenderer;
import search.BreadthFirstSearch;

import java.util.*;

public class Simulation extends Thread {
    private final Map map = new Map();
    private final MapRenderer mapRenderer = new MapRenderer();
    private final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    private final InitActions initActions = new InitActions(map);
    private final MoveEntitiesAction moveEntitiesAction = new MoveEntitiesAction(map, breadthFirstSearch);
    private final ReplantGrassAction replantGrassAction = new ReplantGrassAction();
    private int turnsOfSimulation = 1;
    private boolean running = true;
    private boolean stopped = false;
    private final Scanner scanner = new Scanner(System.in);

    public void nextTurn() {
        int REPLANT_FREQUENCY = 5;
        System.out.println("\nХод: " + turnsOfSimulation);
        moveEntitiesAction.perform();

        if (turnsOfSimulation % REPLANT_FREQUENCY == 0) {
            replantGrassAction.perform(map);
        }

        mapRenderer.render(map);
        turnsOfSimulation++;
    }

    public void startSimulation() {
        initActions.printWelcomeMessage();
        initActions.getUserInput();
        initActions.setUpMap();

        this.start();
    }
    public void pauseSimulation() {
        while (running) {
            String input = scanner.nextLine();

            if (isInputValid(input)) {
                this.pause();
            } else {
                System.out.println("Неверный ввод. Введите [enter]");
            }
        }
    }

    public void run() {
        while (running && moveEntitiesAction.hasPath(map)) {
            if (!stopped) {
                nextTurn();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        running = false;
        System.out.println("\nСимуляция завершена");

        System.exit(0);
    }

    public void pause() {
        stopped = !stopped;

        if (stopped) {
            System.out.println("Симуляция приостановлена");
        } else {
            System.out.println("Симуляция возобновлена");
        }
    }

    private boolean isInputValid(String input) {
        return input.isEmpty();
    }
}
