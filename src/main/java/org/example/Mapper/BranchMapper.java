package org.example.Mapper;

import org.example.Classes.Branch;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchMapper implements RowMapper<Branch> {
    @Override
    public Branch mapRow(ResultSet rs, int rowNum) throws SQLException {
        Branch branch = new Branch();
        branch.setID_Branch(rs.getString("ID_Branch"));
        branch.setAddress(rs.getString("Address"));
        branch.setActualNumberOfBook(rs.getString("ActualNumberOfBooks"));
        branch.setNominalNumberOfBook(rs.getString("NominalNumberOfBooks"));
        return branch;
    }
}
