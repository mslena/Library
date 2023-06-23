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

    @GetMapping("/home")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

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

    @GetMapping("/updateLogbook")
    public ModelAndView updateObject(@PathParam(value="ID_Taking") String ID_Taking, @PathParam(value="NameLibrarian") String NameLibrarian, @PathParam(value="FullName") String FullName, @PathParam(value="FK_ID_Book") String FK_ID_Book,@PathParam(value="DateOfTaking") String DateOfTaking, @PathParam(value="ReturnDate") String ReturnDate) {
        if (ID_Taking!= null)
        {
            logbookDAO.update(ID_Taking, NameLibrarian, FullName, FK_ID_Book, DateOfTaking, ReturnDate);
            return new ModelAndView("/logbook").addObject("Logbook", logbookDAO.getAll());
        }
        return new ModelAndView("/updateLogbook").addObject("Logbook", logbookDAO.getAll());
    }

    @GetMapping("/deleteLogbook")
    public ModelAndView deleteObject (@PathParam(value = "ID_Taking") String ID_Taking)
    {
        if (ID_Taking != null) {
            logbookDAO.delete(ID_Taking);
            return new ModelAndView("logbook").addObject("Logbook", logbookDAO.getAll());
        }
        return new ModelAndView("deleteLogbook").addObject("Logbook", logbookDAO.getAll());
    }
}
