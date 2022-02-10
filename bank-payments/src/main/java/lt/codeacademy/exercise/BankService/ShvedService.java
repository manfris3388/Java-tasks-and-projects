package lt.codeacademy.exercise.BankService;

import lt.codeacademy.exercise.bank.data.ShvedData;

public class ShvedService extends Service {

  String[][] dataRawShved = ShvedData.MOCK_DATA;

  public void run(){
    getFormatedData(dataRawShved, 0, 0, 0, 0);
  }
  @Override
  public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
    dataRawShved = formatDate(dataRawShved, 0);
    dataRawShved = formatMoney(dataRawShved, 2);
    super.getFormatedData(rawData, 0, 2, -1, 1);
  }
}
