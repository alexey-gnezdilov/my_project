package controllers;

import controllers.subcontroller.SubController;
import entities.documents.Document;
import manager.Manager;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ShowController extends SubController {

    public void showAllDocumentsByAuthor() {

        List<Document> allDocuments = Manager.DOCUMENTS_REPO.getAllDocuments();
        isListEmpty = Manager.DOCUMENTS_REPO.isListEmpty();

        if (isListEmpty) {
            System.out.println("The list is empty!");
            Manager.DELAY.delay();
        } else {
            TreeSet<String> authorSet = allDocuments.stream().map(Document::getAuthor)
                    .collect(Collectors.toCollection(TreeSet::new));
            for (String author : authorSet) {
                System.out.println(" - " + author);
                allDocuments.stream()
                        .filter(doc -> doc.getAuthor().equals(author))
                        .forEach(doc -> System.out.println(" •" + doc));
                System.out.println();
            }
        }
    }
}
