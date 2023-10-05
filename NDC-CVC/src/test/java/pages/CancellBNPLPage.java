package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CancellBNPLPage {
    private Response response;

    public void sendDeleteRequest(String baseUrl, String bookingToken) {
        String url = baseUrl + bookingToken;

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
            .delete(url);
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        return response.getBody().asPrettyString();
    }
}


