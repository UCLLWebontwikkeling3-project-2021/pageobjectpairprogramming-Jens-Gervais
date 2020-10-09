package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("personLogin");
        String userId = person.getUserid();
        service.delete(userId);
        request.getSession().invalidate();
        return "/Controller?command=Overview";
    }
}
