import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static String[] texts = new String[0];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite tekstą");
        String text = scanner.nextLine();
        Boolean textAdded = addText(text);
        System.out.println("Tekstas pridėtas: " + textAdded);
    }

    private static boolean addText(String text) {
        String [] newArr = new String[texts.length+1];
        if (text instanceof String && text != null) {
            newArr[0] = text;
            for (int i = 0; i < texts.length; i++) {
                newArr[i + 1] = texts[i];
            }
            System.out.println(Arrays.toString(newArr));
            return true;
        }
        else {
            return false;
        }
    }
}
