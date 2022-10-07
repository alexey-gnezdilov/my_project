package controllers;

import controllers.subcontroller.SubController;
import manager.Manager;

public class DeleteController extends SubController {

    public void deleteDocument() {
        isListEmpty = Manager.DOCUMENTS_REPO.isListEmpty();
        if (!isListEmpty) {
            inputRegNum();
            if (Manager.DOCUMENTS_REPO.removeDocument(Integer.parseInt(regNum))) {
                System.out.println("The document has been deleted successfully.");
                Manager.DELAY.delay();
            } else {
                System.out.println("The document doesn't exist.");
                Manager.DELAY.delay();
            }
        } else {
            System.out.println("The list is empty.");
            Manager.DELAY.delay();
        }
    }
}
