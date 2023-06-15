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
}
