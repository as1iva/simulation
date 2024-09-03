package actions;

import map.Map;

import java.util.Scanner;

public class InitActions {
    private final Scanner scanner = new Scanner(System.in);
    private final Map map;
    public InitActions(Map map) {
        this.map = map;
    }

    public void setUpMap() {
        map.setUpRandomEntityPosition();
    }

    public void printWelcomeMessage() {
        System.out.println("🪨🌱🌲🪨🌱🪨🌲🐮🌲🌱🪨🌱🪨🌲🐯🌲");
        System.out.println("Добро пожаловать в 2D симуляцию!\n");
        System.out.println("Для приостановки/возобновления рендеринга симуляции нажмите [enter]");
        System.out.println("Чтобы начать – нажмите [s]");
    }

    public void getUserInput() {
        String input = scanner.nextLine();

        while(!isInputValid(input)) {
            input = scanner.nextLine();
        }
    }

    private boolean isInputValid(String input) {
        if (!input.equals("s")) {
            System.out.println("Неверный ввод. Введите [s] для начала симуляции");
            return false;
        }
        return true;
    }
}
