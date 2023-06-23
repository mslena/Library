package org.example.Controller;

import jakarta.websocket.server.PathParam;
import org.example.Classes.Reader;
import org.example.DAO.ReaderDAO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ReaderController {

    private final ReaderDAO readerDAO;

    public ReaderController(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }

    @GetMapping("/reader")
    public ModelAndView getAll() {
        return new ModelAndView("reader").addObject("Reader", readerDAO.getAll());
    }

    @GetMapping("/reader")
    public ModelAndView getReaderToCriteria(@PathParam (value = "Profession") String Profession, @PathParam (value = "Age") String Age, @PathParam (value = "Gender") String Gender) {
        return new ModelAndView("reader").addObject("Reader", readerDAO.getReaderToAgeGenderProfession(Profession, Age, Gender));
    }

    @GetMapping("/reader")
    public ModelAndView getReaderWhoLateBook(@PathParam(value="Param") String Param) {
        return new ModelAndView("reader").addObject("Reader", readerDAO.getReaderWhoLater());
    }

    @GetMapping("/addReader")
    public ModelAndView setAll(@PathParam(value="fullName") String fullName, @PathParam(value="passportData") String passportData, @PathParam(value="gender")String gender, @PathParam(value="profession") String profession,@PathParam(value="age") String age) {
        if(fullName != null){
            readerDAO.setAll(fullName, passportData, gender, profession, age);
            return new ModelAndView("/reader").addObject("Reader", readerDAO.getAll());
        }
        return new ModelAndView("addReader");
    }

    @GetMapping("/updateReader")
    public ModelAndView updateObject(@PathParam(value="libraryCardNumber") String libraryCardNumber, @PathParam(value="fullName") String fullName, @PathParam(value="gender") String gender, @PathParam(value="age") String age, @PathParam(value="passportData") String passportData, @PathParam(value="profession") String profession, @PathParam(value = "takenBooks") String takenBooks, @PathParam(value = "libraryEntryDates") String libraryEntryDates) {
        if (libraryCardNumber != null) {
            readerDAO.update(libraryCardNumber, fullName, gender, age, passportData, profession, takenBooks, libraryEntryDates);
            return new ModelAndView("/reader").addObject("Reader", readerDAO.getAll());
        }
        return new ModelAndView("updateReader").addObject("Reader", readerDAO.getAll());
    }

    @GetMapping("/deleteReader")
    public ModelAndView deleteObject (@PathParam(value = "LibraryCardNumber") String LibraryCardNumber)
    {
        if (LibraryCardNumber != null) {
            readerDAO.delete(LibraryCardNumber);
            return new ModelAndView("reader").addObject("Reader", readerDAO.getAll());
        }
        return new ModelAndView("deleteReader").addObject("Reader", readerDAO.getAll());
    }
}
