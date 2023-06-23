package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Branch;
import org.example.Classes.Librarian;
import org.example.Interface.DAO;
import org.example.Mapper.BranchMapper;
import org.example.Mapper.LibrarianMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class BranchDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM \"Branch\"";
        List<Branch> branches = jdbcTemplate.query(SQL, new BranchMapper());
        return branches;
    }

    public int setAll(String Address, String NominalNumberOfBooks, String ActualNumberOfBooks) {
        String SQL = "INSERT INTO public.\"Branch\"(\n" +
                "\t\"ID_Branch\", \"Address\", \"NominalNumberOfBooks\", \"ActualNumberOfBooks\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, ?);";
        return jdbcTemplate.update(SQL, Address, NominalNumberOfBooks, ActualNumberOfBooks);
    }

    public void update (String ID_Branch, String Address, String NominalNumberOfBooks, String ActualNumberOfBooks) {
    String SQL = "UPDATE public.\"Branch\"\n" +
            "\tSET \"Address\"=?, \"NominalNumberOfBooks\"=?, \"ActualNumberOfBooks\"=?\n" +
            "\tWHERE \"ID_Branch\"=?;";
    jdbcTemplate.update(SQL, Address, NominalNumberOfBooks, ActualNumberOfBooks, UUID.fromString(ID_Branch));
    }

    public void delete (String ID_Branch) {
        String SQL = "DELETE FROM public.\"Branch\"\n" +
                "\tWHERE \"ID_Branch\" = ?;";
        jdbcTemplate.update(SQL, new Object[] {UUID.fromString(ID_Branch)});
    }
}
