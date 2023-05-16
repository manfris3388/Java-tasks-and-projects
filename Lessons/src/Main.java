import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Iveskite teksta");
    String text = sc.nextLine();
    System.out.println("Tekstas didziosiomis: " + text.toUpperCase());
    System.out.println("Teksto ilgis: " + text.length());
    int lastIndex = text.lastIndexOf(" ");
    String lastWord = text.substring(lastIndex);
    System.out.println("Paskutinis zodis: " + lastWord);
    System.out.println("Pakeisti visas raides a i w: " + text.replaceAll("a", "w"));
    System.out.println("Pakeisti e i RAIDE: " + text.replaceAll("e", "RAIDE"));
    System.out.println("Paskutinis zodis: " + text.substring(text.lastIndexOf(" ")));
    String [] words = text.split(" ");
    for (int i = words.length - 1; i >= 0; i-- ){
      System.out.print(words[i] + " ");
    }
  }
}
