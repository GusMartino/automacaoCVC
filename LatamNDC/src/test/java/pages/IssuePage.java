package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class IssuePage {
	
	private Response response;

	public void postRequestShopping(String url, String bodyRequest) {

		response = RestAssured.given()  .header("Accept", "application/json; charset=utf-8")
                .header("Accept-Charset", "utf-8")
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Gtw-Branch-Id", "9999")
                .header("Gtw-Password", "integracaogw")
                .header("Gtw-Username", "api.support")
                .body(bodyRequest)
                .post(url);
	}

	public int getStatusCode() {
		return response.getStatusCode();

	}

	public String getResponseBody() {
		return response.getBody().asPrettyString();
	}
	
	public boolean responseBodyContains(String palavra) {
		String responseBody = getResponseBody();
		return responseBody.contains(palavra);
	}
}
