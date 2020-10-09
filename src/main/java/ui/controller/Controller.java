package ui.controller;

import domain.db.PersonService;
import domain.model.ContactTracingService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends javax.servlet.http.HttpServlet {
    public Controller() {
        super();
    }

    private PersonService service = new PersonService();
    private HandlerFactory handlerFactory = new HandlerFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        if (command != null) {
            try {
                RequestHandler handler = handlerFactory.getHandler(command, service);
                destination = handler.handleRequest(request, response);
            } catch (Exception exc) {
                request.setAttribute("error", exc.getMessage());
                destination = "error.jsp";
            }
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}
