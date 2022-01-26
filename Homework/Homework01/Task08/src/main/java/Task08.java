import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task08 {
    public static List<Integer> digits = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite žodį ar sakinį");
        String text = scanner.nextLine().toUpperCase();
        printNumbers(text);
    }

    private static void printNumbers(String text) {
        int digit;
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case 'A' -> digit = 2;
                case 'B' -> digit = 22;
                case 'C' -> digit = 222;
                case 'D' -> digit = 3;
                case 'E' -> digit = 33;
                case 'F' -> digit = 333;
                case 'G' -> digit = 4;
                case 'H' -> digit = 44;
                case 'I' -> digit = 444;
                case 'J' -> digit = 5;
                case 'K' -> digit = 55;
                case 'L' -> digit = 555;
                case 'M' -> digit = 6;
                case 'N' -> digit = 66;
                case 'O' -> digit = 666;
                case 'P' -> digit = 7;
                case 'Q' -> digit = 77;
                case 'R' -> digit = 777;
                case 'S' -> digit = 7777;
                case 'T' -> digit = 8;
                case 'U' -> digit = 88;
                case 'V' -> digit = 888;
                case 'W' -> digit = 9;
                case 'X' -> digit = 99;
                case 'Y' -> digit = 999;
                case 'Z' -> digit = 9999;
                default -> {
                    System.out.println("Neteisinga įvestis");
                    digit = 0;
                }
            }
            digits.add(digit);
        }
        System.out.println(digits);
    }
}
