package contactdatabase;

import contactdatabase.dao.services.ContactDAO;
import contactdatabase.model.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import java.util.Date;

/**
 * Created by mmikilchenko on 19.12.2016.
 */
public class ApplicationJDBCTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
        ContactDAO contactDAO = (ContactDAO) context.getBean("contactDAO");

        Contact contact = new Contact(7, 1, "Khal", "Drogo",null/*STR_TO_DATE('1989-02-10', '%Y-%m-%d')*/);
        contactDAO.insertContact(contact);
        // ---

        Contact contact2 = contactDAO.getContactById(1);
        System.out.println(contact);

    }

    private Date parseDate (String dateString ){
/*        String str = "1986-04-08 12:30";*/
        //LocalDate test = null ;
//LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
/*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);*/
        return  null ;
    }
}
