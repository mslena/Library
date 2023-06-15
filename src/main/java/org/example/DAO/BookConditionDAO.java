package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.BookCondition;
import org.example.Interface.DAO;
import org.example.Mapper.BookConditionMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BookConditionDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    public List getBookToCondition(String Name) {
        String SQL = "SELECT * FROM \"BookCondition\" AS BC\n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON BC.\"FK_ID_Catalog\" = CT.\"ID_Catalog\"\n" +
                "WHERE CT.\"Name\" = ?";
        List<BookCondition> bookConditions = jdbcTemplate.query(SQL, new Object[]  {Name},new BookConditionMapper());
        return bookConditions;
    }
    @Override
    public List getAll() {
        String SQL = "SELECT * FROM \"BookCondition\" AS BC\n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON BC.\"FK_ID_Catalog\" = CT.\"ID_Catalog\"";
        List<BookCondition> bookConditions = jdbcTemplate.query(SQL, new BookConditionMapper());
        return bookConditions;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
