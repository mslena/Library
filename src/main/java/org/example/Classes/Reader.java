package org.example.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.*;


@Entity
@Table(name = "Reader")
public class Reader {
    @Id
    private String libraryCardNumber;
    private int takenBooks;
    private String age, passportData;
    private String fullName;
    private String profession;
    private String gender;

    public Reader(String libraryCardNumber, String age, String passportData, String fullName, String profession, String gender) {
        this.libraryCardNumber = libraryCardNumber;
        this.age = age;
        this.passportData = passportData;
        this.fullName = fullName;
        this.profession = profession;
        this.gender = gender;
    }

    private String libraryEntryDates;

    public Reader(){}

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getTakenBooks() {
        return takenBooks;
    }

    public void setTakenBooks(int takenBooks) {
        this.takenBooks = takenBooks;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLibraryEntryDates() {
        return libraryEntryDates;
    }

    public void setLibraryEntryDates(String libraryEntryDates) {
        this.libraryEntryDates = libraryEntryDates;
    }
}
