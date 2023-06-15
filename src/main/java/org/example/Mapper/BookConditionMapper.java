package org.example.Mapper;

import org.example.Classes.BookCondition;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookConditionMapper implements RowMapper<BookCondition> {
    @Override
    public BookCondition mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookCondition bookCondition = new BookCondition();
        bookCondition.setFK_ID_Book(rs.getString("FK_ID_Book"));
        bookCondition.setID_Condition(rs.getString("ID_Condition"));
        bookCondition.setCondition(rs.getString("Condition"));
        bookCondition.setAuthor(rs.getString("Author"));
        bookCondition.setName(rs.getString("Name"));
        bookCondition.setStatusRecordDate(rs.getString("StatusRecordDate"));
        bookCondition.setFK_ID_Branch(rs.getString("FK_ID_Branch"));
        bookCondition.setFK_ID_Catalog(rs.getString("FK_ID_Catalog"));
        return bookCondition;
    }
}
