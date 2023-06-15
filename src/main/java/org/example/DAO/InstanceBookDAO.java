package org.example.DAO;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.example.Classes.Branch;
import org.example.Classes.Catalog;
import org.example.Classes.InstanceBook;
import org.example.Interface.DAO;
import org.example.Mapper.BranchMapper;
import org.example.Mapper.CatalogMapper;
import org.example.Mapper.InstanceBookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class InstanceBookDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM \"InstanceBook\" AS IB\n" +
                "INNER JOIN \"Catalog\" AS CT\n" +
                "ON IB.\"FK_ID_Catalog\" = CT.\"ID_Catalog\"";
        List<InstanceBook> instanceBooks = jdbcTemplate.query(SQL, new InstanceBookMapper());
        return instanceBooks;
    }

    public List getBookToCriteria(String Author, String Name, String YearOfPublishing, String KeyWords) {
        String SQL = "SELECT * FROM \"Catalog\" AS CT\n" + "INNER JOIN \"InstanceBook\" AS IB\n" +
                "ON CT.\"ID_Catalog\" = IB.\"FK_ID_Catalog\"\n" +
                "WHERE CT.\"Author\" = ? AND CT.\"Name\" = ? AND CT.\"YearOfPublishing\" = ? AND CT.\"Keywords\" = ?";
        List<InstanceBook> instanceBooks = jdbcTemplate.query(SQL, new Object[] {Author, Name, YearOfPublishing, KeyWords}, new InstanceBookMapper());
        return instanceBooks;
    }

    public List getBookToBranch(String Address) {
        String SQL = "SELECT * FROM \"InstanceBook\" AS IB\n" + "INNER JOIN \"Branch\" AS BR\n" +
                "ON IB.\"FK_ID_Branch\" = BR.\"ID_Branch\"\n" + "INNER JOIN \"Catalog\" AS CT\n" +
                "ON IB.\"FK_ID_Catalog\" = CT.\"ID_Catalog\"\n" + "WHERE BR.\"Address\" = ?";
        List<InstanceBook> instanceBooks = jdbcTemplate.query(SQL,new Object[] {Address}, new InstanceBookMapper());
        return instanceBooks;
    }

    public int setAll(String Author, String Name, String Address,String RoomNumber, String RackCoordinate) {
        String SQL0 = "SELECT * FROM \"Catalog\" AS CT\n" +
                "WHERE CT.\"Author\" = ? AND CT.\"Name\" = ?";
        List<Catalog> catalogs = jdbcTemplate.query(SQL0, new Object[] {Author, Name}, new CatalogMapper());
        String SQL1 = "SELECT * FROM \"Branch\" AS CT\n" +
                "WHERE CT.\"Address\" = ? ";
        List<Branch> branch = jdbcTemplate.query(SQL1, new Object[] {Address}, new BranchMapper());
        String SQL = "INSERT INTO public.\"InstanceBook\"(\n" +
                "\t\"ID_Book\", \"RoomNumber\", \"RackCoordinate\", \"FK_ID_Catalog\", \"FK_ID_Branch\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, ?, ?);";
        return jdbcTemplate.update(SQL, RoomNumber, RackCoordinate, UUID.fromString(catalogs.get(0).getID_Catalog()),UUID.fromString(branch.get(0).getID_Branch()));
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
