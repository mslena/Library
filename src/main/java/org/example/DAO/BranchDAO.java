package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Branch;
import org.example.Interface.DAO;
import org.example.Mapper.BranchMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
