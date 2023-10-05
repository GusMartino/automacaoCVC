package metodos;

import org.junit.Assert;

import pages.CancellBNPLPage;
import pages.CancellVoidPage;

public class MetodosCancell {

	private CancellBNPLPage cancellBNPLPage;
	private CancellVoidPage cancellVoidPage;

	public MetodosCancell() {
		cancellBNPLPage = new CancellBNPLPage();
		cancellVoidPage = new CancellVoidPage();

	}

	public void iniciarDeleteBNPL(String url, String bookingToken) {
		cancellBNPLPage.sendDeleteRequest(url, bookingToken);

	}

	public void validarStatusCode(int expectedStatusCode) {
		int statusCode = cancellBNPLPage.getStatusCode();
		try {

			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);
		} catch (AssertionError e) {
			String responseBody = cancellBNPLPage.getResponseBody();
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
	
	public void iniciarDeleteVoid(String url, String bookingToken) {
		cancellVoidPage.sendDeleteRequest(url, bookingToken);

	}

	public void validarStatusCodeVoid(int expectedStatusCode) {
		int statusCode = cancellVoidPage.getStatusCode();
		try {

			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);
		} catch (AssertionError e) {
			String responseBody = cancellBNPLPage.getResponseBody();
			String errorMessage = "Erro ao validar Status Code. Esperado: " + expectedStatusCode
					+ ", mas foi recebido: " + statusCode;
			printErrorAndFail(errorMessage, responseBody);
		} catch (Exception e) {
			String responseBody = cancellBNPLPage.getResponseBody();
			String errorMessage = "Erro inesperado ao validar Status Code: " + expectedStatusCode;
			printErrorAndFail(errorMessage, responseBody);
		}
	}
}
