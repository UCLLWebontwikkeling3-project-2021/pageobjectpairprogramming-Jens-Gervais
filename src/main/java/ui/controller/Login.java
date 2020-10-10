package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.ArrayList;

public class Login extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        Person person = service.get(userId.toLowerCase());

        if(person == null)
        {
            request.setAttribute("errorLogin", "Invalid account");
        }
        else if(person.isCorrectPassword(request.getParameter("password")))
        {
            HttpSession session = request.getSession();
            session.setAttribute("personLogin", person);
        }
        else
        {
            request.setAttribute("errorLogin", "Invalid account");
        }
        return "/Controller?command=Home";
    }
}
