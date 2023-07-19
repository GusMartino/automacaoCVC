package pages;

import io.restassured.response.Response;
import io.restassured.RestAssured;

public class ShoppingPage {

    private Response response;

    public void sendGetRequest(String url) {
        response = RestAssured.given()
            .header("Accept", "application/json; charset=utf-8")
            .header("Accept-Charset", "utf-8")
            .header("Content-Type", "application/json; charset=utf-8")
            .header("Gtw-Agency-Id", "")
            .header("Gtw-Agent-Sign", "")
            .header("Gtw-Branch-Id", "9999")
            .header("Gtw-Group-Id", "")
            .header("Gtw-Password", "integracaogw")
            .header("Gtw-Username", "api.support")
            .header("X-Api-Key", "")
            .get(url);
    }

    public int getStatusCode() {
        return response.getStatusCode();
        
    }

    public String getResponseBody() {
        return response.getBody().asPrettyString();
    }

    public boolean responseBodyContains(String word) {
        String responseBody = getResponseBody();
        return responseBody.contains(word);
    }
}
