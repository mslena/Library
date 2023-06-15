package org.example.Classes;

public class InstanceBook {
    private String ID_Book;
    private String FK_ID_Catalog;
    private String FK_ID_Branch;

    public String getYearOfPublishing() {
        return YearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        YearOfPublishing = yearOfPublishing;
    }

    private String YearOfPublishing;
    private String RackCoordinate;
    private String WriteOfDate;
    private String RoomNumber;
    private String Author;
    private String Name;

    public String getKeyWords() {
        return KeyWords;
    }

    public void setKeyWords(String keyWords) {
        KeyWords = keyWords;
    }

    private String KeyWords;

    public String getID_Book() {
        return ID_Book;
    }

    public void setID_Book(String ID_Book) {
        this.ID_Book = ID_Book;
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

    public String getRackCoordinate() {
        return RackCoordinate;
    }

    public void setRackCoordinate(String rackCoordinate) {
        RackCoordinate = rackCoordinate;
    }

    public String getWriteOfDate() {
        return WriteOfDate;
    }

    public void setWriteOfDate(String writeOfDate) {
        WriteOfDate = writeOfDate;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
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
}
