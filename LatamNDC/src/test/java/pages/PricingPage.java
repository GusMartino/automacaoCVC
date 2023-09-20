package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PricingPage {

	private Response response;

	public void iniciarGetRequestPricingIda(String url, String tokenCT) {
		response = RestAssured.given().header("Accept", "application/json; charset=utf-8")
				.header("Accept-Charset", "utf-8").header("Content-Type", "application/json; charset=utf-8")
				.header("Gtw-Agency-Id", "").header("Gtw-Agent-Sign", "").header("Gtw-Branch-Id", "9999")
				.header("Gtw-Group-Id", "").header("Gtw-Password", "integracaogw")
				.header("Gtw-Tokenized-Rate-Tokens", tokenCT).header("Gtw-Username", "api.support")
				.header("X-Api-Key", "").get(url);
		
	}

	public void iniciarGetRequestPricingVolta(String url, String tokenIda, String tokenVolta) {
		response = RestAssured.given().header("Accept", "application/json; charset=utf-8")
				.header("Accept-Charset", "utf-8").header("Content-Type", "application/json; charset=utf-8")
				.header("Gtw-Agency-Id", "").header("Gtw-Agent-Sign", "").header("Gtw-Branch-Id", "9999")
				.header("Gtw-Group-Id", "").header("Gtw-Password", "integracaogw")
				.header("Gtw-Tokenized-Rate-Tokens", tokenIda + "," + tokenVolta).header("Gtw-Username", "api.support")
				.header("X-Api-Key", "").get(url);
	}

	/*
	 * Este método retorna o código de status (status code) da resposta da
	 * requisição feita anteriormente.
	 */
	public int getStatusCode() {
		return response.getStatusCode();

	}

	/* Este método retorna o corpo da resposta da requisição feita anteriormente */
	public String getResponseBody() {
		return response.getBody().asPrettyString();
	}

	/*
	 * Este método verifica se a resposta da requisição contém uma determinada
	 * palavra
	 */
	public boolean responseBodyContains(String palavra) {
		String responseBody = getResponseBody();
		return responseBody.contains(palavra);
	}

}
