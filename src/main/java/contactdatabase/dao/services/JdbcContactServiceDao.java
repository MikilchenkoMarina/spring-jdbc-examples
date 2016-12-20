package contactdatabase.dao.services;

import contactdatabase.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                        "VALUES(:ident,:version,':firstName',':lastName',null /*STR_TO_DATE('2013-02-11', '%Y-%m-%d')*/);";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ident", contact.getId());
        params.put("version", contact.getVersion());
        params.put("firstName", contact.getFirstName());
        params.put("lastName", contact.getLastName());


        getSqlQuery(SQL_INSERT_CONTACT, params);

        jdbcTemplateObject.update(SQL_INSERT_CONTACT, params);

    }

    public Contact getContactById(int id) {

        final String SQL_SELECT_CONTACT = "select ID,VERSION,FIRST_NAME,LAST_NAME from contact where ID = ?;";

        Contact contact = jdbcTemplateObject.queryForObject(
                SQL_SELECT_CONTACT,
                new RowMapper<Contact>()// --2)  Mapper as inner class that map ResultSet to Object of Class Map - Class Contact it this example
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

    private String getSqlQuery(String sql, Map<String, Object> params) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement sqlWithParam
                = con.prepareStatement(sql);
        int index = 1;
        for (String paramKey : params.keySet()) {
            sqlWithParam.setObject(index, params.get(paramKey));
            index++;

        }
        return sqlWithParam.toString();
    }


}
