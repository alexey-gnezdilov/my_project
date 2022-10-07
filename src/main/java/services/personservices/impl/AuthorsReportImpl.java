package services.personservices.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.documents.Document;
import manager.Manager;
import services.personservices.AuthorsReport;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AuthorsReportImpl implements AuthorsReport {
    @Override
    public void createReports() {
        if (Manager.DOCUMENTS_REPO.isListEmpty()) {
            System.out.println("The list is empty!");
            Manager.DELAY.delay();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            List<Document> allDocuments = Manager.DOCUMENTS_REPO.getAllDocuments();
            TreeSet<String> authorSet = allDocuments
                    .stream()
                    .map(Document::getAuthor)
                    .collect(Collectors.toCollection(TreeSet::new));

            for (String author : authorSet) {
                String file = "src/reports/" + author;
                try (FileWriter fw = new FileWriter(file)) {
                    allDocuments
                            .stream()
                            .filter(doc -> doc.getAuthor().equals(author))
                            .forEach(doc -> gson.toJson(doc, fw));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
