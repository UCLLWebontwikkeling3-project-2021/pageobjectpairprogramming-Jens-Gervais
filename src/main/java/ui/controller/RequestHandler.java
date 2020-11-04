package ui.controller;

import domain.db.SqlDataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

public abstract class RequestHandler {
    protected SqlDataBase service;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException;

    public void setModel(SqlDataBase service)
    {
        this.service = service;
    }

    public SqlDataBase getService()
    {
        return service;
    }
}
