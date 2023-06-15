package org.example.Mapper;

import org.example.Classes.Logbook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogbookMapper implements RowMapper<Logbook> {
    @Override
    public Logbook mapRow(ResultSet rs, int rowNum) throws SQLException {
        Logbook logbook = new Logbook();
        logbook.setID_Taking(rs.getString("ID_Taking"));
        logbook.setFK_LibraryCardNumber(rs.getString("FK_LibraryCardNumber"));
        logbook.setFK_ID_Book(rs.getString("FK_ID_Book"));
        logbook.setFK_ID_Catalog(rs.getString("FK_ID_Catalog"));
        logbook.setFK_ID_Branch(rs.getString("FK_ID_Branch"));
        logbook.setFK_ID_Librarian(rs.getString("FK_ID_Librarian"));
        logbook.setDateOfTaking(rs.getString("DateOfTaking"));
        logbook.setReturnDate(rs.getString("ReturnDate"));
        logbook.setName(rs.getString("Name"));
        logbook.setFullName(rs.getString("FullName"));
        logbook.setAuthor(rs.getString("Author"));
        return logbook;
    }
}
