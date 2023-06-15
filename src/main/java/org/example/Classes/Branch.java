package org.example.Classes;

public class Branch {
    private String ID_Branch;
    private String NominalNumberOfBook;

    public String getID_Branch() {
        return ID_Branch;
    }

    public void setID_Branch(String ID_Branch) {
        this.ID_Branch = ID_Branch;
    }

    public String getNominalNumberOfBook() {
        return NominalNumberOfBook;
    }

    public void setNominalNumberOfBook(String nominalNumberOfBook) {
        NominalNumberOfBook = nominalNumberOfBook;
    }

    public String getActualNumberOfBook() {
        return ActualNumberOfBook;
    }

    public void setActualNumberOfBook(String actualNumberOfBook) {
        ActualNumberOfBook = actualNumberOfBook;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    private String ActualNumberOfBook;
    private String Address;
}
