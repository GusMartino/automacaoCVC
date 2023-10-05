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
			handleAssertionError(expectedStatusCode, statusCode);
		} catch (Exception e) {
			handleUnexpectedError(expectedStatusCode);
		}
	}

	private void handleAssertionError(int expectedStatusCode, int actualStatusCode) {
		String errorMessage = "Erro ao validar Status Code. Esperado: " + expectedStatusCode + ", mas foi recebido: "
				+ actualStatusCode;
		printErrorAndFail(errorMessage, issuePage.getResponseBody());
	}

	private void handleUnexpectedError(int expectedStatusCode) {
		String errorMessage = "Erro inesperado ao validar Status Code: " + expectedStatusCode;
		printErrorAndFail(errorMessage);
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
		JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
		JSONArray airTicketsArray = responseJson.getJSONArray("airTickets");

		if (airTicketsArray.length() > 0) {
			JSONObject firstAirTicketObject = airTicketsArray.getJSONObject(0);
			return firstAirTicketObject.getString("status");
		} else {
			return null;
		}
	}

	public void verificarStatus(String statusBilhete) {
		String status = pegarStatus();
		if (status != null && status.equals(statusBilhete)) {
			System.out.println("Status da reserva: " + status);
		} else {
			System.out.println("Não foi possível extrair o status da reserva.");
		}
	}

	public String pegarTipoPagamento() {
		JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
		JSONArray airTicketsArray = responseJson.getJSONArray("airTickets");

		if (airTicketsArray.length() > 0) {
			JSONObject firstAirTicketObject = airTicketsArray.getJSONObject(0);
			JSONArray paymentsArray = firstAirTicketObject.getJSONArray("payments");

			if (paymentsArray.length() > 0) {
				JSONObject paymentsObject = paymentsArray.getJSONObject(0);
				return paymentsObject.getString("type");
			}
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
		JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
		JSONArray airTicketsArray = responseJson.getJSONArray("airTickets");

		if (airTicketsArray.length() > 0) {
			JSONObject firstAirTicketObject = airTicketsArray.getJSONObject(0);
			JSONObject gdsObject = firstAirTicketObject.getJSONObject("gds");

			return gdsObject.getString("provider");
		}
		return null;
	}

	public void verificarTipoProvedor(String provedorEsperado) {
		String tipoProvedor = pegarProvedor();
		if (tipoProvedor != null && tipoProvedor.equals(provedorEsperado)) {
			System.out.println("Provedor selecionado: " + tipoProvedor);
		} else {
			System.out.println("Não foi possível extrair o provedor.");
		}
	}

	public String pegarLocalizador() {
		JSONObject responseJson = new JSONObject(issuePage.getResponseBody());
		JSONArray airTicketsArray = responseJson.getJSONArray("airTickets");

		if (airTicketsArray.length() > 0) {
			JSONObject firstAirTicketObject = airTicketsArray.getJSONObject(0);
			JSONObject gdsObject = firstAirTicketObject.getJSONObject("gds");
			String reservationCode = gdsObject.getString("reservationCode");
			System.out.println("Valor do localizador: " + reservationCode);

			return reservationCode;
		}
		return null;
	}
}