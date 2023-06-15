package org.example.Mapper;

import org.example.Classes.Librarian;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianMapper implements RowMapper<Librarian> {
    @Override
    public Librarian mapRow(ResultSet rs, int rowNum) throws SQLException {
        Librarian librarian = new Librarian();
        librarian.setID_Librarian(rs.getString("ID_Librarian"));
        librarian.setFullName(rs.getString("FullName"));
        return librarian;
    }
}
