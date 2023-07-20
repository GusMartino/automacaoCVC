package metodos;

import static org.junit.Assert.fail;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import pages.ShoppingPage;

public class Metodos {

	private ShoppingPage shoppingPage;

	public Metodos() {
		shoppingPage = new ShoppingPage();

	}

	/*
	 * Esse método inicia uma requisição di tipo GET para a URL fornecida como
	 * parâmetro usando a instância de ShoppingPage.
	 */
	public void iniarGet(String url) {
		shoppingPage.sendGetRequest(url);

	}

	/*
	 * Esse método valida o código de status (status code) da resposta da requisição
	 */
	public void validarStatusCode(int expectedStatusCode) {
		try {
			int statusCode = shoppingPage.getStatusCode();
			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);

		} catch (Exception e) {
			String errorMessage = "Erro ao validar Status Code: " + expectedStatusCode;
			System.err.println(errorMessage);
			Assert.fail(errorMessage);
		}
	}

	/*
	 * Esse método valida se a sigla do aeroporto de partida (aeroportoPartida) está
	 * presente na resposta da requisição
	 */
	public void validarAeroportoPartida(String aeroportoPartida) {
		try {
			JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
			JSONArray flights = responseJson.getJSONArray("flights");

			boolean found = false;

			for (int i = 0; i < flights.length(); i++) {
				JSONObject flight = flights.getJSONObject(i);
				JSONArray segments = flight.getJSONArray("segments");

				for (int j = 0; j < segments.length(); j++) {
					JSONObject segment = segments.getJSONObject(j);
					String departure = segment.getString("departure");

					if (departure.equals(aeroportoPartida)) {
						found = true;
						break;

					}
				}

				if (found) {
					break;
				}
			}

			if (found) {
				System.out.println("Siglas do aeroporto de partida: " + aeroportoPartida);
			} else {
				String errorMessage = "Falha ao encontrar o aeroporto " + aeroportoPartida;
				System.err.println(errorMessage);
				Assert.fail(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Erro ao processar o corpo da resposta");
		}
	}

	/*
	 * Esse método valida se a sigla do aeroporto de chegada (aeroportoChegada) está
	 * presente na resposta da requisição
	 */
	public void validarAeroportoChegada(String aeroportoChegada) {
		try {
			JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
			JSONArray flights = responseJson.getJSONArray("flights");

			boolean found = false;

			for (int i = 0; i < flights.length(); i++) {
				JSONObject flight = flights.getJSONObject(i);
				JSONArray segments = flight.getJSONArray("segments");

				for (int j = 0; j < segments.length(); j++) {
					JSONObject segment = segments.getJSONObject(j);
					String arrival = segment.getString("arrival");

					if (arrival.equals(aeroportoChegada)) {
						found = true;
						break;

					}
				}

				if (found) {
					break;
				}
			}

			if (found) {
				System.out.println("Siglas do aeroporto de partida: " + aeroportoChegada);
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

	/*
	 * Esse método valida se o nome do passageiro principal (ADT) está presente na
	 * resposta da requisição
	 */
	public void validarPassageiroPrincipal(String passageiroPrincipal) {
		try {
			Assert.assertTrue(shoppingPage.responseBodyContains(passageiroPrincipal));
			System.out.println("Há o passsageiro necessário para conseguir sucesso em pesquisa " + passageiroPrincipal);
		} catch (Exception e) {
			fail("Falha em buscar o passageiro principal " + passageiroPrincipal);
			e.printStackTrace();
		}
	}

	/*
	 * Esse método valida se um determinado tipo de passageiro (passageiro) está
	 * presente na resposta da requisição
	 */
	public void validarPassageiro(String passageiro) {
		try {
			JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
			JSONArray flights = responseJson.getJSONArray("flights");

			for (int i = 0; i < flights.length(); i++) {
				JSONObject flight = flights.getJSONObject(i);
				JSONArray fares = flight.getJSONObject("fareGroup").getJSONArray("fares");

				for (int j = 0; j < fares.length(); j++) {
					JSONObject fare = fares.getJSONObject(j);
					String passengersType = fare.getString("passengersType");

					if (passengersType.equals(passageiro)) {
						System.out.println("Encontrado passageiro " + passageiro + " em response ");
						return;
					}
				}
			}

			// Nenhum passageiro criança ou bebê encontrado, o teste falha
			fail("Não há passageiro" + passageiro + " na resposta do GET");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao validar passageiro: " + e.getMessage());
		}

	}

	/* Este método extrai o valor do campo "rateToken" da resposta da requisição */
	public String pegarRateToken() {
		try {
			JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
			JSONArray flights = responseJson.getJSONArray("flights");

			if (flights.length() > 0) {
				JSONObject firstFlight = flights.getJSONObject(0);
				JSONArray segments = firstFlight.getJSONArray("segments");

				if (segments.length() > 0) {
					JSONObject firstSegment = segments.getJSONObject(0);
					return firstSegment.optString("rateToken");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Este método serve para mostrar e guardar valor do rateToken que foi pego
	 */
	public void verificarRateToken() {
		String rateToken = pegarRateToken();

		if (rateToken == null) {
			System.out.println("Não foi possível extrair o rateToken.");
		} else {
			System.out.println("Valor do rateToken: " + rateToken);

			String valorEsperado = "valor_esperado";

		}
	}

	/*
	 * Este método pega o valor de quantidade de passageiros está presente na
	 * resposta e valida com quantidade informada em caso de teste
	 */
	public void validarQuantidade(int quantidadeDePassageiros) {
		try {
			JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
			JSONArray flights = responseJson.getJSONArray("flights");

			for (int i = 0; i < flights.length(); i++) {
				JSONObject flight = flights.getJSONObject(i);
				JSONArray fares = flight.getJSONObject("fareGroup").getJSONArray("fares");

				for (int j = 0; j < fares.length(); j++) {
					JSONObject fare = fares.getJSONObject(j);
					int passengersCount = fare.getInt("passengersCount");

					if (passengersCount == quantidadeDePassageiros) {
						System.out.println("Quantidade de passageiros: " + quantidadeDePassageiros);
						return;
					}
				}
			}

			// Nenhuma quantidade de passageiros encontrada, o teste falha
			fail("Não há a quantidade certa de passageiros: " + quantidadeDePassageiros + " na resposta do GET");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Erro ao validar quantidade de passageiros: " + e.getMessage());
		}
	}
}
