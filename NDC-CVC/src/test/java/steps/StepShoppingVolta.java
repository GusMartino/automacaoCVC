package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosShopping;
import utilidades.MassaDeDados;

public class StepShoppingVolta {

	MetodosShopping metodo = new MetodosShopping();

	@Dado("que o usuário faça uma pesquisa com a opção ida e volta {string}")
	public void queOUsuárioFaçaUmaPesquisaComAOpçãoIdaEVolta(String url) {
		metodo.iniarGetShopping(url);
	}

	@Quando("valido status code {int}")
	public void validoStatusCode(Integer statusCode) {
		metodo.validarStatusCode(statusCode);

	}

	@Então("válido em body response aeroporto de ida {string}")
	public void válidoEmBodyResponseAeroportoDeIda(String aeroportoIda) {
		metodo.validarAeroportoPartida(aeroportoIda);

	}

	@Então("válido em body response aeroporto chegada e volta {string}")
	public void válidoEmBodyResponseAeroportoChegadaEVolta(String aeroportoChegada) {
		metodo.validarAeroportoChegada(aeroportoChegada);

	}

	@Então("se houver passageiro {string} em response seleciono a companhia aérea {string} pego token de ida {string} {string} e volta {string} {string}")
	public void seHouverPassageiroEmResponseSelecionoACompanhiaAéreaPegoTokenDeIdaEVolta(String passageiro,
			String companyName, String aeroportoIda, String tokenIdaCT, String aeroportoVolta, String tokenVoltaCT) {

		metodo.validarPassageiroPrincipal(passageiro);
		String rateTokenIda = metodo.pegarRateTokenPorVoo(aeroportoIda, aeroportoVolta, companyName);
		metodo.verificarRateToken(rateTokenIda, companyName);
		MassaDeDados.setRateToken(tokenIdaCT, rateTokenIda);

		String rateTokenVolta = metodo.pegarRateTokenPorVoo(aeroportoVolta, aeroportoIda, companyName);
		System.out.println("O valor do rate Token de volta: " + rateTokenVolta);
		MassaDeDados.setRateToken(tokenVoltaCT, rateTokenVolta);
	}

	@Então("válido em body response passageiro alternativo {string}")
	public void válidoEmBodyResponsePassageiroAlternativo(String passageiro) {
		metodo.validarPassageiro(passageiro);

	}

	@Então("válido em body response quantidade de passageiros alternativos {int} {string}")
	public void válidoEmBodyResponseQuantidadeDePassageirosAlternativos(Integer qntPassageiros,
			String tipoPassageiros) {
		metodo.validarQuantidade(qntPassageiros, tipoPassageiros);

	}

	@Então("válido em body response quantidade de passageiros no total {int} {string}")
	public void válidoEmBodyResponseQuantidadeDePassageirosNoTotal(Integer qntPassageiros, String tipoPassageiros) {
		metodo.validarQuantidade(qntPassageiros, tipoPassageiros);

	}

}
