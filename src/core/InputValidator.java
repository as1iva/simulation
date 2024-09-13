package core;

import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);

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
