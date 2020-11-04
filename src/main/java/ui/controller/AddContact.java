package ui.controller;

import domain.db.DbException;
import domain.model.Contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddContact extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        ArrayList<String> errors = new ArrayList<>();

        Contact newContact = new Contact();

        setUserId(newContact, request, errors);
        setEmail(newContact, request, errors);
        setTelefoonnummer(newContact, request, errors);
        setFirstName(newContact, request, errors);
        setLastName(newContact, request, errors);
        setTimestamp(newContact, request, errors);

        if(errors.size() == 0)
        {
            try
            {
                service.addContact(newContact);
                request.setAttribute("previousTelefoonnummerContact", "");
                request.setAttribute("previousEmailContact", "");
                request.setAttribute("previousLastNameContact", "");
                request.setAttribute("previousFirstNameContact", "");
                request.setAttribute("previousIdContact", "");
                return "Controller?command=Contacts";
            }
            catch (DbException e)
            {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("contactErrors", errors);
        return "/Controller?command=Contacts";
    }

    private void setTimestamp(Contact newContact, HttpServletRequest request, ArrayList<String> errors) {
        String datumContact = request.getParameter("datumContact");
        System.out.println(datumContact);
        String tijdstipContact=request.getParameter("tijdstipContact");
        System.out.println(tijdstipContact);
        String timestampPattern="yyyy-MM-dd HH:mm";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern(timestampPattern);
        LocalDateTime dateTime=null;
        Timestamp timestamp=null;

        try{
            request.setAttribute("previousDatumContact",tijdstipContact);
            request.setAttribute("previousTijdstipContact",datumContact);
            dateTime=LocalDateTime.from(formatter.parse(datumContact+" "+tijdstipContact));
            timestamp=Timestamp.valueOf(dateTime);
        }catch(DateTimeException e){
            errors.add("date or hour invalid");
        }
        newContact.setTimestamp(timestamp);
    }

    private void setLastName(Contact newContact, HttpServletRequest request, ArrayList<String> errors) {
        String lastNameContact = request.getParameter("lastNameContact");

        try
        {
            newContact.setLastName(lastNameContact);
            request.setAttribute("previousLastNameContact", lastNameContact);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setFirstName(Contact newContact, HttpServletRequest request, ArrayList<String> errors) {
        String firstNameContact = request.getParameter("firstNameContact");

        try
        {
            newContact.setFirstName(firstNameContact);
            request.setAttribute("previousFirstNameContact", firstNameContact);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setTelefoonnummer(Contact newContact, HttpServletRequest request, ArrayList<String> errors) {
        String telefoonnummerContact = request.getParameter("telefoonnummerContact");

        try
        {
            newContact.setTelefoonnummer(telefoonnummerContact);
            request.setAttribute("previousTelefoonnummerContact", telefoonnummerContact);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setEmail(Contact newContact, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("emailContact");

        try
        {
            newContact.setEmail(email);
            request.setAttribute("previousEmailContact", email);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setUserId(Contact newContact, HttpServletRequest request, ArrayList<String> errors) {
        String userId = request.getParameter("userIdContact");

        try
        {
            newContact.setUserid(userId.toLowerCase());
            request.setAttribute("previousIdContact", userId);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }
}
