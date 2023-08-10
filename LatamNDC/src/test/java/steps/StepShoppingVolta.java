package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import metodos.MetodosShopping;

public class StepShoppingVolta {

	MetodosShopping metodo = new MetodosShopping();

	@Dado("que o usuário faça uma pesquisa com a opção ida e volta {string}")
	public void queOUsuárioFaçaUmaPesquisaComAOpçãoIdaEVolta(String url) {
		metodo.iniarGetShoppingIdaVolta(url);

	}

	@Então("se houver passageiro {string} em response pego token de ida {string} e volta {string}")
	public void seHouverPassageiroEmResponsePegoTokenDeIdaEVolta(String passageiro, String AeroportoIda,
			String AeroportoVolta) {

	}

}
