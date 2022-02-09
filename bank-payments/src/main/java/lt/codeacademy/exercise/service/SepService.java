package lt.codeacademy.exercise.service;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SepService extends Service {
    @Override
    public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
        super.getFormatedData(rawData, 0, 3, 1, 2);
    }

    public String[][] formatSepData(String[][] rawData) {
        Stream<String[]> rawDataStr = Arrays.stream(rawData).skip(1);
        rawDataStr.forEach(str -> str[0] = formatDate(str));
        return rawData;
    }

    private String formatDate(String[] str) {
        String rawDate = str[0];
        String[] nums = rawDate.split(Pattern.quote("."));
        return "" + nums[2] + "-" + nums[1] + "-" + nums[0];
    }
}
