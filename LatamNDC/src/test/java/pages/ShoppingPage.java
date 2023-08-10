package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ShoppingPage {

	private Response response;


	/*
	 * Este método é responsável por enviar uma requisição HTTP GET para a URL
	 * fornecida como parâmetro
	 */
	public void sendGetRequestShopping(String url) {
		response = RestAssured.given().header("Accept", "application/json; charset=utf-8")
				.header("Accept-Charset", "utf-8").header("Content-Type", "application/json; charset=utf-8")
				.header("Gtw-Agency-Id", "").header("Gtw-Agent-Sign", "").header("Gtw-Branch-Id", "9999")
				.header("Gtw-Group-Id", "").header("Gtw-Password", "integracaogw").header("Gtw-Username", "api.support")
				.header("X-Api-Key", "").get(url);
	}

	/*
	 * Esse método serve para fazer request do shoppingService utilizando o espaço
	 * em passagens de ida e volta
	 */
	public void sendGetRequestIdaVoltaSopping(String url) {
		// Substitui os espaços por %20 na URL
		String encodedUrl = url.replace(" ", "%20");

		response = RestAssured.given().header("Accept", "application/json; charset=utf-8")
				.header("Accept-Charset", "utf-8").header("Content-Type", "application/json; charset=utf-8")
				.header("Gtw-Agency-Id", "").header("Gtw-Agent-Sign", "").header("Gtw-Branch-Id", "9999")
				.header("Gtw-Group-Id", "").header("Gtw-Password", "integracaogw").header("Gtw-Username", "api.support")
				.header("X-Api-Key", "").get(encodedUrl);

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
