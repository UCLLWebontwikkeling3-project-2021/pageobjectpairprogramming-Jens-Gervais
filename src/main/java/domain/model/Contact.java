package domain.model;

import java.sql.Time;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private String userid;
    private String email;
    private String telefoonnummer;
    private String firstName;
    private String lastName;
    private Date datum;
    private Time aankomstuur;

    public Contact(String userid, String email, String telefoonnummer, String firstName, String lastName, Date datum, Time aankomstuur)
    {
        setUserid(userid);
        setEmail(email);
        setTelefoonnummer(telefoonnummer);
        setFirstName(firstName);
        setLastName(lastName);
        setDatum(datum);
        setAankomstuur(aankomstuur);
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

    public Date getDatum() {
        return datum;
    }

    public Time getAankomstuur() {
        return aankomstuur;
    }

    private void setAankomstuur(Time aankomstuur) {
        if(aankomstuur == null)
        {
            throw new IllegalArgumentException("No time given");
        }
        this.aankomstuur = aankomstuur;
    }

    private void setDatum(Date datum) {
        if(datum == null || datum.after(java.util.Calendar.getInstance().getTime()))
        {
            throw new IllegalArgumentException("No date given");
        }
        this.datum = datum;
    }

    private void setLastName(String lastName) {
        if(lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("No last name given");
        }
        this.lastName = lastName;
    }

    private void setFirstName(String firstName) {
        if(firstName== null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("No firstname given");
        }
        this.firstName = firstName;
    }

    private void setTelefoonnummer(String telefoonnummer) {
        if(telefoonnummer == null || telefoonnummer.trim().isEmpty())
        {
            throw new IllegalArgumentException("No phone number given");
        }
        this.telefoonnummer = telefoonnummer;
    }

    private void setEmail(String email) {
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

    private void setUserid(String userid) {
        if(userid == null || userid.trim().isEmpty()){
            throw new IllegalArgumentException("No userid given");
        }
        this.userid = userid;
    }
}
