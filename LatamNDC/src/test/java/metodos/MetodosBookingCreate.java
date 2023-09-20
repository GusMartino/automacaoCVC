package metodos;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import pages.CreatePage;
import utilidades.BodyRequestCreateIda;
import utilidades.BodyRequestCreateVolta;

public class MetodosBookingCreate {
    private CreatePage createPage;
    private BodyRequestCreateIda BodyRequestCreateIda;
    private BodyRequestCreateVolta BodyRequestCreateVolta;


    public MetodosBookingCreate() {
        createPage = new CreatePage();
        BodyRequestCreateIda = new BodyRequestCreateIda();
        BodyRequestCreateVolta = new BodyRequestCreateVolta();

    }

    public JSONObject generateRequestBodyIda(String requestType, String bToken) {
        if (requestType.equals("1")) {
            return BodyRequestCreateIda.generateRequestBody1(bToken);
        } else if (requestType.equals("2")) {
            return BodyRequestCreateIda.generateRequestBody2(bToken);
        } else if (requestType.equals("3")) {
            return BodyRequestCreateIda.generateRequestBody3(bToken);
        } else if (requestType.equals("4")) {
            return BodyRequestCreateIda.generateRequestBody4(bToken);
        } else if (requestType.equals("5")) {
            return BodyRequestCreateIda.generateRequestBody5(bToken);
        } else if (requestType.equals("6")) {
            return BodyRequestCreateIda.generateRequestBody6(bToken);
        } else if (requestType.equals("7")) {
            return BodyRequestCreateIda.generateRequestBody7(bToken);
        } else {    	
            throw new IllegalArgumentException("Tipo de requisição inválido");
        }
    }

    public void postRequestShopping(String url, JSONObject requestBody) {
        createPage.postRequestShopping(url, requestBody.toString());
    }

    public void validarStatusCode(int expectedStatusCode) {
        int statusCode = createPage.getStatusCode();
        try {
            Assert.assertEquals(expectedStatusCode, statusCode);
            System.out.println("Status Code validado é: " + statusCode);
        } catch (AssertionError e) {
            String responseBody = createPage.getResponseBody();
            String errorMessage = "Erro ao validar Status Code. Esperado: " + expectedStatusCode
                    + ", mas foi recebido: " + statusCode;
            printErrorAndFail(errorMessage, responseBody);
        } catch (Exception e) {
            String errorMessage = "Erro inesperado ao validar Status Code: " + expectedStatusCode;
            printErrorAndFail(errorMessage);
        }
    }

    private void printErrorAndFail(String errorMessage) {
        System.err.println(errorMessage);
        Assert.fail(errorMessage);
    }

    private void printErrorAndFail(String errorMessage, String responseBody) {
        System.err.println(errorMessage);
        System.err.println("Resposta do servidor: " + responseBody);
        Assert.fail(errorMessage);
    }

    public String pegarBookingToken() {
        try {
            JSONObject responseJson = new JSONObject(createPage.getResponseBody());
            JSONArray airsArray = responseJson.getJSONObject("booking").getJSONArray("airs");
            
            // Pega o primeiro objeto dentro do array "airs"
            JSONObject firstAirObject = airsArray.getJSONObject(0);
            
            // Pega o valor do bookingToken do objeto
            String bookingToken = firstAirObject.getString("bookingToken");
            
            return bookingToken;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void verificarBookingToken() {
        String bookingToken = pegarBookingToken();
        if (bookingToken == null) {
            System.out.println("Não foi possível extrair o bookingToken.");
        } else {
            System.out.println("Valor do bookingToken: " + bookingToken);
        }
    }
    
    public String pegarReservationCode() {
        try {
            JSONObject responseJson = new JSONObject(createPage.getResponseBody());
            JSONArray airsArray = responseJson.getJSONObject("booking").getJSONArray("airs");
            JSONObject firstAirObject = airsArray.getJSONObject(0); // Assuming there's only one "air" object

            // Pega o objeto "gds" dentro do objeto "airs"
            JSONObject gdsObject = firstAirObject.getJSONObject("gds");

            // Pega o valor do campo "reservationCode" do objeto "gds"
            String reservationCode = gdsObject.getString("reservationCode");

            return reservationCode;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void verificarReservationCode() {
        String reservationCode = pegarReservationCode();
        if (reservationCode == null) {
            System.out.println("Não foi possível extrair o reservationCode.");
        } else {
            System.out.println("Valor do reservationCode: " + reservationCode);
        }
    }
    
    public double pegarTotalOrderPrice() {
        try {
            JSONObject responseJson = new JSONObject(createPage.getResponseBody());
            JSONObject bookingObject = responseJson.getJSONObject("booking");

            double totalOrderPrice = bookingObject.getDouble("totalOrderPrice");
            
            return totalOrderPrice;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    public void verificarTotalOrderPrice() {
        double totalOrderPrice = pegarTotalOrderPrice();
        if (totalOrderPrice == 0.0) {
            System.out.println("Não foi possível extrair o totalOrderPrice.");
        } else {
            System.out.println("Valor do totalOrderPrice: " + totalOrderPrice);
        }
    }
   
    public JSONObject generateRequestBodyVolta(String requestType, String bTokenIda, String bTokenVolta) {
        if (requestType.equals("1")) {
            return BodyRequestCreateVolta.generateRequestBody1(bTokenIda, bTokenVolta);
        } else if (requestType.equals("2")) {
            return BodyRequestCreateVolta.generateRequestBody2(bTokenIda, bTokenVolta);
        } else if (requestType.equals("3")) {
            return BodyRequestCreateVolta.generateRequestBody3(bTokenIda, bTokenVolta);
        } else if (requestType.equals("4")) {
            return BodyRequestCreateVolta.generateRequestBody4(bTokenIda, bTokenVolta);
        } else if (requestType.equals("5")) {
            return BodyRequestCreateVolta.generateRequestBody5(bTokenIda, bTokenVolta);
        } else if (requestType.equals("6")) {
            return BodyRequestCreateVolta.generateRequestBody6(bTokenIda, bTokenVolta);
        } else if (requestType.equals("7")) {
            return BodyRequestCreateVolta.generateRequestBody7(bTokenIda, bTokenVolta);
        } else {    	
            throw new IllegalArgumentException("Tipo de requisição inválido");
        }
    }

}