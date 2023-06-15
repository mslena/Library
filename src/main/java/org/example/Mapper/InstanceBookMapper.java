package org.example.Mapper;

import org.example.Classes.InstanceBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InstanceBookMapper implements RowMapper<InstanceBook> {
    @Override
    public InstanceBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        InstanceBook instanceBook = new InstanceBook();
        instanceBook.setID_Book(rs.getString("ID_Book"));
        instanceBook.setAuthor(rs.getString("Author"));
        instanceBook.setName(rs.getString("Name"));
        instanceBook.setFK_ID_Branch(rs.getString("FK_ID_Branch"));
        instanceBook.setFK_ID_Catalog(rs.getString("FK_ID_Catalog"));
        instanceBook.setRackCoordinate(rs.getString("RackCoordinate"));
        instanceBook.setRoomNumber(rs.getString("RoomNumber"));
        instanceBook.setWriteOfDate(rs.getString("WriteOffDate"));
        instanceBook.setYearOfPublishing(rs.getString("YearOfPublishing"));
        instanceBook.setKeyWords(rs.getString("Keywords"));
        return instanceBook;
    }
}
