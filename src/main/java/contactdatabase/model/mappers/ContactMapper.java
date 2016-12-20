package contactdatabase.model.mappers;

import contactdatabase.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mmikilchenko on 20.12.2016.
 */
public class ContactMapper implements RowMapper<Contact> {

    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Contact(
                resultSet.getInt("ID"),
                resultSet.getInt("VERSION"),
                resultSet.getString("FIRST_NAME"),
                resultSet.getString("LAST_NAME"),
                resultSet.getDate("BIRTH_DATE")
        );
    }
}
