package lt.codeacademy.exercise.service;

public class Service {
  public void getFormatedData(String[][] rawData, int date, int amount, int client, int account) {
    int i = 0;
    String newLine = "";
    for (String[] line : rawData) {
      String clientString = isClientNull(client, line);
      if (i > 0) {
        newLine =
            String.format(
                "\u2551 %7s \u2503 %15s \u2503 %10s \u2503 %30s \u2503 %30s\u2551",
                i, line[date], line[amount], clientString, line[account]);
        System.out.println(newLine);
        i++;
      } else {
        newLine =
            String.format(
                "%8s \u2503 %15s \u2503 %10s \u2503 %30s \u2503 %30s",
                "Eil. Nr.", "Data", "Suma", "Mokėtojas", "Sąskaitos Nr.");
        System.out.println("\u2554" + "\u2550".repeat(newLine.length()) + "\u2557");
        System.out.println("\u2551" + newLine + "\u2551");
        i++;
      }
    }
    System.out.println("\u255A" + "\u2550".repeat(newLine.length() - 2) + "\u255D");
  }

  private String isClientNull(int client, String[] line) {
    String clientString;
    if (client == -1) {
       clientString = "nenurodytas";
    }
    else {
      clientString = line[client];
    }
    return clientString;
  }
}
