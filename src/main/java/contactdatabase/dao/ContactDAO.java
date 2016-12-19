package contactdatabase.dao;

import contactdatabase.model.Contact;

import java.sql.SQLException;

/**
 * Created by mmikilchenko on 15.12.2016.
 */
public interface ContactDAO {
    public void insertContact(Contact contact) throws SQLException;
    public Contact getContactById (int id);
}
