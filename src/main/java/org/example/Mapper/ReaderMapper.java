package org.example.Mapper;

import org.example.Classes.Reader;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderMapper implements RowMapper<Reader> {
    @Override
    public Reader mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reader reader = new Reader();
        reader.setLibraryCardNumber(rs.getString("LibraryCardNumber"));
        reader.setFullName(rs.getString("FullName"));
        reader.setAge(rs.getString("Age"));
        reader.setGender(rs.getString("Gender"));
        reader.setProfession(rs.getString("Profession"));
        reader.setPassportData(rs.getString("PassportData"));
        reader.setTakenBooks(rs.getInt("TakenBooks"));
        reader.setLibraryEntryDates(rs.getString("LibraryEntryDates"));
        return reader;
    }
}
