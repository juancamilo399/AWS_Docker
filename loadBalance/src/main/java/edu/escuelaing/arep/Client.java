package edu.escuelaing.arep;

import okhttp3.*;

import java.io.IOException;


public class Client {

    private OkHttpClient httpClient;
    private String baseUrl="http://192.168.99.100:";
    private String[] ports={"8085","8086","8087"};
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private int serverNumber=0;

    public Client() {
        httpClient=new OkHttpClient();
    }


    /**
     *
     * @param path The corresponding path to which the method would be carried out
     * @return the response of the method
     * @throws IOException
     */
    public String getMessages(String path) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     *
     * @param message The message to apply to the post method
     * @param path The corresponding path to which the method would be carried out
     * @return the response of the method
     * @throws IOException
     */
    public String postMessage( String message,String path) throws IOException {
        RequestBody body = RequestBody.create(message,JSON);
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * Logic of round robin load balancer
     */
    public void roundRobin(){
        this.serverNumber= (this.serverNumber+1)% ports.length;
    }
}
