package controllers.subcontroller;

import manager.Manager;
import java.util.Scanner;

public class SubController {

    public String selection;
    public String regNum;
    public Scanner sc = new Scanner(System.in);
    public boolean isListEmpty;

    public void inputRegNum() {
        boolean isNumber;
        do {
            System.out.print("\nInput a registration number:");
            regNum = sc.nextLine();
            isNumber = Manager.IS_NUMERIC.isNumeric(regNum);
        } while (!isNumber);
    }

    public void showInputMenu(String menu) {
        System.out.println(menu);
        System.out.print("Your choice: ");
        selection = new Scanner(System.in).nextLine();
    }
}
