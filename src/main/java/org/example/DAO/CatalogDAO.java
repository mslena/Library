package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Interface.DAO;
import org.example.Mapper.CatalogMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    public int update (String ID_Catalog, String Author, String Name, String Keywords, String YearOfPublishing, String Quantity) {
        String SQL = "UPDATE public.\"Catalog\"\n" +
                "\tSET  \"Author\"=?, \"Name\"=?, \"Keywords\"=?, \"YearOfPublishing\"=?, \"Quantity\"=?\n" +
                "\tWHERE \"ID_Catalog\"=?;";
        return jdbcTemplate.update(SQL, Author, Name, Keywords, YearOfPublishing, Quantity, UUID.fromString(ID_Catalog));
    }

    public void delete (String ID_Catalog) {
        String SQL = "DELETE FROM public.\"Catalog\"\n" +
                "\tWHERE \"ID_Catalog\" = ?;";
        jdbcTemplate.update(SQL, new Object[] {UUID.fromString(ID_Catalog)});
    }
}
