package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosShopping;

public class StepShoppingNegativo {
	MetodosShopping metodo = new MetodosShopping();

	@Dado("que o usuário faça uma pesquisa de disponibilidade de voo {string}")
	public void queOUsuárioFaçaUmaPesquisaDeDisponibilidadeDeVoo(String url) {
		metodo.iniarGetShopping(url);

	}

	@Quando("preencho uma váriavel negativa para consultar disponibilidade")
	public void preenchoUmaVáriavelNegativaParaConsultarDisponibilidade() {

	}

	@Então("válido statusCode {int}")
	public void válidoStatusCode(Integer statusCode) {
		metodo.validarStatusCode(statusCode);

	}

	@Então("válido código de erro {string} e resposta {string}")
	public void válidoCódigoDeErroEResposta(String erroCod, String msgErro) {
		metodo.validarMensagemErro(erroCod, msgErro);

	}

}
