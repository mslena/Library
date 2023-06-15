package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Interface.DAO;
import org.example.Mapper.CatalogMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.example.Classes.*;

@Repository
@AllArgsConstructor
public class CatalogDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;

    public List<Catalog> getBookToCriteria(String author, String name, int yearOfPublishing, String keywords){
        String SQL = "SELECT * FROM \"Catalog\" AS CT \n"
                    + "INNER JOIN \"InstanceBook\" AS IB \n"
                    + "ON CT.\"ID_Catalog\" = IB.\"FK_ID_Catalog\" \n"
                    + "WHERE CT.\"Author\" = ? AND CT.\"Name\" = ? AND CT.\"YearOfPublishing\" = ? AND CT.\"Keywords\" = ?";
        List<Catalog> catalog = jdbcTemplate.query(SQL,new Object[] {author, name, yearOfPublishing, keywords}, new CatalogMapper());
        return catalog;
    }

    public int setAll(String Author, String Name, String Quantity, String KeyWords, String YearOfPublishing) {
        String SQL = "INSERT INTO public.\"Catalog\"(\n" +
                "\t\"ID_Catalog\", \"Author\", \"Name\", \"Quantity\", \"Keywords\", \"YearOfPublishing\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(SQL, Author, Name, Quantity, KeyWords, YearOfPublishing);
    }

    @Override
    public List getAll() {
        String SQL = "SELECT * FROM \"Catalog\"";
        List<Catalog> catalog = jdbcTemplate.query(SQL, new CatalogMapper());
        return catalog;
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
