package edu.escuelaing.arep;

import static spark.Spark.*;

public class App 
{


    public static void main( String[] args )
    {
        port(getPort());
        staticFileLocation("/static");
        Client client=new Client();
        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/mensajes",(req, res) -> {
            res.status(200);
            res.type("application/json");
            String response=client.getMessages("/mensajes");
            client.roundRobin();
            return response;
        });

        post("/mensajes",(request, response) -> {
            client.postMessage(request.body(),"/mensajes");
            client.roundRobin();
            return "";
        });


    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 6002;
    }
}
