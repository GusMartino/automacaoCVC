package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import metodos.MetodosRetrieve;
import utilidades.MassaDeDados;

public class StepRetrieve {

	MetodosRetrieve metodo = new MetodosRetrieve();
	String reservationCode;

	@Dado("que tenho guardado o localizador {string}")
	public void queTenhoGuardadoOLocalizador(String reservationCodeCT) {
		reservationCode = MassaDeDados.getRateToken(reservationCodeCT);

	}

	@Quando("faço um get em url de retrieve {string}")
	public void façoUmGetEmUrlDeRetrieve(String url) {
		metodo.iniciarGetRetrieve(url, reservationCode);

	}

	@Então("válido status code de reposta {int} junto ao status do bilhete {string}")
	public void válidoStatusCodeDeRepostaJuntoAoStatusDoBilhete(Integer statusCode, String statusReservaCT) {
		metodo.validarStatusCode(statusCode);
		metodo.validarStatus(statusReservaCT);
	
	}

}
