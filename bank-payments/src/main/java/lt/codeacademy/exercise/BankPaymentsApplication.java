package lt.codeacademy.exercise;

import lt.codeacademy.exercise.menu.console.ConsoleMenu;
import lt.codeacademy.exercise.menu.console.MainMenu;
import lt.codeacademy.exercise.BankService.LumiService;
import lt.codeacademy.exercise.BankService.SepService;
import lt.codeacademy.exercise.BankService.ShvedService;

public class BankPaymentsApplication {

  private final ConsoleMenu mainMenu;

  public BankPaymentsApplication() {
    this.mainMenu = new MainMenu();
  }

  public void run() {
    String selectedOption = mainMenu.printAndRead();
    // TODO: your implementation here
    switch(selectedOption){
      case "1" -> new LumiService().run();
      case "2" -> new SepService().run();
      case "3" -> new ShvedService().run();
      case "4" -> runAll();
      case "0" -> System.exit(0);
      default -> System.out.println("Wrong entry");
    }
  }

  public void runAll(){
    new LumiService().run();
    new SepService().run();
    new ShvedService().run();
  }
}
