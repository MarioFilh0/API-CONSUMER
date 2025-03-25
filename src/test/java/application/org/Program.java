package application.org;

import services.Api;
import services.Endereco;

public class Program {

	public static void main(String[] args) {
		
		Api api = new Api();
		
		try {
			Endereco end = api.getEndereco("01001000");
			System.out.println(end);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
