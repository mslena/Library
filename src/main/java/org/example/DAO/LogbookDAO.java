package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.*;
import org.example.Interface.DAO;
import org.example.Mapper.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class LogbookDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM \"Logbook\" AS LG\n" +
                "INNER JOIN \"Reader\" AS RD\n" +
                "ON LG.\"FK_LibraryCardNumber\" = RD.\"LibraryCardNumber\"\n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON LG.\"FK_ID_Catalog\" = CT.\"ID_Catalog\"";
        List<Logbook> logbooks = jdbcTemplate.query(SQL, new LogbookMapper());
        return logbooks;
    }

    public int setAll(String DateOfTaking, String FullName, String NameLibrarian, String ID_Book, String Address) {
        String SQL1 = "SELECT * FROM \"Reader\" AS RD\n" +
                       " WHERE RD.\"FullName\" = ?";
        List<Reader> readers = jdbcTemplate.query(SQL1, new Object[] {FullName}, new ReaderMapper());
        String SQL2 = "SELECT * FROM \"InstanceBook\" AS IB \n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON IB.\"FK_ID_Catalog\" = CT.\"ID_Catalog\" \n"+
                " WHERE IB.\"ID_Book\" = ?";
        List<InstanceBook> books = jdbcTemplate.query(SQL2, new Object[] {UUID.fromString(ID_Book)}, new InstanceBookMapper());
        String SQL3 = "SELECT * FROM \"Branch\" AS BR\n" +
                " WHERE BR.\"Address\" = ?";
        List<Branch> branch = jdbcTemplate.query(SQL3, new Object[] {Address}, new BranchMapper());
        String SQL4 = "SELECT * FROM \"Librarian\" AS LB \n" +
                " WHERE LB.\"FullName\" = ?";
        List<Librarian> librarian = jdbcTemplate.query(SQL4, new Object[] {NameLibrarian}, new LibrarianMapper());
        String SQL = "INSERT INTO public.\"Logbook\"(\n" +
                "\t\"ID_Taking\", \"FK_ID_Librarian\", \"FK_LibraryCardNumber\", \"FK_ID_Book\", \"FK_ID_Branch\", \"FK_ID_Catalog\", \"DateOfTaking\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(SQL, UUID.fromString(librarian.get(0).getID_Librarian()), UUID.fromString(readers.get(0).getLibraryCardNumber()),UUID.fromString(books.get(0).getID_Book()),UUID.fromString(branch.get(0).getID_Branch()),UUID.fromString(books.get(0).getFK_ID_Catalog()), DateOfTaking);
    }

    public void update (String ID_Taking, String NameLibrarian, String FullName, String FK_ID_Book, String DateOfTaking, String ReturnDate) {
        String SQL1 = "SELECT * FROM \"Reader\" AS RD\n" +
                " WHERE RD.\"FullName\" = ?";
        List<Reader> readers = jdbcTemplate.query(SQL1, new Object[] {FullName}, new ReaderMapper());
        String SQL2 = "SELECT * FROM \"InstanceBook\" AS IB \n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON IB.\"FK_ID_Catalog\" = CT.\"ID_Catalog\" \n"+
                " WHERE IB.\"ID_Book\" = ?";
        List<InstanceBook> books = jdbcTemplate.query(SQL2, new Object[] {UUID.fromString(FK_ID_Book)}, new InstanceBookMapper());
        String SQL4 = "SELECT * FROM \"Librarian\" AS LB \n" +
                " WHERE LB.\"FullName\" = ?";
        List<Librarian> librarian = jdbcTemplate.query(SQL4, new Object[] {NameLibrarian}, new LibrarianMapper());
        String SQL = "UPDATE public.\"Logbook\"\n" +
                "\tSET  \"FK_ID_Librarian\"=?, \"FK_LibraryCardNumber\"=?, \"FK_ID_Book\"=?, \"FK_ID_Branch\"=?, \"FK_ID_Catalog\"=?, \"ReturnDate\"=?, \"DateOfTaking\"=?\n" +
                "\tWHERE \"ID_Taking\"=?;";
        jdbcTemplate.update(SQL, UUID.fromString(librarian.get(0).getID_Librarian()), UUID.fromString(readers.get(0).getLibraryCardNumber()), UUID.fromString(FK_ID_Book), UUID.fromString(books.get(0).getFK_ID_Branch()), UUID.fromString(books.get(0).getFK_ID_Catalog()), ReturnDate, DateOfTaking, UUID.fromString(ID_Taking));
    }

    public void delete (String ID_Taking) {
        String SQL = "DELETE FROM public.\"Logbook\"\n" +
                "\tWHERE \"ID_Taking\" = ?;";
        jdbcTemplate.update(SQL, new Object[] {UUID.fromString(ID_Taking)});
    }
}
