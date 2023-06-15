package org.example.Controller;

import jakarta.jws.WebParam;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.DAO.LibrarianDAO;
import org.example.Mapper.LibrarianMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
public class LibrarianController {
    private final LibrarianDAO librarianDAO;

    @GetMapping("/librarian")
    public ModelAndView getAll() {
        return new ModelAndView("librarian").addObject("Librarian", librarianDAO.getAll());
    }

    @GetMapping("/addLibrarian")
    public ModelAndView setAll(@PathParam(value="fullName") String fullName) {
        if(fullName != null) {
            librarianDAO.setAll(fullName);
            return new ModelAndView("/librarian").addObject("Librarian", librarianDAO.getAll());
        }
        return new ModelAndView("/addLibrarian");
    }
}
