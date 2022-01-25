import java.util.Arrays;

public class Task07 {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String [] words = getArrayToString(numbers);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static String[] getArrayToString(int[] numbers) {
        String [] words = new String[numbers.length];
        for (int i = 0; i < numbers.length ; i++) {
            words[i] = "a" + "" + numbers[i];
        }
        return words;
    }
}
