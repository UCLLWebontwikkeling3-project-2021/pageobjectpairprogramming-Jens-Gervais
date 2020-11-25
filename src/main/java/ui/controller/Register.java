package ui.controller;

import domain.db.DbException;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class Register extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Person newPerson = new Person();

        setUserId(newPerson, request, errors);
        setEmail(newPerson, request, errors);
        setPassword(newPerson, request, errors);
        setFirstName(newPerson, request, errors);
        setLastName(newPerson, request, errors);

        if(errors.size() == 0)
        {
            try
            {
                service.add(newPerson);
                return "Controller?command=Overview";
            }
            catch (DbException e)
            {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "/Controller?command=RegisterPage";
    }

    private void setLastName(Person newPerson, HttpServletRequest request, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");

        try
        {
            newPerson.setLastName(lastName);
            request.setAttribute("previousLastName", lastName);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setFirstName(Person newPerson, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");

        try
        {
            newPerson.setFirstName(firstName);
            request.setAttribute("previousFirstName", firstName);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setPassword(Person newPerson, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");

        try
        {
            newPerson.setPassword(password);
            request.setAttribute("previousPassword", password);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setEmail(Person newPerson, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");

        try
        {
            newPerson.setEmail(email);
            request.setAttribute("previousEmail", email);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }

    private void setUserId(Person newPerson, HttpServletRequest request, ArrayList<String> errors) {
        String userId = request.getParameter("userid");

        try
        {
            newPerson.setUserid(userId.toLowerCase());
            request.setAttribute("previousId", userId);
        }
        catch (Exception e)
        {
            errors.add(e.getMessage());
        }
    }
}
