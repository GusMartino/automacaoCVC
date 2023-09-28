package steps;

import org.json.JSONObject;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosBookingCreate;
import utilidades.MassaDeDados;

public class StepCreateVolta {

	MetodosBookingCreate metodo = new MetodosBookingCreate();
	String rateToken;
	JSONObject requestBody;

	@Dado("que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição {string} junto aos tokens {string} e {string}")
	public void queEuTenhoUmaRequisiçãoDeReservaDeVooUtilizandoOTipoDeRequisiçãoJuntoAosTokensE(String tipoRequest,
			String bTokenIda, String bTokenVolta) {
		bTokenIda = MassaDeDados.getRateToken(bTokenIda);
		bTokenVolta = MassaDeDados.getRateToken(bTokenVolta);
		requestBody = metodo.generateRequestBodyVolta(tipoRequest, bTokenIda, bTokenVolta);

	}

	@Quando("envio requisição de reserva de voo ida e volta {string}")
	public void envioRequisiçãoDeReservaDeVooIdaEVolta(String url) {
		metodo.postRequestShopping(url, requestBody);

	}

	@Então("válido Status Code {int} junto a bookingToken {string}")
	public void válidoStatusCodeJuntoABookingToken(Integer statusCode, String bookingTokenCT) {
		metodo.validarStatusCode(statusCode);
		String bookingToken = metodo.pegarBookingToken();
		MassaDeDados.setRateToken(bookingTokenCT, bookingToken);
		metodo.verificarBookingToken();
	}

	@Então("guardo localizador {string}")
	public void guardoLocalizador(String reservationCodeCT) {
		String reservationCode = metodo.pegarReservationCode();
		MassaDeDados.setRateToken(reservationCodeCT, reservationCode);
		metodo.verificarReservationCode();
	}

	@Então("guardo preço total de reserva {string}")
	public void guardoPreçoTotalDeReserva(String totalOrderPriceCT) {
		Double totalOrderPrice = metodo.pegarTotalOrderPrice();
		MassaDeDados.setNumericValue(totalOrderPriceCT, totalOrderPrice);
		metodo.verificarTotalOrderPrice();
	}

}
