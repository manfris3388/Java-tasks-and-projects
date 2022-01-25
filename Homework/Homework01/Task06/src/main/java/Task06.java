import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite savo vardą");
        String text = scanner.next();
        System.out.println("labas " + text + " !");
        System.out.println("Įvskite skaičių");
        int number = scanner.nextInt();
        boolean isOdd = getOdd(number);
        if (isOdd){
            System.out.println("Jūs įvedėte nelyginį skaičių");
        }
        else {
            System.out.println("Jūs įvedėte lygynį skaičių");
        }
    }

    private static boolean getOdd(int number) {
        int mod = number % 2;
        return mod == 1;
    }
}
