import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultorMoneda {

    public Conversor busquedaMonedas(String moneda1, String moneda2, double cantidad){


        URI direccion  = URI.create("https://v6.exchangerate-api.com/v6/4709c3590726a64830767d6b/pair/"+moneda1+"/"+moneda2+"/"+cantidad); 
        HttpClient client = HttpClient.newHttpClient(); 
        HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion) 
            .build();

        
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(),Conversor.class);

        } catch (Exception e) { 
            throw new RuntimeException("Error");
        }

    }
}
