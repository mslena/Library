package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.DAO.BranchDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BranchController {
    private final BranchDAO branchDAO;

    @GetMapping("/branch")
    public ModelAndView getAll() {
        return new ModelAndView("branch").addObject("Branch", branchDAO.getAll());
    }

    @GetMapping("/addBranch")
    public ModelAndView setAll(@PathParam(value="Address") String Address, @PathParam(value="NominalNumberOfBooks") String NominalNumberOfBooks, @PathParam(value="ActualNumberOfBooks") String ActualNumberOfBooks) {
        if (Address != null){
            branchDAO.setAll(Address, NominalNumberOfBooks, ActualNumberOfBooks);
            return new ModelAndView("/branch").addObject("Branch", branchDAO.getAll());
        }
        return new ModelAndView("/addBranch");
    }
}
