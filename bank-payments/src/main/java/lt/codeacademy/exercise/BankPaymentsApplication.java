package lt.codeacademy.exercise;

import lt.codeacademy.exercise.bank.data.LumiData;
import lt.codeacademy.exercise.bank.data.SepData;
import lt.codeacademy.exercise.bank.data.ShvedData;
import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;
import lt.codeacademy.exercise.service.LumiService;
import lt.codeacademy.exercise.service.SepService;
import lt.codeacademy.exercise.service.ShvedService;

import java.util.Scanner;

public class BankPaymentsApplication {
  Scanner scanner = new Scanner(System.in);

  private final ConsoleMenu mainMenu;

  public BankPaymentsApplication() {
    this.mainMenu = new MainMenu();
  }

  public void run() {
    String selectedOption = mainMenu.printAndRead();
    // TODO: your implementation here
    String[][] dataRawLumi = LumiData.MOCK_DATA;
    String[][] dataRawSep = SepData.MOCK_DATA;
    String[][] dataRawShved = ShvedData.MOCK_DATA;
    menuChoice(selectedOption, dataRawLumi, dataRawSep, dataRawShved);
  }

  private void menuChoice(
      String selectedOption,
      String[][] dataRawLumi,
      String[][] dataRawSep,
      String[][] dataRawShved) {
    switch (selectedOption) {
      case "1":
        LumiService lumiService = new LumiService();
        lumiService.getFormatedData(dataRawLumi, 0, 0, 0, 0);
        break;
      case "2":
        SepService sepService = new SepService();
        dataRawSep = sepService.formatDate(dataRawSep, 0);
        sepService.getFormatedData(dataRawSep, 0, 0, 0, 0);
        break;
      case "3":
        ShvedService shvedService = new ShvedService();
        dataRawShved = shvedService.formatDate(dataRawShved, 0);
        dataRawShved = shvedService.formatMoney(dataRawShved, 2);
        shvedService.getFormatedData(dataRawShved, 0, 0, 0, 0);
        break;
      case "4":
        LumiService lumiService4 = new LumiService();
        SepService sepService4 = new SepService();
        ShvedService shvedService4 = new ShvedService();
        dataRawSep = sepService4.formatDate(dataRawSep, 0);
        dataRawShved = shvedService4.formatDate(dataRawShved, 0);
        dataRawShved = shvedService4.formatMoney(dataRawShved, 2);
        lumiService4.getFormatedData(dataRawLumi, 0, 0, 0, 0);
        sepService4.getFormatedData(dataRawSep, 0, 0, 0, 0);
        shvedService4.getFormatedData(dataRawShved, 0, 0, 0, 0);
        break;
      case "5":
        break;
      default:
        System.out.println("Wrong entry");
        break;
    }
  }
}
