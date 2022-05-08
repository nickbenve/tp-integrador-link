package ar.tp.integrador.link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import app.Precio;

public class CalculadorPrecioDolar implements Precio{

	private HttpResponse hola;
	//	("http://api-dolar-argentina.herokuapp.com/api/dolaroficial");
	@Override
	public Float calcularPrecio(Float a) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create("http://api-dolar-argentina.herokuapp.com/api/dolaroficial")).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
		.thenAccept(System.out::println)
		.join();
//		https://www.youtube.com/watch?v=qzRKa8I36Ww
		return a;
		
	}

	

    
   
    
//	@Override
//	public Float calcularPrecio(Float a) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
