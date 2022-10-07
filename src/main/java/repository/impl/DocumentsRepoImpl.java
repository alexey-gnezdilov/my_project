package repository.impl;

import databasesInMemory.DocumentsDatabase;
import entities.documents.Document;
import repository.DocumentsRepo;
import java.util.ArrayList;

public class DocumentsRepoImpl implements DocumentsRepo {

    private final DocumentsDatabase documentsDatabase;

    public DocumentsRepoImpl() {
        documentsDatabase = new DocumentsDatabase();
    }

    @Override
    public ArrayList<Document> getAllDocuments() {
        return documentsDatabase.getDocList();
    }

    @Override
    public void addDocument(Document document) { getAllDocuments().add(document); }

    @Override
    public boolean removeDocument(Integer regNum) {return getAllDocuments().removeIf(doc -> doc.getRegNum().equals(regNum));}

    @Override
    public void editDocumentAuthor(Integer regNum, String author) {getDocument(regNum).setAuthor(author);}

    @Override
    public boolean isListEmpty() {
        return getAllDocuments().isEmpty();
    }

    @Override
    public Document getDocument(Integer regNum) {
        return getAllDocuments().stream()
                .filter(doc -> doc.getRegNum().equals(regNum))
                .findAny()
                .orElse(null);
    }
}
