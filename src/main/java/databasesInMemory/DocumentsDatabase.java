package databasesInMemory;

import entities.documents.Document;
import java.util.ArrayList;

public class DocumentsDatabase {
    private final ArrayList<Document> docList;

    public DocumentsDatabase() {docList = new ArrayList<>();}

    public ArrayList<Document> getDocList() {
        return docList;
    }
}
