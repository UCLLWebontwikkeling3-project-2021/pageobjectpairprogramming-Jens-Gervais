package ui.controller;

import domain.model.Contact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

public class Search extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
        List<Contact> contacts = service.getAllContacts();
        request.setAttribute("searchContacts", contacts);
        return "search.jsp";
    }
}
