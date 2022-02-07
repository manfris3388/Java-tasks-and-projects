package lt.codeacademy.exercise.menu.console;


import lt.codeacademy.exercise.menu.Menu;

import java.util.Scanner;
/**
 * Every console menu's should use this interface
 *
 * @author pavel.vrublevskij
 */
public interface ConsoleMenu extends Menu {
    Scanner scanner = new Scanner(System.in);

    /**
     * Method waits for user input and return @{@link String}
     *
     * @return String as input
     */
    default String readInput() {
        System.out.println("Your input: ");

        return scanner.nextLine();
    }

    default String printAndRead() {
        generateMenu();
        return readInput();
    }
}
