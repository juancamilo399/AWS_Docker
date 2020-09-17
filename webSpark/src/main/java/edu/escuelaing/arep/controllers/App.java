package edu.escuelaing.arep.controllers;

import com.google.gson.Gson;
import edu.escuelaing.arep.services.MessageService;
import static spark.Spark.*;

public class App 
{

    public static void main( String[] args )
    {
        MessageService messageService= new MessageService();
        port(getPort());

        get("/mensajes",(request, response) -> {
            response.status(200);
            response.type("application/json");
            return new Gson().toJson(messageService.getAllMessages());
        });

        post("/mensajes",(request, response) -> {
            messageService.addMessage(request.body());
            return "";
        });

    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6001;
    }
}
