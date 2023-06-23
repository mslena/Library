package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.DAO.BookConditionDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BookConditionController {
private final BookConditionDAO bookConditionDAO;

    @GetMapping("/condition")
    public ModelAndView getConditionToID(@PathParam(value="Name") String Name) {
        if (Name == null) {
            return new ModelAndView("condition").addObject("Condition", bookConditionDAO.getAll());
        }
        else{
            return  new ModelAndView("condition").addObject("Condition", bookConditionDAO.getBookToCondition(Name));
        }
    }

    @GetMapping("/addCondition")
    public ModelAndView setAll(@PathParam(value="Author") String Author, @PathParam(value="Name") String Name, @PathParam(value="ID_Condition") String ID_Condition, @PathParam(value="FK_ID_Book") String FK_ID_Book, @PathParam(value="Condition") String Condition, @PathParam(value="StatusOfRecordDate") String StatusRecordDate) {
        if (Name != null) {
            bookConditionDAO.setAll(Author, Name, ID_Condition, FK_ID_Book, Condition, StatusRecordDate);
            return new ModelAndView("condition").addObject("Condition", bookConditionDAO.getAll());
        }
        return new ModelAndView("addCondition");
    }

    @GetMapping("/updateCondition")
    public ModelAndView update (@PathParam(value="ID_Condition") String ID_Condition, @PathParam(value="Condition")  String Condition, @PathParam(value="StatusRecordDate")  String StatusRecordDate) {
        if (ID_Condition != null) {
            bookConditionDAO.update(ID_Condition, Condition, StatusRecordDate);
            return new ModelAndView("condition").addObject("Condition", bookConditionDAO.getAll());
        }
        return new ModelAndView("updateCondition").addObject("Condition", bookConditionDAO.getAll());
    }

    @GetMapping("/deleteCondition")
    public ModelAndView delete (@PathParam(value = "ID_Condition") String ID_Condition) {
        if (ID_Condition != null) {
            bookConditionDAO.delete(ID_Condition);
            return new ModelAndView("condition").addObject("Condition", bookConditionDAO.getAll());
        }
        return new ModelAndView("deleteCondition").addObject("Condition", bookConditionDAO.getAll());
    }
}
