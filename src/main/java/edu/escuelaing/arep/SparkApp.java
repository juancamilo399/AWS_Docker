package edu.escuelaing.arep;

import static spark.Spark.*;

public class SparkApp {

    public static void main(String[] args) {
        port(getPort());
        get("/hello", (req, res) -> "Hello world Docker");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;

    }
}