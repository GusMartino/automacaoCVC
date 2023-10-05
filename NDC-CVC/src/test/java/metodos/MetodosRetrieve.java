package metodos;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import pages.RetrievePage;

public class MetodosRetrieve {

	private static RetrievePage retrievePage;

	public MetodosRetrieve() {
		retrievePage = new RetrievePage();

	}

	public void iniciarGetRetrieve(String url, String reservationCode) {
		retrievePage.sendGet(url, reservationCode);

	}

	public void validarStatusCode(int expectedStatusCode) {
		int statusCode = retrievePage.getStatusCode();
		try {
			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);
		} catch (AssertionError e) {
			String responseBody = retrievePage.getResponseBody();
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

	public boolean validarStatus(String statusBilhete) {
		try {
			JSONObject responseJson = new JSONObject(retrievePage.getResponseBody());
			JSONArray airBookingsArray = responseJson.getJSONArray("airBookings");
			JSONObject firstAirBooking = airBookingsArray.getJSONObject(0);
			String status = firstAirBooking.getJSONObject("booking").getString("status");

			boolean statusValido = status.equals(statusBilhete);

			if (statusValido) {
				System.out.println("O status do bilhete é válido: " + status);
			} else {
				System.err.println("O status do bilhete não é válido: " + status);
			}

			return statusValido;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
