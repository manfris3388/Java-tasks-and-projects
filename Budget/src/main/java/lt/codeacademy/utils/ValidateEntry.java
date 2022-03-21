package lt.codeacademy.utils;

import lt.codeacademy.Menu;

public class ValidateEntry {
    public static Double validateEntry(String input){
        try{
            return Double.parseDouble(input);
        }catch (Exception exception){
            exception.printStackTrace();
            Menu.run();
        } return -1D;
    }
}
