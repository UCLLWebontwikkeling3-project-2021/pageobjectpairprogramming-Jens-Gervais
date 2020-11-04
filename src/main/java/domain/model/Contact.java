package domain.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String userid;
    private String email;
    private String telefoonnummer;
    private String firstName;
    private String lastName;
    private Timestamp timestamp;

    public Contact(String userid, String email, String telefoonnummer, String firstName, String lastName, Timestamp timestamp)
    {
        setUserid(userid);
        setEmail(email);
        setTelefoonnummer(telefoonnummer);
        setFirstName(firstName);
        setLastName(lastName);
        setTimestamp(timestamp);
    }

    public void setTimestamp(Timestamp timestamp) {
        if(timestamp == null)
        {
            throw new IllegalArgumentException("Geen timestamp gegeven");
        }
        this.timestamp = timestamp;
    }

    public Contact(){}

    public String getUserid() {
        return userid;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("No last name given");
        }
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        if(firstName== null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("No firstname given");
        }
        this.firstName = firstName;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        if(telefoonnummer == null || telefoonnummer.trim().isEmpty())
        {
            throw new IllegalArgumentException("No phone number given");
        }
        this.telefoonnummer = telefoonnummer;
    }

    public void setEmail(String email) {
        if(email == null ||email.trim().isEmpty()){
            throw new IllegalArgumentException("No email given");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Email not valid");
        }
        this.email = email;
    }

    public void setUserid(String userid) {
        if(userid == null || userid.trim().isEmpty()){
            throw new IllegalArgumentException("No userid given");
        }
        this.userid = userid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
