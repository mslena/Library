package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Librarian;
import org.example.Interface.DAO;
import org.example.Mapper.LibrarianMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class LibrarianDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll()
    {
        String SQL = "SELECT * FROM \"Librarian\"";
        List<Librarian> librarians = jdbcTemplate.query(SQL, new LibrarianMapper());
        return librarians;
    }

    public int setAll(String fullName) {
        String SQL = "INSERT INTO public.\"Librarian\"(\n" +
                "\t\"FullName\", \"ID_Librarian\")\n" +
                "\tVALUES (?, gen_random_uuid());";
        return jdbcTemplate.update(SQL, fullName);
    }

    public void update (String ID_Librarian, String fullName) {
        String SQL = "UPDATE \"Librarian\"\n" +
                "SET \"FullName\"= ?\n" +
                "WHERE \"ID_Librarian\"= ?;";
        jdbcTemplate.update(SQL, fullName, UUID.fromString(ID_Librarian));
    }

    public void delete (String ID_Librarian) {
        String SQL = "DELETE FROM public.\"Librarian\"\n" +
                "\tWHERE \"ID_Librarian\" = ?;";
        jdbcTemplate.update(SQL, new Object[] {UUID.fromString(ID_Librarian)});
    }
}
