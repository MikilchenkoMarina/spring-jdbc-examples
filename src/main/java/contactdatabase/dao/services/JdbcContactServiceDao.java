package contactdatabase.dao.services;

import com.mysql.jdbc.*;
import contactdatabase.dao.helpers.SqlQueryHelper;
import contactdatabase.model.Contact;
import contactdatabase.model.mappers.ContactMapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    public void insertContact(Contact contact) {

        final String SQL_INSERT_CONTACT =
                "INSERT INTO contact (ID,VERSION,FIRST_NAME,LAST_NAME,BIRTH_DATE) " +
                        "VALUES(:ident,:version,:firstName,:lastName,:birthDate);";


        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("ident", contact.getId());
        params.put("version", contact.getVersion());
        params.put("firstName", contact.getFirstName());
        params.put("lastName", contact.getLastName());
        params.put("birthDate", contact.getBirthDate());

        SqlQueryHelper helper = new SqlQueryHelper();
        String parametrizedQuery = helper.getSqlQueryWithBindParams(dataSource, SQL_INSERT_CONTACT, params);

        jdbcTemplateObject.execute(parametrizedQuery);

    }

    public Contact getContactById(int id) {

        final String SQL_SELECT_CONTACT = "select ID,VERSION,FIRST_NAME,LAST_NAME,BIRTH_DATE from contact where id = :id";
        LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("id", id);
        SqlQueryHelper helper = new SqlQueryHelper();
        String parametrizedQuery = helper.getSqlQueryWithBindParams(dataSource, SQL_SELECT_CONTACT, params);

        Contact contact = jdbcTemplateObject.queryForObject(parametrizedQuery, new ContactMapper());
        return contact;
    }


}
