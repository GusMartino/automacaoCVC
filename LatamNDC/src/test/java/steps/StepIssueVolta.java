package steps;

import org.json.JSONObject;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosIssue;
import utilidades.MassaDeDados;

public class StepIssueVolta {

	MetodosIssue metodo = new MetodosIssue();
	String bookingToken;
	double totalOrderPrice;
	JSONObject requestBody;

	@Dado("que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva {string} junto a valor de emissão {string}")
	public void queEuTenhoUmaRequisiçãoDeEmissãoDooVooIdaEVoltaComOTokenDeReservaJuntoAValorDeEmissão(
			String bookingTokenVoltaCT, String totalOrderPriceVoltaCT) {
		bookingToken = MassaDeDados.getRateToken(bookingTokenVoltaCT);
		totalOrderPrice = MassaDeDados.getNumericValue(totalOrderPriceVoltaCT);

	}

	@Quando("seleciono tipo de pagamento válido {string}")
	public void selecionoTipoDePagamentoVálido(String tipoPagamento) {
		requestBody = metodo.gerarRequestBodyIssue(tipoPagamento, bookingToken, totalOrderPrice);

	}

	@Quando("envio requisição de emissão para o voo {string}")
	public void envioRequisiçãoDeEmissãoParaOVoo(String url) {
		metodo.postIssue(url, requestBody);

	}

	@Então("válido Status Code {int} junto ao status de bilhete do voo {string}")
	public void válidoStatusCodeJuntoAoStatusDeBilheteDoVoo(Integer statusCode, String statusReservaCT) {
		metodo.validarStatusCode(statusCode);
		metodo.pegarStatus();
		metodo.verificarStatus(statusReservaCT);
	}

	@Então("válido tipo de pagamento {string} junto ao provedor encontrado {string}")
	public void válidoTipoDePagamentoJuntoAoProvedorEncontrado(String tipoPagamento, String provedor) {
		metodo.pegarTipoPagamento();
		metodo.verificarTipoPagamento(tipoPagamento);
		metodo.pegarProvedor();
		metodo.verificarTipoProvedor(provedor);
	}
}
