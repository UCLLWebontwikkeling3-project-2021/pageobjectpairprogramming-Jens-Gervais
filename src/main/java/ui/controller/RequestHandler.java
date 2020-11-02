package ui.controller;

import domain.db.SqlDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected SqlDataBase service;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);

    public void setModel(SqlDataBase service)
    {
        this.service = service;
    }

    public SqlDataBase getService()
    {
        return service;
    }
}
