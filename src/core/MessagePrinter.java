package core;

import java.util.Scanner;

public class MessagePrinter {
    private final Scanner scanner = new Scanner(System.in);

    public void print() {
        System.out.println("🪨🌱🌲🪨🌱🪨🌲🐮🌲🌱🪨🌱🪨🌲🐯🌲");
        System.out.println("Добро пожаловать в 2D симуляцию!\n");
        System.out.println("Для приостановки/возобновления рендеринга симуляции нажмите [enter]");
        System.out.println("Чтобы начать – нажмите [s]");
    }
}
