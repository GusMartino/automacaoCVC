package metodos;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import pages.IssuePage;
import utilidades.BodyRequestIssue;

public class MetodosIssue {
	private IssuePage issuePage;
	private BodyRequestIssue bodyRequestIssue;

	public MetodosIssue() {
		issuePage = new IssuePage();
		bodyRequestIssue = new BodyRequestIssue();

	}

	public JSONObject gerarRequestBodyIssue(String requestType, String bToken, double valor) {
		if (requestType.equals("Cartao")) {
			return bodyRequestIssue.generateRequestBodyCartao(bToken, valor);
		} else if (requestType.equals("Cash")) {
			return bodyRequestIssue.generateRequestCash(bToken, valor);
		} else {
			throw new IllegalArgumentException("Tipo de requisição inválido");
		}
	}

	public void postIssue(String url, JSONObject requestBody) {
		issuePage.postRequestShopping(url, requestBody.toString());

	}

	public void validarStatusCode(int expectedStatusCode) {
		int statusCode = issuePage.getStatusCode();
		try {
			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);
		} catch (AssertionError e) {
			String responseBody = issuePage.getResponseBody();
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

	public String pegarStatus() {
		try {
			JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
			JSONArray airBookingsArray = responseJson.getJSONArray("airBookings");

			JSONObject firstAirBookingObject = airBookingsArray.getJSONObject(0);

			JSONObject bookingObject = firstAirBookingObject.getJSONObject("booking");
			String status = bookingObject.getString("status");

			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void verificarStatus(String statusBilhete) {
		String status = pegarStatus();
		if (status == statusBilhete) {
			System.out.println("Valor do status: " + status);
		} else {
			System.out.println("Não foi possível extrair o status de reserva.");
		}
	}

	public String pegarTipoPagamento() {
		try {
			JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
			JSONArray airBookingsArray = responseJson.getJSONArray("airBookings");

			JSONObject firstAirBookingObject = airBookingsArray.getJSONObject(0);
			JSONObject bookingObject = firstAirBookingObject.getJSONObject("booking");
			JSONArray airTicketsArray = firstAirBookingObject.getJSONArray("airTickets");

			JSONObject firstAirTicketObject = airTicketsArray.getJSONObject(0);
			JSONObject paymentsObject = firstAirTicketObject.getJSONArray("payments").getJSONObject(0);

			String type = paymentsObject.getString("type");

			return type;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void verificarTipoPagamento(String tipoEsperado) {
		String tipoPagamento = pegarTipoPagamento();
		if (tipoPagamento != null && tipoPagamento.equals(tipoEsperado)) {
			System.out.println("Tipo de pagamento: " + tipoPagamento);
		} else {
			System.out.println("Não foi possível extrair o tipo de pagamento.");
		}
	}

	public String pegarProvedor() {
		try {
			JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
			JSONArray airBookingsArray = responseJson.getJSONArray("airBookings");

			// Certifique-se de que há pelo menos um elemento no array
			if (airBookingsArray.length() > 0) {
				JSONObject firstAirBookingObject = airBookingsArray.getJSONObject(0);
				JSONObject bookingObject = firstAirBookingObject.getJSONObject("booking");
				JSONObject gdsObject = bookingObject.getJSONObject("gds");

				// Agora você pode pegar o valor de "provider"
				String provider = gdsObject.getString("provider");
				return provider;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void verificarTipoProvedor(String provedorEsperado) {
		String tipoProvedor = pegarProvedor();
		if (tipoProvedor != null && tipoProvedor.equals(provedorEsperado)) {
			System.out.println("Tipo de pagamento: " + tipoProvedor);
		} else {
			System.out.println("Não foi possível extrair o tipo de pagamento.");
		}
	}
}