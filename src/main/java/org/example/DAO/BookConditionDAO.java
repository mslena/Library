package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.BookCondition;
import org.example.Classes.InstanceBook;
import org.example.Interface.DAO;
import org.example.Mapper.BookConditionMapper;
import org.example.Mapper.InstanceBookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    public int setAll(String Author, String Name, String ID_Condition, String FK_ID_Book, String Condition, String StatusRecordDate) {
        String SQL1 = "SELECT * FROM \"InstanceBook\" AS IB\n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON CT.\"ID_Catalog\" = IB.\"FK_ID_Catalog\"\n" +
                "INNER JOIN \"Branch\" AS BR\n" +
                "ON BR.\"ID_Branch\" = IB.\"FK_ID_Branch\"\n" +
                "WHERE IB.\"ID_Book\" = ?";
        List<InstanceBook> books = jdbcTemplate.query(SQL1, new Object[] {UUID.fromString(FK_ID_Book)} ,new InstanceBookMapper());
        String SQL = "INSERT INTO public.\"BookCondition\"(\n" +
                "\t\"ID_Condition\", \"FK_ID_Book\", \"FK_ID_Branch\", \"FK_ID_Catalog\", \"Condition\", \"StatusRecordDate\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(SQL, UUID.fromString(FK_ID_Book), UUID.fromString(books.get(0).getFK_ID_Branch()), UUID.fromString(books.get(0).getFK_ID_Catalog()), Condition, StatusRecordDate);
    }

    public int update (String ID_Condition, String Condition, String StatusRecordDate) {
        String SQL = "UPDATE public.\"BookCondition\"\n" +
                "\tSET \"Condition\"=?, \"StatusRecordDate\"=?\n" +
                "\tWHERE \"ID_Condition\"=?;";
        return jdbcTemplate.update(SQL, Condition, StatusRecordDate, UUID.fromString(ID_Condition));
    }

    public void delete (String ID_Condition) {
        String SQL = "DELETE FROM public.\"BookCondition\"\n" +
                "\tWHERE \"ID_Condition\" = ?;";
        jdbcTemplate.update(SQL, new Object[] {UUID.fromString(ID_Condition)});
    }
}
