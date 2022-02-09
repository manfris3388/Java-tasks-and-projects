package lt.codeacademy.exercise.interfaces;

import java.util.Arrays;
import java.util.stream.Stream;

public interface FormatMoney {
    default String[][] formatMoney(String[][] rawData, int amount) {
        Stream<String[]> rawDataStr = Arrays.stream(rawData).skip(1);
        rawDataStr.forEach(str -> str[amount] = formatDate(str, amount));
        return rawData;
    }

    private String formatDate(String[] str, int amount) {
        return str[amount].replace(",", ".");
    }
}
