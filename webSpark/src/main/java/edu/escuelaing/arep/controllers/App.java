package edu.escuelaing.arep.controllers;

import com.google.gson.Gson;
import edu.escuelaing.arep.services.MessageService;
import static spark.Spark.*;

/**
 * Web spark app
 */
public class App 
{

    /**
     * Initialize the spark application by publishing a get method used to read all messages
     * and a post method to publish a message
     * @param args
     */
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

    /**
     * return the port to be used
     * @return the port to be used
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6001;
    }
}
