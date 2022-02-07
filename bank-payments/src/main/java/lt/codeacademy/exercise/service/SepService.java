package lt.codeacademy.exercise.service;

public class SepService extends Service{
    @Override
    public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
        super.getFormatedData(rawData, 0, 3, 1, 2);
    }
}
