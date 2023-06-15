package org.example.DAO;

import lombok.AllArgsConstructor;
import org.example.Classes.Logbook;
import org.example.Classes.Reader;
import org.example.Interface.DAO;
import org.example.Mapper.LogbookMapper;
import org.example.Mapper.ReaderMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class ReaderDAO implements DAO {
    private final JdbcTemplate jdbcTemplate;
    public List<Reader> getReaderToAgeGenderProfession(String profession, String age, String gender)
    {

        String SQL = "SELECT * FROM \"Reader\" WHERE \"Profession\" = ? AND \"Age\" = ? AND \"Gender\" = ?";
        List<Reader> readers = jdbcTemplate.query(SQL, new Object[] {profession, age, gender} , new ReaderMapper());
        return readers;
    }

    public List getReaderWhoLater() {
        String SQL = "SELECT * FROM \"Reader\" AS RD\n" +
                "INNER JOIN \"Logbook\" AS LB\n" +
                "ON RD.\"LibraryCardNumber\" = LB.\"FK_LibraryCardNumber\"\n" +
                "WHERE LB.\"ReturnDate\" = LB.\"DateOfTaking\" + 14\n";
        List<Reader> reader = jdbcTemplate.query(SQL, new ReaderMapper());
        return reader;
    }


    @Override
    public List getAll() {
        String SQL = "SELECT * FROM \"Reader\"";
        List<Reader> reader = jdbcTemplate.query(SQL, new ReaderMapper());
        return reader;
    }

    public int setAll(String fullName, String passportData, String gender, String profession, String age) {
        String SQL = "INSERT INTO public.\"Reader\"(\n" +
                "\t\"LibraryCardNumber\", \"FullName\", \"PassportData\", \"Gender\", \"Profession\", \"Age\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(SQL, fullName, passportData, gender, profession, age);
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