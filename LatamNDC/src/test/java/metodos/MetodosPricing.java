package metodos;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import pages.PricingPage;

public class MetodosPricing {
	private static PricingPage pricingPage;
	private Map<String, String> rateTokensMap;

	public MetodosPricing() {
		pricingPage = new PricingPage();
		rateTokensMap = new HashMap<>();
	}

	/*
	 * Esse método inicia uma requisição do tipo GET para a URL fornecida como
	 * parâmetro usando a instância de PricingPage.
	 */
	public void iniarGetPricingIda(String url, String tokenCT) {
		pricingPage.iniciarGetRequestPricing(url, tokenCT);
	}

	/*
	 * Esse método valida o código de status (status code) da resposta da requisição
	 */
	public void validarStatusCode(int expectedStatusCode) {
		try {
			int statusCode = pricingPage.getStatusCode();
			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);

		} catch (AssertionError e) {
			int actualStatusCode = pricingPage.getStatusCode();
			String responseBody = pricingPage.getResponseBody();
			String errorMessage = "Erro ao validar Status Code. Esperado: " + expectedStatusCode
					+ ", mas foi recebido: " + actualStatusCode;
			System.err.println(errorMessage);
			System.err.println("Resposta do servidor: " + responseBody);
			Assert.fail(errorMessage);
		} catch (Exception e) {
			String errorMessage = "Erro inesperado ao validar Status Code: " + expectedStatusCode;
			System.err.println(errorMessage);
			Assert.fail(errorMessage);
		}
	}

	/*
	 * Esse método valida se a sigla do aeroporto de cehgada está correto na
	 * resposta da requisição
	 */
	public void validarAeroportoChegada(String aeroportoChegada) {
		try {
			JSONObject responseJson = new JSONObject(pricingPage.getResponseBody());
			JSONObject priceGroup = responseJson.getJSONObject("priceGroup");

			JSONArray segments = priceGroup.getJSONArray("segments");

			boolean found = false;

			for (int j = 0; j < segments.length(); j++) {
				JSONObject segment = segments.getJSONObject(j);
				String arrival = segment.getString("arrival");

				if (arrival.equals(aeroportoChegada)) {
					found = true;
					break;
				}
			}

			if (found) {
				System.out.println("Siglas do aeroporto de chegada: " + aeroportoChegada);
			} else {
				String errorMessage = "Falha ao encontrar o aeroporto " + aeroportoChegada;
				System.err.println(errorMessage);
				Assert.fail(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Erro ao processar o corpo da resposta");
		}
	}

	/* Este método extrai o valor do campo "rateToken" da resposta de Pricing */
	public String pegarRateToken(String BtokenCT) {
		try {
			JSONObject responseJson = new JSONObject(pricingPage.getResponseBody());
			JSONObject priceGroup = responseJson.getJSONObject("priceGroup");
			JSONArray segments = priceGroup.getJSONArray("segments");

			if (segments.length() > 0) {
				JSONObject firstSegment = segments.getJSONObject(0);
				String rateToken = firstSegment.optString("rateToken");

				// Adiciona o rateToken ao mapa usando o nome do CT como chave
				rateTokensMap.put(BtokenCT, rateToken);

				return rateToken;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Este método serve para mostrar o valor do rateToken que foi pego
	 */
	public void verificarRateToken(String BtokenCT) {
		String rateToken = pegarRateToken(BtokenCT);
		if (rateToken == null) {
			System.out.println("Não foi possível extrair o rateToken.");
		} else {
			System.out.println("Valor do rateToken: " + rateToken);

		}
	}

}
