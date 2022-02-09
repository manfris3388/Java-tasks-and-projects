package lt.codeacademy.exercise.interfaces;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public interface DateFormating {


    default String[][] formatDate(String[][] rawData, int date) {
        Stream<String[]> rawDataStr = Arrays.stream(rawData).skip(1);
        rawDataStr.forEach(str -> str[date] = formatDate(str, date));
        return rawData;
    }

    private String formatDate(String[] str, int date) {
        String rawDate = str[date];
        String[] nums = rawDate.split(Pattern.quote("."));
        return "" + nums[2] + "-" + nums[1] + "-" + nums[0];
    }
}
