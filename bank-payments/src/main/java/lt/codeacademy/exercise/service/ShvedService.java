package lt.codeacademy.exercise.service;

public class ShvedService extends Service {
  @Override
  public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
    super.getFormatedData(rawData, 0, 2, -1, 1);
  }
}
