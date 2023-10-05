package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosCancell;
import utilidades.MassaDeDados;

public class StepCancellVoid {

	MetodosCancell metodo = new MetodosCancell();
	String bookingTokenVolta;

	@Dado("que utilize o {string} para cancelar minha reserva")
	public void queUtilizeOParaCancelarMinhaReserva(String bookingTokenVoltaCT) {
		bookingTokenVolta = MassaDeDados.getRateToken(bookingTokenVoltaCT);
		
	}

	@Quando("envio requisição para {string}")
	public void envioRequisiçãoPara(String url) {
		metodo.iniciarDeleteVoid(url, bookingTokenVolta);

	}


		@Então("válido Status Code {int} para confirmar cancelamento com sucesso")
		public void válidoStatusCodeParaConfirmarCancelamentoComSucesso(Integer statusCode) {
		metodo.validarStatusCodeVoid(statusCode);
		
	}
}
