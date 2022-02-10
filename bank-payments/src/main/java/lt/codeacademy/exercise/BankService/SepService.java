package lt.codeacademy.exercise.BankService;

import lt.codeacademy.exercise.bank.data.SepData;

public class SepService extends Service {

    String[][] dataRawSep = SepData.MOCK_DATA;

    public void run(){
        getFormatedData(dataRawSep, 0, 0, 0, 0);
    }

    @Override
    public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
        dataRawSep = formatDate(dataRawSep, 0);
        super.getFormatedData(rawData, 0, 3, 1, 2);
    }
}
