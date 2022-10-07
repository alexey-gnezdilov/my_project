package controllers;

import controllers.subcontroller.SubController;
import manager.Manager;

public class StartUpController extends SubController {

    private static final String MAIN = "\n" +
            "Welcome to the Document Managment System (DMS).\n" +
            "Please, choose an option (input a number, then press Enter)\n" +
            "1 - Create\n" +
            "2 - Find\n" +
            "3 - Remove\n" +
            "4 - Edit\n" +
            "5 - Show all documents by athor\n" +
            "6 - Create reports on all authors\n" +
            "7 - Exit\n\n";

    private static final String INVALID_INPUT = "\nInvalid input. Please, input a number from 1 to 6, " +
            "then press \"Enter\"\n";

    public void showMainController() {
        do {
            showInputMenu(MAIN);
            switch (selection) {
                case "1":
                    Manager.CREATE_CONTROLLER.showDocCreateController();
                    break;
                case "2":
                    Manager.FIND_CONTROLLER.findDocument();
                    break;
                case "3":
                    Manager.DELETE_CONTROLLER.deleteDocument();
                    break;
                case "4":
                    Manager.EDIT_CONTROLLER.editDocument();
                    break;
                case "5":
                    Manager.SHOW_CONTROLLER.showAllDocumentsByAuthor();
                    break;
                case "6":
                    Manager.AUTHORS_REPORT.createReports();
                    break;
                case "7":
                    System.out.println("======Good Bye======");
                    break;
                default:
                    System.out.println(INVALID_INPUT);
                    Manager.DELAY.delay();
            }
        } while (!selection.equals("7"));
    }
}
