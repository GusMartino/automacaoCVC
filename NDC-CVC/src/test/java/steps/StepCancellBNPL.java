package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosCancell;
import utilidades.MassaDeDados;

public class StepCancellBNPL {
	
	MetodosCancell metodo = new MetodosCancell();
	String bookingToken;


	@Dado("que eu utilize o {string} para cancelar minha reserva")
	public void queEuUtilizeOParaCancelarMinhaReserva(String bookingTokenCT) {
		bookingToken = MassaDeDados.getRateToken(bookingTokenCT);
	
	}

	@Quando("envio requisição para a url {string}")
	public void envioRequisiçãoParaAUrl(String url) {
		metodo.iniciarDeleteBNPL(url, bookingToken);

	}

	@Então("válido Status Code {int} para confirmar sucesso em cancelamento")
	public void válidoStatusCodeParaConfirmarSucessoEmCancelamento(Integer statusCode) {
		metodo.validarStatusCode(statusCode);

	}

}
