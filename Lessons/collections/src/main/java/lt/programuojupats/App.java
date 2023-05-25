package lt.programuojupats;

import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> kolekcija = new ArrayList<>();
        kolekcija.add("Vienas");
        kolekcija.add("Du");
        Iterator<String> iterator = kolekcija.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
