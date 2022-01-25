import java.util.Scanner;
public class Task05 {
    public static void main(String[] args) {
        String [] months = {"sausis", "vasaris", "kovas", "balandis", "geguze", "birzelis", "liepa", "rugpjutis", "rugsejis", "spalis", "lapkritis", "gruodis"};
        System.out.println(months.length);
        System.out.println(months[0]);
        System.out.println(months[months.length -1]);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite skaičių nuo 1 iki 12");
        int choice = scanner.nextInt();
        System.out.println(months[choice-1]);
        if (choice >1 && choice < 12) {
            System.out.println(months[choice - 2] + " " + months[choice]);
        }
        else if (choice == 1){
            System.out.println(months[11] + " " + months[choice]);
        }
        else {
            System.out.println(months[choice -2 ] + " " + months[0]);
        }
    }
}
