package lt.codeacademy.exercise.service;

public class LumiService extends Service{
  @Override
  public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
    super.getFormatedData(rawData, 1, 3, 0, 2);
  }
}
