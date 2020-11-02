package ui.controller;

import domain.db.SqlDataBase;

public class HandlerFactory {
    public RequestHandler getHandler(String command, SqlDataBase service)
    {
        RequestHandler handler = null;

        try {
            Class handlerClass = Class.forName("ui.controller." + command);
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(service);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Deze pagina bestaat niet.");
        }
        return handler;
    }
}
