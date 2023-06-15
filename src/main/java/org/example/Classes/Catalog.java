package org.example.Classes;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ID_Catalog;
    private String Quantity;
    private String YearOfPublishing;

    public int getFK_ID_Book() {
        return FK_ID_Book;
    }

    public void setFK_ID_Book(int FK_ID_Book) {
        this.FK_ID_Book = FK_ID_Book;
    }

    private int FK_ID_Book;
    private String Name, Author, KeyWords;
    public Catalog(){}

    public String getID_Catalog() {
        return ID_Catalog;
    }

    public void setID_Catalog(String ID_Catalog) {
        this.ID_Catalog = ID_Catalog;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
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

    public String getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String keyWords) {
        KeyWords = keyWords;
    }

    public String getYearOfPublishing() {
        return YearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        YearOfPublishing = yearOfPublishing;
    }
}
