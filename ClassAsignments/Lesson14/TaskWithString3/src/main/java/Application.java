import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static String[] texts = new String[0];
    public static String[] newArr;
    public static Boolean textAdded;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite tekstą, spauskit q pabaigti");
        while (true) {
            String text = scanner.nextLine();
            if(text.equals("q")) break;
            textAdded = addText(text);
        }
        System.out.println("Naujas masyvas" + Arrays.toString(texts));
        scanner.close();
    }

    private static boolean addText(String text) {
        newArr = new String[texts.length+1];
        if (text != null) {
            newArr[0] = text;
            for (int i = 0; i < texts.length; i++) {
                newArr[i + 1] = texts[i];
            }
            System.out.println(Arrays.toString(newArr));
            texts = newArr;
            return true;
        }
        else {
            return false;
        }
    }
}
