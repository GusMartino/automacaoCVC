package utilidades;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodyRequestIssue {
	
	public JSONObject generateRequestBodyCartao(String bookingToken, double valor) {
	    JSONObject address = new JSONObject()
	        .put("city", "SAO PAULO")
	        .put("number", "227")
	        .put("state", "SP")
	        .put("street", "Rua Catequese");

	    JSONObject emitter = new JSONObject()
	        .put("address", address)
	        .put("birthDate", "1996-03-08")
	        .put("documents", JSONObject.NULL)
	        .put("email", "terminal@gwterminal.com")
	        .put("firstName", "Gw")
	        .put("lastName", "Terminal")
	        .put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55)));

	    JSONObject payment = new JSONObject()
	        .put("creditCardPayment", new JSONObject()
	            .put("creditCard", new JSONObject()
	                .put("expirationMonth", 3)
	                .put("expirationYear", 2030)
	                .put("name", "Gustavo Evaristo")
	                .put("number", "4000000000002701")
	                .put("operatorCode", "VISA")
	                .put("securityCode", "737"))
	            .put("firstInstallmentValue", JSONObject.NULL)
	            .put("installments", 1))
	        .put("type", "CREDITCARD")
	        .put("value", valor);

	    return new JSONObject()
	        .put("bookingToken", bookingToken)
	        .put("emitter", emitter)
	        .put("paxs", JSONObject.NULL)
	        .put("payment", payment);
	}
	
	public JSONObject generateRequestCash(String bookingToken, double valor) {
	    JSONObject address = new JSONObject()
	        .put("city", "SAO PAULO")
	        .put("number", "227")
	        .put("state", "SP")
	        .put("street", "Rua Catequese");

	    JSONObject emitter = new JSONObject()
	        .put("address", address)
	        .put("birthDate", "1996-03-08")
	        .put("documents", JSONObject.NULL)
	        .put("email", "terminal@gwterminal.com")
	        .put("firstName", "Gw")
	        .put("lastName", "Terminal")
	        .put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55)));

	    JSONObject payment = new JSONObject()
	        .put("creditCardPayment", new JSONObject()
	            .put("firstInstallmentValue", JSONObject.NULL)
	            .put("installments", JSONObject.NULL))
	        .put("type", "INVOICE")
	        .put("value", valor);

	    return new JSONObject()
	        .put("bookingToken", bookingToken)
	        .put("emitter", emitter)
	        .put("paxs", JSONObject.NULL)
	        .put("payment", payment);
	}
}
