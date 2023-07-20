package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.Metodos;

public class StepShoppingIda {

	Metodos metodo = new Metodos();

	@Dado("que o usuário faça uma pesquisa com a opção só ida {string}")
	public void queOUsuárioFaçaUmaPesquisaComAOpçãoSóIda(String url) {
		metodo.iniarGet(url);
		

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

	@Então("válido em body response se há passageiro {string}")
	public void válidoEmBodyResponseSeHáPassageiro(String passageiro) {
		metodo.validarPassageiroPrincipal(passageiro);
		metodo.pegarRateToken();
		metodo.verificarRateToken();
		

	}

	@Então("válido em body response passageiro {string}")
	public void válidoEmBodyResponsePassageiro(String passageiro) {
		metodo.validarPassageiro(passageiro);

	}

		@Então("válido em body response quantidade de passageiros {int}")
		public void válidoEmBodyResponseQuantidadeDePassageiros(Integer int1) {
			metodo.validarQuantidade(int1);

		}
}