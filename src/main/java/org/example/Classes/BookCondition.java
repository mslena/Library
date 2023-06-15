package org.example.Classes;

public class BookCondition {
    private String ID_Condition, FK_ID_Book, FK_ID_Catalog, FK_ID_Branch;

    public String getID_Condition() {
        return ID_Condition;
    }

    public void setID_Condition(String ID_Condition) {
        this.ID_Condition = ID_Condition;
    }

    public String getFK_ID_Book() {
        return FK_ID_Book;
    }

    public void setFK_ID_Book(String FK_ID_Book) {
        this.FK_ID_Book = FK_ID_Book;
    }

    public String getFK_ID_Catalog() {
        return FK_ID_Catalog;
    }

    public void setFK_ID_Catalog(String FK_ID_Catalog) {
        this.FK_ID_Catalog = FK_ID_Catalog;
    }

    public String getFK_ID_Branch() {
        return FK_ID_Branch;
    }

    public void setFK_ID_Branch(String FK_ID_Branch) {
        this.FK_ID_Branch = FK_ID_Branch;
    }

    private String Condition;

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getStatusRecordDate() {
        return StatusRecordDate;
    }

    public void setStatusRecordDate(String statusRecordDate) {
        StatusRecordDate = statusRecordDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String StatusRecordDate;
    private String Author, Name;

}
