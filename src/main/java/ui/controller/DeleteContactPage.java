package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteContactPage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("ContactId");
        System.out.println(userid);
        request.setAttribute("ContactUserId", userid);
        return "deleteContactPage.jsp";
    }
}