package repository;

import entities.documents.Document;

import java.util.ArrayList;

public interface DocumentsRepo {
    ArrayList<Document> getAllDocuments();
    void addDocument(Document document);
    boolean removeDocument(Integer regNum);
    void editDocumentAuthor(Integer regNum, String author);
    boolean isListEmpty();
    Document getDocument(Integer regNum);
}
