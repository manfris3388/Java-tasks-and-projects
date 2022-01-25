package lt.codeacademy;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        System.out.println("Įveskkite 5 skaičius");
        for (int i = 0; i < 5; i++) {
            int j = scanner.nextInt();
            result += j;
        }
        System.out.println(result);
    }
}
