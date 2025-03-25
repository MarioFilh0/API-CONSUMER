package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Api {
	
	Endereco end = new Endereco();
	
	public Endereco getEndereco(String cep) {
		try{
			HttpClient client = HttpClient.newHttpClient();
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/")).build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			ObjectMapper mapper = new ObjectMapper();
			
			end = mapper.readValue(response.body(), Endereco.class);
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		return end;
		
	
	}
}
