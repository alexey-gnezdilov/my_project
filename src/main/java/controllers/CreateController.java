package controllers;

import controllers.subcontroller.SubController;
import entities.documents.Document;
import entities.documents.Incoming;
import entities.documents.Outgoing;
import entities.documents.Task;
import exception.DocumentExistException;
import manager.Manager;
import org.apache.commons.lang3.RandomUtils;

public class CreateController extends SubController {

    public static final String MENU_OF_CREATING = "\n" +
            "Create a document.\n" +
            "Please, choose an option (input a number, then press \"Enter\")\n" +
            "1 - Create a single document.\n" +
            "2 - Create 100 random documents (for the Report demonstration)\n" +
            "3 - Back\n";

    public static final String INVALID_INPUT = "\nInvalid input. Please, input a number from 1 to 3 without any spaces, " +
            "then press \"Enter\"\n";

    public static final String MENU_OF_TYPES = "\nWhat type of document do you want to create?\n" +
            "1 - Task\n" +
            "2 - Incoming\n" +
            "3 - Outgoing\n" +
            "4 - Back\n";

    public static final String NO_SUCH_TYPE = "\nThere's no such type of document.\n";

    private static final String CREATED = "\nA document has been created.\n";

    public void showDocCreateController() {
        do {
            showInputMenu(MENU_OF_CREATING);
            switch (selection) {
                case "1":
                    showSingleDocController();
                    break;
                case "2":
                {
                    for (int i = 1; i <= 100; i++) {
                        selection = String.valueOf(RandomUtils.nextInt(1,4));
                        try {
                            if (createAndCheckSingleDocument(selection)) {
                                throw new DocumentExistException();
                            } else {
                                System.out.println(CREATED);
                            }
                        } catch (DocumentExistException e) {}
                    }
                    selection = "0";
                }
                    break;
                case "3":
                    break;
                default:
                    System.out.println(INVALID_INPUT);
                    Manager.DELAY.delay();
            }
        } while (!selection.equals("3"));
    }

    public void showSingleDocController() {
        do {
            showInputMenu(MENU_OF_TYPES);
            switch (selection) {
                case "1":
                case "2":
                case "3": {
                    try {
                        if (createAndCheckSingleDocument(selection)) {
                            throw new DocumentExistException();
                        } else {
                            System.out.println(CREATED);
                            Manager.DELAY.delay();
                        }
                    } catch (DocumentExistException e) {
                        Manager.DELAY.delay();
                    }
                }
                case "4":
                    break;
                default:
                    System.out.println(NO_SUCH_TYPE);
                    Manager.DELAY.delay();
            }
        } while (!selection.equals("4"));
    }

    public boolean createAndCheckSingleDocument(String selection) {

        Document tempDoc = null;

        switch (selection) {
            case "1":
                tempDoc = Manager.DOCUMENT_FACTORY.generateDocument(Task.class);
                break;
            case "2":
                tempDoc = Manager.DOCUMENT_FACTORY.generateDocument(Incoming.class);
                break;
            case "3":
                tempDoc = Manager.DOCUMENT_FACTORY.generateDocument(Outgoing.class);
                break;
        }

        if (Manager.DOCUMENTS_REPO.getDocument(tempDoc.getRegNum()) == null) {
            Manager.DOCUMENTS_REPO.addDocument(tempDoc);
            return false;
        } else {
            return true;
        }
    }
}
