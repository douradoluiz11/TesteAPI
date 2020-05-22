package br.com.brasilprev.actions;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import br.com.brasilprev.models.ModelsGet;
import br.com.brasilprev.models.ModelsPost;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Actions {

	public String PreenchePostBody() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;

		String postBody = "{\r\n" + "\"codigo\": 0,\r\n" + "\"nome\": \"" + ModelsPost.nome + "\",\r\n" + "\"cpf\": \""
				+ ModelsPost.cpf + "\",\r\n" + "\"enderecos\": [\r\n" + "{\r\n" + "\"logradouro\": \"" + ModelsPost.logradouro
				+ "\",\r\n" + "\"numero\": \"" + ModelsPost.num + "\",\r\n" + "\"complemento\": \"" + ModelsPost.complemento
				+ "\",\r\n" + "\"bairro\": \"" + ModelsPost.bairro + "\",\r\n" + "\"cidade\": \"" + ModelsPost.cidade
				+ "\",\r\n" + "\"estado\": \"" + ModelsPost.estado + "\"\r\n" + "}\r\n" + "],\r\n" + "\"telefones\": [\r\n"
				+ "{\r\n" + "\"ddd\": \"" + ModelsPost.ddd + "\",\r\n" + "\"numero\": \"" + ModelsPost.cel + "\"\r\n" + "}]\r\n"
				+ "}";
		
		
		return postBody;
	}

	public String ValidaResponse(int statusCode) {

		Response response = 
				given()
				.contentType("application/json; charset=UTF-8")
				.body(PreenchePostBody())
				.when()
				.post("/pessoas")
				.then()
				.statusCode(statusCode)
				.contentType("application/json; charset=UTF-8")
				.extract()
				.response();
		
				

		String resultResponse = response.asString();
		
		
		return resultResponse;

	}
	
	public String ExecutaGet() {
		

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		String get = "/pessoas/"+ ModelsGet.ddd +"/" + ModelsGet.cel;
		
		
		return get;
		
		
	}
	
	public String ValidaResposeGet (int statusCode) {
		
	
		
		
		Response response = 
				given()
				.contentType("application/json; charset=UTF-8")
				.when()
				.get(ExecutaGet())
				.then()
				.statusCode(statusCode)
				.contentType("application/json; charset=UTF-8")
				.extract()
				.response();
		
				

		String resultResponse = response.asString();
		
		
		return resultResponse;
		
	}

}
