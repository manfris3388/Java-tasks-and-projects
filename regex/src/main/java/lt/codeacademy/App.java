package lt.codeacademy;

public class App {


    public static void main(String[] args) {
         String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis\n" +
                "nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu\n" +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in\n" +
                "culpa qui officia deserunt mollit anim id est laborum.";
         text = text.replaceAll("[Ll]", "******");
         text = text.replaceAll("\\s", "\n");
        System.out.println(text);
    }
    //Visus žodžius, kurie prasideda raide L arba l pakeiskite tekstu ******.
    // Pakeiskit tekstą taip, kad jį atspausdinus kiekvienoje eilutėje būtų tik vienas žodis.

}
