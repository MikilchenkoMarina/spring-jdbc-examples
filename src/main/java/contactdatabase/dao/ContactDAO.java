package contactdatabase.dao;

import contactdatabase.model.Contact;

/**
 * Created by mmikilchenko on 15.12.2016.
 */
public interface ContactDAO {
    public void insertContact(Contact contact);
    public Contact getContactById (int id);
}
