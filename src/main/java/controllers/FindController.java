package controllers;

import controllers.subcontroller.SubController;
import entities.documents.Document;
import manager.Manager;

public class FindController extends SubController {

    public void findDocument() {
        isListEmpty = Manager.DOCUMENTS_REPO.isListEmpty();
        if (!isListEmpty) {
            inputRegNum();
            Document tempDoc = Manager.DOCUMENTS_REPO.getDocument(Integer.parseInt(regNum));
            if (tempDoc != null) {
                System.out.println(tempDoc);;
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
