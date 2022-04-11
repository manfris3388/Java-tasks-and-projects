package lt.codeacademy;

import lt.codeacademy.service.BudgetRun;
import lt.codeacademy.utils.HibernateUtil;
import org.hibernate.Session;

public class BudgetProgram {
  public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Menu.run();
    session.close();
  }

}
