package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosPricing;
import utilidades.MassaDeDados;

public class StepPricingIda {

	MetodosPricing metodo = new MetodosPricing();
	String rateToken;

	@Dado("seleciono rateToken {string} e inicio chamada em API {string}")
	public void selecionoRateTokenEInicioChamadaEmAPI(String tokenCT, String url) {
		String rateToken = MassaDeDados.getRateToken(tokenCT);
		metodo.iniarGetPricingIda(url, rateToken);

	}

	@Quando("válido status code {int}")
	public void válidoStatusCode(Integer statusCode) {
		metodo.validarStatusCode(200);

	}

	@Então("válido em body response chegada no aeropoto {string}")
	public void válidoEmBodyResponseChegadaNoAeropoto(String aeropotoChegada) {
		metodo.validarAeroportoChegada(aeropotoChegada);

	}

	@Então("guardo rateToken para utilizar em booking {string}")
	public void guardoRateTokenParaUtilizarEmBooking(String BTokenCT) {
		String rateToken = metodo.pegarRateToken(BTokenCT);
		MassaDeDados.setRateToken(BTokenCT, rateToken);
		metodo.verificarRateToken(BTokenCT);

	}
}
