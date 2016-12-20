package contactdatabase.dao.services;

import contactdatabase.dao.helpers.SqlQueryHelper;
import contactdatabase.model.Contact;
import contactdatabase.model.mappers.ContactMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mmikilchenko on 15.12.2016.
 */
public class JdbcContactServiceDao  /*extends JdbcDaoSupport*/ implements ContactDAO {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insertContact(Contact contact) throws SQLException {

        final String SQL_INSERT_CONTACT =
                "NSERT INTO contact (ID,VERSION,FIRST_NAME,LAST_NAME,BIRTH_DATE) " +
                        "VALUES(:ident,:version,':firstName',':lastName',STR_TO_DATE(':birthDate', '%Y-%m-%d'));";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ident", contact.getId());
        params.put("version", contact.getVersion());
        params.put("firstName", contact.getFirstName());
        params.put("lastName", contact.getLastName());
        params.put("birthDate", contact.getBirthDate());

        SqlQueryHelper helper = new SqlQueryHelper();
        System.out.println(helper.getSqlQueryWithBindParams(dataSource.getConnection(), SQL_INSERT_CONTACT, params));

        jdbcTemplateObject.update(SQL_INSERT_CONTACT, params);

    }

    public Contact getContactById(int id) {

        final String SQL_SELECT_CONTACT = "select ID,VERSION,FIRST_NAME,LAST_NAME from contact where ID = ?;";

        Contact contact = jdbcTemplateObject.queryForObject(
                SQL_SELECT_CONTACT, new ContactMapper(),
                new Object[]{id});
        return contact;
    }


}
