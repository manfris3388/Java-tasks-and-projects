package lt.codeacademy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite minutes");
        int minutes = scanner.nextInt();
        convertToDaysYears(minutes);
    }

    private static void convertToDaysYears(int minutes) {
        double days = Math.floor(minutes/60/24);
        double years = Math.floor(days/365);
        days -= 365 * years;
        System.out.println("Įvestas kiekies minučių " + minutes + " sudaro " +
                + years + " metus ir " + days + " dienas.");
    }
}
