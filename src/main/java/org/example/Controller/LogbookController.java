package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.DAO.LogbookDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class LogbookController {
    private final LogbookDAO logbookDAO;

    @GetMapping("/logbook")
    public ModelAndView getAll(@PathParam(value="Param") String Param) {
        return new ModelAndView("logbook").addObject("Logbook", logbookDAO.getAll());
    }

    @GetMapping("/addLogbook")
    public ModelAndView setAll(@PathParam(value="DateOfTaking")String DateOfTaking, @PathParam(value="FullName") String FullName, @PathParam(value="NameLibrarian") String NameLibrarian, @PathParam(value="ID_Book") String ID_Book, @PathParam(value="Address") String Address) {
        if (DateOfTaking!= null)
        {
            logbookDAO.setAll(DateOfTaking, FullName, NameLibrarian, ID_Book, Address);
            return new ModelAndView("/logbook").addObject("Logbook", logbookDAO.getAll());
        }
        return new ModelAndView("/addLogbook");
    }

}
