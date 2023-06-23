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
import java.util.UUID;

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
                "WHERE LB.\"ReturnDate\" != 'null'";
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
                "\t\"LibraryCardNumber\", \"FullName\", \"Gender\", \"TakenBooks\", \"Profession\", \"Age\", \"PassportData\", \"LibraryEntryDates\")\n" +
                "\tVALUES (gen_random_uuid(), ?, ?, '0', ?, ?, ?, 'Нет');";
        return jdbcTemplate.update(SQL, fullName, passportData, gender, profession, age);
    }

    public void update (String libraryCardNumber, String fullName, String gender, String age, String passportData, String profession, String takenBooks,String libraryEntryDates) {
        String SQL = "UPDATE public.\"Reader\"\n" +
                "\tSET \"FullName\"=?, \"Gender\"=?, \"TakenBooks\"=?, \"Profession\"=?, \"LibraryEntryDates\"=?, \"Age\"=?, \"PassportData\"=?\n" +
                "\tWHERE \"LibraryCardNumber\"=?;";
        jdbcTemplate.update(SQL, fullName, gender, takenBooks, profession, libraryEntryDates, age, passportData, UUID.fromString(libraryCardNumber));
    }

    public void delete (String LibraryCardNumber) {
        String SQL = "DELETE FROM public.\"Reader\"\n" +
                "\tWHERE \"LibraryCardNumber\" = ?;";
        jdbcTemplate.update(SQL, new Object[] {UUID.fromString(LibraryCardNumber)});
    }
}