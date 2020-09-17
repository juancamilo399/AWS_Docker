package edu.escuelaing.arep;

import okhttp3.*;

import java.io.IOException;


public class Client {

    private OkHttpClient httpClient;
    private String baseUrl="http://ip-172-31-82-68.ec2.internal:";
    private String[] ports={"8085","8086","8087"};
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private int serverNumber=0;

    public Client() {
        httpClient=new OkHttpClient();
    }


    public String getMessages(String path) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .get()
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String postMessage( String message,String path) throws IOException {
        RequestBody body = RequestBody.create(message,JSON);
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .post(body)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }
    public void roundRobin(){
        this.serverNumber= (this.serverNumber+1)% ports.length;
    }
}
