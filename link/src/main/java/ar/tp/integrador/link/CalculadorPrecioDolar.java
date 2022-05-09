package ar.tp.integrador.link;




import app.Precio;


public class CalculadorPrecioDolar implements Precio{

	
	
	
	//	("http://api-dolar-argentina.herokuapp.com/api/dolaroficial");
	@Override
	public Float calcularPrecio(Float a) {
		
	
		
		return a;
//		HttpClient client = HttpClient.newHttpClient();
//		HttpRequest request=HttpRequest.newBuilder().uri(URI.create("http://api-dolar-argentina.herokuapp.com/api/dolaroficial")).build();
//		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//		.thenApply(HttpResponse::body)
//		.thenAccept(System.out::println)
//		.join();
////		https://www.youtube.com/watch?v=qzRKa8I36Ww
//		return a;
		
	}

	

    
   
    
//	@Override
//	public Float calcularPrecio(Float a) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
