package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosShopping;
import utilidades.MassaDeDados;

public class StepShoppingIda {

	MetodosShopping metodo = new MetodosShopping();
	String rateToken;

	@Dado("que o usuário faça uma pesquisa com a opção só ida {string}")
	public void queOUsuárioFaçaUmaPesquisaComAOpçãoSóIda(String url) {
		metodo.iniarGetShopping(url);

	}

	@Quando("valido status code de response {int}")
	public void validoStatusCodeDeResponse(int expectedStatusCode) {
		metodo.validarStatusCode(expectedStatusCode);

	}

	@Então("válido em body response aeroporto saída {string}")
	public void válidoEmBodyResponseAeroportoSaída(String aeroportoSaída) {
		metodo.validarAeroportoPartida(aeroportoSaída);

	}

	@Então("válido em body response aeroporto chegada {string}")
	public void válidoEmBodyResponseAeroportoChegada(String aeroportoChegada) {
		metodo.validarAeroportoChegada(aeroportoChegada);

	}


		@Então("guardo o rateToken {string} da companhia aérea esperada {string}")
		public void guardoORateTokenDaCompanhiaAéreaEsperada(String tokenCT, String companyName) {
			
		String rateToken = metodo.pegarRateToken(tokenCT, companyName);
		metodo.verificarRateToken(tokenCT, companyName);
		MassaDeDados.setRateToken(tokenCT, rateToken);

	}

	@Então("válido em body response passageiro {string}")
	public void válidoEmBodyResponsePassageiro(String passageiro) {
		metodo.validarPassageiro(passageiro);

	}

	@Então("válido em body response quantidade de passageiros {int} {string}")
	public void válidoEmBodyResponseQuantidadeDePassageiros(Integer qntPassageiros, String tipoPassageiros) {
		metodo.validarQuantidade(qntPassageiros, tipoPassageiros);
	}
}