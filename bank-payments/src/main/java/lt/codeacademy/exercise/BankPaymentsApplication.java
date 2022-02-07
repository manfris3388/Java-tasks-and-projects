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
        //TODO: your implementation here
        LumiService lumiService = new LumiService();
        SepService sepService = new SepService();
        ShvedService shvedService = new ShvedService();
        String[][] dataRawLumi = LumiData.getMockData();
        String [][] dataRawSep = SepData.getMockData();
        String [][] dataRawShved = ShvedData.getMockData();
        lumiService.getFormatedData(dataRawLumi, 0, 0, 0, 0);
        sepService.getFormatedData(dataRawSep, 0, 0, 0, 0);
        shvedService.getFormatedData(dataRawShved, 0, 0, 0, 0);
    }
}
