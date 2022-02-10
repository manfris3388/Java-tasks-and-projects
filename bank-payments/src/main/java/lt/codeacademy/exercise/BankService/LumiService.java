package lt.codeacademy.exercise.BankService;

import lt.codeacademy.exercise.bank.data.LumiData;

public class LumiService extends Service{

  private final String[][] dataRawLumi = LumiData.MOCK_DATA;

  public void run(){
    getFormatedData(dataRawLumi, 0, 0, 0, 0);
  }

  @Override
  public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
    super.getFormatedData(rawData, 1, 3, 0, 2);
  }
}
