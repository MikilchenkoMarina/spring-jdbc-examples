package contactdatabase;

import contactdatabase.dao.services.ContactDAO;
import contactdatabase.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by mmikilchenko on 19.12.2016.
 */
public class ApplicationJDBCTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        ContactDAO contactDAO = (ContactDAO) context.getBean("contactDAO");

        Contact contact = new Contact(88, 1, "TestName2", "TestLastName2", parseDate("2016-10-20"));
        contactDAO.insertContact(contact);
        // ---
        Contact contact2 = contactDAO.getContactById(1);
        System.out.println(contact2);

    }

    private static LocalDate parseDate(String dateString) {
        LocalDate fromCustomPattern = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return fromCustomPattern;
    }
}
