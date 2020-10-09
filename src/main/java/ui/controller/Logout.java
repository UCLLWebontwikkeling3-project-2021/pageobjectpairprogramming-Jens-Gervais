package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("personLogin");

        if (person != null)
        {
            request.getSession().invalidate();
            person = null;
            request.getSession().setAttribute("personLogin", person);
        }
        return "/Controller?command=Home";
    }
}
