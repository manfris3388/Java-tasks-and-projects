import java.util.Locale;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite sakinį");
        String t = scanner.nextLine();
        System.out.println(t.toUpperCase());
        System.out.println(t.length());
        int lastIndex = t.lastIndexOf(" ");
        System.out.println(t.substring(lastIndex));
        System.out.println(t.replaceAll("a", "W"));
        System.out.println(t.replaceAll("e", "RAIDE"));
        String firstWord = t.substring(0, t.indexOf(" "));
        String lastWord = t.substring(lastIndex);
        String remainingText = t.substring(t.indexOf(" "), t.lastIndexOf(" "));
        System.out.println(lastWord + remainingText + firstWord);
    }
}
