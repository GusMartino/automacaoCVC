package steps;

import org.json.JSONObject;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosBookingCreate;
import utilidades.MassaDeDados;

public class StepCreateIda {
	MetodosBookingCreate metodo = new MetodosBookingCreate();
	String rateToken;
	JSONObject requestBody;

	@Dado("que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição {string} junto ao token {string}")
	public void queEuTenhoUmaRequisiçãoDeReservaDeVooUtilizandoOTipoDeRequisiçãoJuntoAoToken(String tipoRequest,
			String bToken) {
		rateToken = MassaDeDados.getRateToken(bToken);
		requestBody = metodo.generateRequestBodyIda(tipoRequest, rateToken);

	}

	@Quando("envio requisição de reserva de voo {string}")
	public void envioRequisiçãoDeReservaDeVoo(String url) {
		metodo.postRequestShopping(url, requestBody);


	}

	@Então("válido Status Code {int} guardando o bookingToken {string}")
	public void válidoStatusCodeGuardandoOBookingToken(Integer statusCode, String bookingTokenCT) {
		metodo.validarStatusCode(statusCode);
		String bookingToken = metodo.pegarBookingToken();
		MassaDeDados.setRateToken(bookingTokenCT, bookingToken);
		metodo.verificarBookingToken();

	}

	@Então("válido localizador {string}")
	public void válidoLocalizador(String reservationCodeCT) {
		String reservationCode = metodo.pegarReservationCode();
		MassaDeDados.setRateToken(reservationCodeCT, reservationCode);
		metodo.verificarReservationCode();

	}

	@Então("válido preço total de reserva {string}")
	public void válidoPreçoTotalDeReserva(String totalOrderPriceCT) {
		Double totalOrderPrice = metodo.pegarTotalOrderPrice();
		MassaDeDados.setNumericValue(totalOrderPriceCT, totalOrderPrice);
		metodo.verificarTotalOrderPrice();

	}
}
