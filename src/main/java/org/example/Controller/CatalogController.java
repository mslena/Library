package org.example.Controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Classes.Catalog;
import org.example.DAO.CatalogDAO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
public class CatalogController {
    private final CatalogDAO catalogDAO;

    @GetMapping("/catalog")
    public ModelAndView getAll() {
        return new ModelAndView("catalog").addObject("catalog", catalogDAO.getAll());
    }


    @GetMapping("addCatalog")
    public ModelAndView setAll(@PathParam (value="Author") String Author, @PathParam (value="Name") String Name, @PathParam (value="Quantity") String Quantity, @PathParam (value="KeyWords") String KeyWords, @PathParam (value="YearOfPublishing") String YearOfPublishing) {
        if(Author != null){
            catalogDAO.setAll(Author, Name, Quantity, KeyWords, YearOfPublishing);
            return new ModelAndView("/catalog").addObject("catalog", catalogDAO.getAll());
        }
        return new ModelAndView("addCatalog").addObject("catalog", catalogDAO.getAll());
    }

    @GetMapping("/updateCatalog")
    public ModelAndView updateObject (@PathParam(value = "ID_Catalog") String ID_Catalog, @PathParam (value="Author") String Author, @PathParam (value="Name") String Name,  @PathParam (value="KeyWords") String KeyWords, @PathParam (value="YearOfPublishing") String YearOfPublishing, @PathParam (value="Quantity") String Quantity) {
        if(Author != null){
            catalogDAO.update(ID_Catalog, Author, Name, KeyWords, YearOfPublishing, Quantity);
            return new ModelAndView("/catalog").addObject("catalog", catalogDAO.getAll());
        }
        return new ModelAndView("updateCatalog").addObject("catalog", catalogDAO.getAll());
    }

    @GetMapping("/deleteCatalog")
    public ModelAndView deleteObject (@PathParam(value = "ID_Catalog") String ID_Catalog)
    {
        if (ID_Catalog != null) {
            catalogDAO.delete(ID_Catalog);
            return new ModelAndView("catalog").addObject("catalog", catalogDAO.getAll());
        }
        return new ModelAndView("deleteCatalog").addObject("Catalog", catalogDAO.getAll());
    }
}
