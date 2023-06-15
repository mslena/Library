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
    public ModelAndView getReader(@PathParam(value="Param") String Param,@PathParam (value = "Profession") String Profession, @PathParam (value = "Age") String Age, @PathParam (value = "Gender") String Gender) {

        if (Param == null){
            if(Profession == null){
                return new ModelAndView("reader").addObject("Reader", readerDAO.getAll());
            }
            else{
             return new ModelAndView("reader").addObject("Reader", readerDAO.getReaderToAgeGenderProfession(Profession, Age, Gender));
            }
        }
        else{
            return new ModelAndView("reader").addObject("Reader", readerDAO.getReaderWhoLater());
        }
    }

    @GetMapping("/ReaderAutorization")
    public ModelAndView setAll(@PathParam(value="fullName") String fullName, @PathParam(value="passportData") String passportData, @PathParam(value="gender")String gender, @PathParam(value="profession") String profession,@PathParam(value="age") String age) {
        if(fullName != null){
            readerDAO.setAll(fullName, passportData, gender, profession, age);
            return new ModelAndView("/reader").addObject("Reader", readerDAO.getAll());
        }
        return new ModelAndView("ReaderAutorization");
    }

}
