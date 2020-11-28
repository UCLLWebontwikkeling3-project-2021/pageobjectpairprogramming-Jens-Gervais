package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public class AlterRolePage2 extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
        String userid = request.getParameter("AlterRoleUser");
        Person person = service.get(userid);
        request.setAttribute("UseridRole", userid);
        request.setAttribute("personRole", person);
        return "alterRole.jsp";
    }
}
