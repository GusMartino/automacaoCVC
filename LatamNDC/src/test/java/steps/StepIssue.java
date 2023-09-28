package steps;

import org.json.JSONObject;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosIssue;
import utilidades.MassaDeDados;

public class StepIssue {

	MetodosIssue metodo = new MetodosIssue();
	String bookingToken;
	double totalOrderPrice;
	JSONObject requestBody;

	@Dado("que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva {string} junto a valor de emissão {string}")
	public void queEuTenhoUmaRequisiçãoDeEmissãoDeVooUtilizandoOTipoDeRequestComOTokenDeReservaJuntoAValorDeEmissão(
			String bookingTokenCT, String totalOrderPriceCT) {
		bookingToken = MassaDeDados.getRateToken(bookingTokenCT);
		totalOrderPrice = MassaDeDados.getNumericValue(totalOrderPriceCT);


	}

	@Quando("seleciono tipo de pagamento {string}")
	public void selecionoTipoDePagamento(String tipoPagamento) {
		requestBody = metodo.gerarRequestBodyIssue(tipoPagamento, bookingToken, totalOrderPrice);
	}

	@Quando("envio requisição de emissão do voo {string}")
	public void envioRequisiçãoDeEmissãoDoVoo(String url) {
		metodo.postIssue(url, requestBody);
		System.out.println(requestBody);

	}

	@Então("válido Status Code {int} junto ao status de bilhete {string}")
	public void válidoStatusCodeJuntoAoStatusDeBilhete(Integer statusCode, String statusReservaCT) {
		metodo.validarStatusCode(statusCode);
		metodo.pegarStatus();
		metodo.verificarStatus(statusReservaCT);
	}

	@Então("válido tipo de pagamento {string} junto ao provedor {string}")
	public void válidoTipoDePagamentoJuntoAoProvedor(String tipoPagamento, String provedor) {
		metodo.pegarTipoPagamento();
		metodo.verificarTipoPagamento(tipoPagamento);
		metodo.pegarProvedor();
		metodo.verificarTipoProvedor(provedor);

	}
}
