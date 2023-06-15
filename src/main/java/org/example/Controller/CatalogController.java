package org.example.Controller;

import jakarta.websocket.server.PathParam;
import org.example.Classes.Catalog;
import org.example.DAO.CatalogDAO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CatalogController {
    private final CatalogDAO catalogDAO;

    public CatalogController(CatalogDAO catalogDAO) {
        this.catalogDAO = catalogDAO;
    }

    @GetMapping("/catalog")
    public ModelAndView getCatalog() {
        return new ModelAndView("catalog").addObject("catalog", catalogDAO.getAll());
    }


    @GetMapping("addCatalog")
    public ModelAndView setAll(@PathParam (value="Author") String Author, @PathParam (value="Name") String Name, @PathParam (value="Quantity") String Quantity, @PathParam (value="KeyWords") String KeyWords, @PathParam (value="YearOfPublishing") String YearOfPublishing) {
        if(Author != null){
            catalogDAO.setAll(Author, Name, Quantity, KeyWords, YearOfPublishing);
            return new ModelAndView("/catalog").addObject("catalog", catalogDAO.getAll());
        }
        return new ModelAndView("addCatalog");
    }
}
