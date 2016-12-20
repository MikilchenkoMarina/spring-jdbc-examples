package contactdatabase.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by mmikilchenko on 15.12.2016.
 */
public class Contact {

    public int id;
    public int version;
    public String firstName;
    public String lastName;
    public LocalDate birthDate;

    public Contact(){}

    public Contact(int id, int version, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}
