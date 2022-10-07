package entities.documents;

import entities.interfaces.Storable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.UUID;

public abstract class Document implements Comparable<Document>, Storable, Cloneable{

    private UUID id;
    private String type;
    private String text;
    private Integer regNum;
    private LocalDate regDate;
    private transient String author;

    public Document(UUID id, String type, String text, Integer regNum, LocalDate regDate, String author) {
        this.id = id;
        this.type = type;
        this.text = text;
        this.regNum = regNum;
        this.regDate = regDate;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRegNum() {
        return regNum;
    }

    public void setRegNum(Integer regNum) {
        this.regNum = regNum;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Document document) {
        return Comparator
                .comparing(Document::getRegNum)
                .thenComparing(Document::getRegDate)
                .compare(this, document);
    }

    @Override
    public UUID getStorableID() {
        return getId();
    }

    @Override
    public void setStorageName() {}

    @Override
    public Document clone() throws CloneNotSupportedException {
        Document newDoc = (Document) super.clone();
        return newDoc;
    }
}
