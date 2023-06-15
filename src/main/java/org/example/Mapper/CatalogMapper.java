package org.example.Mapper;

import org.example.Classes.Catalog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogMapper implements RowMapper<Catalog> {
    @Override
    public Catalog mapRow(ResultSet rs, int rowNum) throws SQLException {
        Catalog catalog = new Catalog();
        catalog.setID_Catalog(rs.getString("ID_Catalog"));
        catalog.setAuthor(rs.getString("Author"));
        catalog.setName(rs.getString("Name"));
        catalog.setQuantity(rs.getString("Quantity"));
        catalog.setYearOfPublishing(rs.getString("YearOfPublishing"));
        catalog.setKeyWords(rs.getString("KeyWords"));
        return catalog;
    }
}
