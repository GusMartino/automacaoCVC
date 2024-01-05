package metodos;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import pages.ShoppingPage;

public class MetodosShopping {

	private static ShoppingPage shoppingPage;

	private Map<String, String> rateTokensMap;

	public MetodosShopping() {
		shoppingPage = new ShoppingPage();
		rateTokensMap = new HashMap<>();

	}

	/*
	 * Esse método inicia uma requisição do tipo GET para a URL fornecida como
	 * parâmetro usando a instância de ShoppingPage.
	 */
	public void iniarGetShopping(String url) {
		shoppingPage.sendGetRequestShopping(url);

	}

	/*
	 * Esse método valida o código de status (status code) da resposta da requisição
	 */
	public void validarStatusCode(int expectedStatusCode) {
		try {
			int statusCode = shoppingPage.getStatusCode();
			Assert.assertEquals(expectedStatusCode, statusCode);
			System.out.println("Status Code validado é: " + statusCode);

		} catch (AssertionError e) {
			int actualStatusCode = shoppingPage.getStatusCode();
			String responseBody = shoppingPage.getResponseBody();
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
				String responseBody = shoppingPage.getResponseBody();
				System.err.println("Erro ao processar o corpo da resposta: " + responseBody);
				Assert.fail("Erro ao processar o corpo da resposta");
				Assert.fail(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();

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
				String responseBody = shoppingPage.getResponseBody();
				System.err.println("Erro ao processar o corpo da resposta: " + responseBody);
				Assert.fail("Erro ao processar o corpo da resposta");
				System.err.println(errorMessage);
				Assert.fail(errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/*
	 * Esse método valida se o nome do passageiro principal (ADT) está presente na
	 * resposta da requisição
	 */
	public void validarPassageiroPrincipal(String passageiroPrincipal) {
		try {
			Assert.assertTrue(shoppingPage.responseBodyContains(passageiroPrincipal));
			System.out.println("Há o passsageiro necessário para prosseguir com sucesso " + passageiroPrincipal);
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

	public String pegarRateToken(String tokenCT, String companyName) {
	    try {
	        JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
	        JSONArray flights = responseJson.getJSONArray("flights");

	        for (int i = 0; i < flights.length(); i++) {
	            JSONObject flight = flights.getJSONObject(i);

	            // Verifique se a chave "validatingBy" existe no objeto "flight"
	            if (flight.has("validatingBy")) {
	                JSONObject validatingBy = flight.getJSONObject("validatingBy");
	                String name = validatingBy.optString("name");

	                if (name != null && name.equalsIgnoreCase(companyName)) {
	                    JSONArray segments = flight.getJSONArray("segments");

	                    if (segments.length() > 0) {
	                        JSONObject firstSegment = segments.getJSONObject(0);
	                        String rateToken = firstSegment.optString("rateToken");

	                        if (rateToken != null && !rateToken.isEmpty()) {
	                            rateTokensMap.put(tokenCT, rateToken);
	                            return rateToken;
	                        }
	                    }
	                }
	            }
	        }

	        return null; // Retorna null quando não é possível extrair um rateToken válido.
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; // Retorna null em caso de erro ao processar a resposta.
	    }
	}
	
	/*
	 * Este método serve para mostrar o valor do rateToken que foi pego
	 */
	
	public void verificarRateToken(String tokenCT, String companyName) {
	    String rateToken = pegarRateToken(tokenCT, companyName);

	    if (rateToken == null) {
	        fail("Não foi possível extrair o rateToken.");
	    } else {
	        System.out.println("Valor do rateToken: " + rateToken);
	    }
	}

	/*
	 * Este método pega o valor de quantidade de passageiros está presente na
	 * resposta e valida com quantidade informada em caso de teste
	 */
	public void validarQuantidade(int quantidadeDePassageiros, String tipoPassageiros) {
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
						System.out.println(
								"Quantidade do tipo de passageiros: " + quantidadeDePassageiros + "" +tipoPassageiros);
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

	public String pegarRateTokenPorVoo(String partida, String chegada, String companyName) {
	    try {
	        JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
	        JSONArray flights = responseJson.getJSONArray("flights");

	        for (int i = 0; i < flights.length(); i++) {
	            JSONObject flight = flights.getJSONObject(i);

	            // Verifica a companhia aérea
	            JSONObject validatingBy = flight.getJSONObject("validatingBy");
	            String name = validatingBy.optString("name");

	            if (name.equalsIgnoreCase(companyName)) {
	                JSONArray segments = flight.getJSONArray("segments");

	                // Chama o método para obter o rateToken com base na partida e chegada
	                String rateToken = extrairRateToken(segments, partida, chegada);

	                if (rateToken != null) {
	                    return rateToken;
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}


	private String extrairRateToken(JSONArray segmentsArray, String partida, String chegada) {
		try {
			for (int j = 0; j < segmentsArray.length(); j++) {
				JSONObject segmentObject = segmentsArray.getJSONObject(j);
				String departure = segmentObject.optString("departure");
				String arrival = segmentObject.optString("arrival");
				String rateToken = segmentObject.optString("rateToken");

				if (partida.equals(departure) && chegada.equals(arrival)) {
					return rateToken;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void validarMensagemErro(String erroCode, String erroMessage) {
		try {
			JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
			JSONObject errorObject = responseJson.getJSONObject("error");
			String errorCode = errorObject.getString("code");
			String errorMessage = errorObject.getString("message");

			if (errorCode.equals(erroCode) && errorMessage.equals(erroMessage)) {
				System.out.println("Código de erro: " + erroCode);
				System.out.println("Mensagem de erro válida: " + errorMessage);
			} else {
				String errorDetails = "Erro inesperado. Código esperado: " + erroCode + ", Mensagem esperada: "
						+ erroMessage + ", Código recebido: " + errorCode + ", Mensagem recebida: " + errorMessage;
				System.err.println(errorDetails);
				Assert.fail(errorDetails);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Erro ao validar mensagem de erro: " + e.getMessage());
		}
	}

	public int getCountFlights() {
		JSONObject responseJson = new JSONObject(shoppingPage.getResponseBody());
		JSONObject meta = responseJson.getJSONObject("meta");
		int countFlights = meta.getInt("countFlights");

		if (countFlights == 0) {
			System.out.println("O valor de countFlights é 0. Corpo da resposta:");
			System.out.println(shoppingPage.getResponseBody());
		}

		return countFlights;
	}
}
