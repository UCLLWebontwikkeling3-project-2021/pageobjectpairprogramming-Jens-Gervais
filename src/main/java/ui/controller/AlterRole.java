package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class AlterRole extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
        String userid = request.getParameter("UseridRole");
        Person person = (Person) request.getSession().getAttribute("personLogin");
        String value = request.getParameter("Roles");
        service.alterRole(userid, value);
        if(person.getUserid().equals(userid) && value.equals("gebruiker")) {
            return "Controller?command=Logout";
        }
        else return "Controller?command=AlterRolePage";
    }
}
