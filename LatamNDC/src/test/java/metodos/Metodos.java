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

	public void iniarGet(String url) {
		shoppingPage.sendGetRequest(url);

	}

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

	public void validarPassageiroPrincipal(String passageiroPrincipal) {
		try {
			Assert.assertTrue(shoppingPage.responseBodyContains(passageiroPrincipal));
			System.out.println("Há o passsageiro necessário para conseguir sucesso em pesquisa " + passageiroPrincipal);
		} catch (Exception e) {
			fail("Falha em buscar o passageiro principal " + passageiroPrincipal);
			e.printStackTrace();
		}
	}

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

    public void verificarRateToken() {
        String rateToken = pegarRateToken();

        if (rateToken == null) {
            System.out.println("Não foi possível extrair o rateToken.");
        } else {
            System.out.println("Valor do rateToken: " + rateToken);

            String valorEsperado = "valor_esperado";

        }
    }
}
