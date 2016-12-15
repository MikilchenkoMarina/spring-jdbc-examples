package contactdatabase.dao.implementation;

import contactdatabase.dao.ContactDAO;
import contactdatabase.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mmikilchenko on 15.12.2016.
 */
public class JdbcContactServiceDao  /*extends JdbcDaoSupport*/ implements ContactDAO {

    private static final String SQL_SELECT_CONTACT =
            "select ID,VERSION,FIRST_NAME,LAST_NAME from contact where ID = ?;";
    private static final String
            SQL_INSERT_CONTACT =
            "NSERT INTO contact (ID,VERSION,FIRST_NAME,LAST_NAME,BIRTH_DATE) " +
                    "VALUES(5,1,'Pavel','Pavlov', STR_TO_DATE('2013-02-11', '%Y-%m-%d'));";

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insertContact(Contact contact) {
        jdbcTemplateObject.update(SQL_INSERT_CONTACT, new Object[]{
                contact.getId(),
                contact.getVersion(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getBirthDate()
        });


    }

    public Contact getContactById(int id) {
        Contact contact = jdbcTemplateObject.queryForObject(
                SQL_SELECT_CONTACT,
                new RowMapper<Contact>()// --2)  Mapper as inner class that map ResultSert to Object of Class Map - Class Spittter it this example
                {
                    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Contact contact = new Contact();//-- Class Model - Create object
                        contact.setId(rs.getInt(1));
                        contact.setVersion(rs.getInt(2));
                        contact.setFirstName(rs.getString(3));
                        contact.setLastName(rs.getString(4));

                        return contact;
                    }
                },
                new Object[]{1});
        return contact;
    }
}
