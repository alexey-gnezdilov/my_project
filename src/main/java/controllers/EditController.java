package controllers;

import controllers.subcontroller.SubController;
import entities.documents.Document;
import manager.Manager;

public class EditController extends SubController {

    private String author;

    public void editDocument() {
        isListEmpty = Manager.DOCUMENTS_REPO.isListEmpty();
        Document previousDoc;
        if (!isListEmpty) {
            inputRegNum();
            try {
                previousDoc = Manager.DOCUMENTS_REPO.getDocument(Integer.parseInt(regNum)).clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            inputNewAuthor();
            Manager.DOCUMENTS_REPO.editDocumentAuthor(Integer.parseInt(regNum), author);
            System.out.println("The document has been changed successfully.\n");
            System.out.println("Before: " + previousDoc + " " + previousDoc.getAuthor() + "\n");
            showDocumentAfterEditing(Manager.DOCUMENTS_REPO.getDocument(Integer.parseInt(regNum)));
            Manager.DELAY.delay();

        } else {
            System.out.println("The list is empty.");
            Manager.DELAY.delay();
        }
    }

    private void inputNewAuthor() {
        boolean doesAuthorExist;
        String regFIO = "^\\p{Lu}\\p{Ll}+\\s\\p{Lu}\\p{Ll}+\\s\\p{Lu}\\p{Ll}+$";
        do {
            System.out.print("\nInput a new author:");
            author = sc.nextLine();
            doesAuthorExist = author.matches(regFIO) && Manager.PERSONS_REPO.getAuthor(author) != null;
            if (!doesAuthorExist){
                System.out.println("The author doesn't exist!");
                Manager.DELAY.delay();
            }
        } while (!doesAuthorExist);
    }

    private void showDocumentAfterEditing(Document document) {
        System.out.println("After: " + document + " " + document.getAuthor());
    }
}
