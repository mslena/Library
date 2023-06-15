package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.DAO.InstanceBookDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class InstanceBookController {
    private final InstanceBookDAO instanceBookDAO;

    @GetMapping("/book")
    public ModelAndView getBookToBranch(@PathParam(value="Address") String Address, @PathParam(value="Author") String Author, @PathParam(value="Name") String Name, @PathParam(value="YearOfPublishing") String YearOfPublishing, @PathParam(value="KeyWords") String KeyWords) {
        if (Author == null)
        {
            if (Address == null)
            {
                return new ModelAndView("book").addObject("Book", instanceBookDAO.getAll());
            }
            else {
                return new ModelAndView("book").addObject("Book", instanceBookDAO.getBookToBranch(Address));
            }
        }
         else {
            return new ModelAndView("book").addObject("Book", instanceBookDAO.getBookToCriteria(Author, Name, YearOfPublishing, KeyWords));
        }
    }

    @GetMapping("/addBook")
    public ModelAndView setAll(@PathParam(value="Author") String Author, @PathParam(value="Name") String Name, @PathParam(value="Address") String Address, @PathParam(value="RoomNumber") String RoomNumber, @PathParam(value="RackCoordinate") String RackCoordinate) {
        if(Address !=null){
            instanceBookDAO.setAll(Author, Name, Address, RoomNumber, RackCoordinate);
            return new ModelAndView("/book").addObject("Book", instanceBookDAO.getAll());
        }
        return new ModelAndView("/addBook");
    }
}
