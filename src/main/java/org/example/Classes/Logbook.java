package org.example.Classes;

public class Logbook {
    private String ID_Taking;
    private String FK_ID_Librarian;
    private String FK_ID_Catalog;

    public String getID_Taking() {
        return ID_Taking;
    }

    public void setID_Taking(String ID_Taking) {
        this.ID_Taking = ID_Taking;
    }

    public String getFK_ID_Librarian() {
        return FK_ID_Librarian;
    }

    public void setFK_ID_Librarian(String FK_ID_Librarian) {
        this.FK_ID_Librarian = FK_ID_Librarian;
    }

    public String getFK_ID_Catalog() {
        return FK_ID_Catalog;
    }

    public void setFK_ID_Catalog(String FK_ID_Catalog) {
        this.FK_ID_Catalog = FK_ID_Catalog;
    }

    public String getFK_ID_Book() {
        return FK_ID_Book;
    }

    public void setFK_ID_Book(String FK_ID_Book) {
        this.FK_ID_Book = FK_ID_Book;
    }

    public String getFK_ID_Branch() {
        return FK_ID_Branch;
    }

    public void setFK_ID_Branch(String FK_ID_Branch) {
        this.FK_ID_Branch = FK_ID_Branch;
    }

    public String getFK_LibraryCardNumber() {
        return FK_LibraryCardNumber;
    }

    public void setFK_LibraryCardNumber(String FK_LibraryCardNumber) {
        this.FK_LibraryCardNumber = FK_LibraryCardNumber;
    }

    private String FK_ID_Book;
    private String FK_ID_Branch;
    private String FK_LibraryCardNumber;
    private String ReturnDate;
    private String DateOfTaking;
    private String FullName;
    private String Name;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    private String Author;


    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public String getDateOfTaking() {
        return DateOfTaking;
    }

    public void setDateOfTaking(String dateOfTaking) {
        DateOfTaking = dateOfTaking;
    }
}
