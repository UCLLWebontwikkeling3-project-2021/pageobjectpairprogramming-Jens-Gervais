package ui.controller;

import domain.model.Contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Contacts extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        service.autoDeleteContacts();
        List<Contact> contacts = service.getAllContacts();
        request.setAttribute("contacts", contacts);
        return "contacts.jsp";
    }
}
