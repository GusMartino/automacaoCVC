package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosPricing;
import utilidades.MassaDeDados;

public class StepPricingVolta {

	MetodosPricing metodo = new MetodosPricing();
	String rateTokenIda;
	String rateTokenVolta;

	@Dado("que seleciono rateToken de ida {string} junto a token de volta {string} e inicio chamada em API {string}")
	public void queSelecionoRateTokenDeIdaJuntoATokenDeVoltaEInicioChamadaEmAPI(String tokenIdaCT01,
			String tokenVoltaCT02, String url) {
		String rateTokenIda = MassaDeDados.getRateToken(tokenIdaCT01);
		String rateTokenVolta = MassaDeDados.getRateToken(tokenVoltaCT02);
		metodo.iniarGetPricingVolta(url, rateTokenIda, rateTokenVolta);

	}

	@Quando("válido status code em response {int}")
	public void válidoStatusCodeEmResponse(Integer statusCode) {
		metodo.validarStatusCode(statusCode);
	}

	@Então("válido em body response chegada na ida no aeropoto {string}")
	public void válidoEmBodyResponseChegadaNaIdaNoAeropoto(String aeropotoChegadaEmIda) {
		metodo.validarAeroportoChegada(aeropotoChegadaEmIda);

	}

	@Então("guardo rateToken de ida {string} {string} e volta {string} {string} para utilizar em booking")
	public void guardoRateTokenDeIdaEVoltaParaUtilizarEmBooking(String aeroportoIda, String bTokenIda,
			String aeroportoVolta, String bTokenVolta) {
		String rateTokenIda = metodo.pegarRateTokenPorVoo(aeroportoIda, aeroportoVolta);
		metodo.verificarRateToken(bTokenIda);
		MassaDeDados.setRateToken(bTokenIda, rateTokenIda);

		String rateTokenVolta = metodo.pegarRateTokenPorVoo(aeroportoVolta, aeroportoIda);
		metodo.verificarRateToken(bTokenVolta);
		MassaDeDados.setRateToken(bTokenVolta, rateTokenVolta);

	}
}
