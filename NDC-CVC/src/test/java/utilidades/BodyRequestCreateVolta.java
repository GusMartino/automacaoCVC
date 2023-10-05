package utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class BodyRequestCreateVolta {

	private static final String[] nomes = { "Gabriel", "Lucas", "Gustavo", "Fernando", "João", "Rafael", "José",
			"Otávio", "Guilherme", "Cristiano", "Giovane", "Lionel", "Neymar" };
	private static final String[] sobrenomes = { "Silva", "Costa", "Pereira", "Santos", "Oliveira", "Evaristo",
			"Ronaldo", "Messi", "Junior" };

	public JSONObject generateRequestBody1(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Santo Andre").put("complement", "9 andar")
				.put("county", "BR").put("number", "227").put("state", "SP").put("street", "CATEQUESE")
				.put("zipCode", "09090-400");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "2024-03-08")
				.put("documents", JSONObject.NULL).put("email", "gustavo@teste.com.br")
				.put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
						.put("number", "981227891").put("type", "LANDLINE")));

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda+","+bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONObject document = new JSONObject().put("type", "CPF").put("doc", "50708000002").put("issuingCountry", "BR")
				.put("issuingDate", new JSONArray().put(2021).put(9).put(26))
				.put("expirationDate", new JSONArray().put(2031).put(9).put(26)).put("residenceCountry", "BR");

		JSONArray documents = new JSONArray().put(document);

		JSONObject pax = new JSONObject().put("birthDate", "1996-03-08").put("documents", documents)
				.put("firstName", "Gustavo").put("gender", "M").put("id", 1).put("lastName", "Evaristo")
				.put("phones", JSONObject.NULL);

		JSONArray paxs = new JSONArray().put(pax);

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxs);
	}

	public JSONObject generateRequestBody2(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Santo Andre").put("complement", "9 andar")
				.put("county", "BR").put("number", "227").put("state", "SP").put("street", "CATEQUESE")
				.put("zipCode", "09090-400");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "2024-03-08")
				.put("documents", JSONObject.NULL).put("email", "teste@hotmail.com");

		JSONArray phonesArray = new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
				.put("number", "999999999").put("type", "LANDLINE"));

		emitter.put("phones", phonesArray);

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda+","+bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONArray paxsArray = new JSONArray();

		JSONObject adultPax = new JSONObject().put("birthDate", "1996-03-08")
				.put("documents", new JSONArray().put(createDocument("CPF", "41425627897", "BR",
						new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
				.put("firstName", "Gustavo").put("gender", "M").put("id", 1).put("lastName", "Evaristo")
				.put("phones", JSONObject.NULL);

		paxsArray.put(adultPax);

		JSONObject childPax = new JSONObject().put("birthDate", "2020-05-05")
				.put("documents", new JSONArray().put(createDocument("CPF", "50708000002", "BR",
						new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
				.put("firstName", "Rafael").put("gender", "M").put("id", 2).put("lastName", "Evaristo")
				.put("phones", JSONObject.NULL);

		paxsArray.put(childPax);

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxsArray);
	}

	private JSONObject createDocument(String type, String doc, String issuingCountry, JSONArray issuingDate,
			JSONArray expirationDate, String residenceCountry) {
		return new JSONObject().put("type", type).put("doc", doc).put("issuingCountry", issuingCountry)
				.put("issuingDate", issuingDate).put("expirationDate", expirationDate)
				.put("residenceCountry", residenceCountry);

	}

	public JSONObject generateRequestBody3(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Santo Andre").put("complement", "9 andar")
				.put("county", "BR").put("number", "227").put("state", "SP").put("street", "CATEQUESE")
				.put("zipCode", "09090-400");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "2024-03-08")
				.put("documents", JSONObject.NULL).put("email", "teste@hotmail.com");

		JSONArray phonesArray = new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
				.put("number", "999999999").put("type", "LANDLINE"));

		emitter.put("phones", phonesArray);

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda+","+bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONArray paxsArray = new JSONArray();

		JSONObject adultPax = new JSONObject().put("birthDate", "1996-03-08")
				.put("documents", new JSONArray().put(createDocument("CPF", "50708000002", "BR",
						new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
				.put("firstName", "Gustavo").put("gender", "M").put("id", 1).put("lastName", "Evaristo")
				.put("phones", JSONObject.NULL);

		paxsArray.put(adultPax);

		JSONObject infantPax = new JSONObject().put("birthDate", "2023-05-05")
				.put("documents", new JSONArray().put(createDocument("CPF", "41425627897", "BR",
						new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
				.put("firstName", "Rafaela").put("gender", "F").put("id", 2).put("lastName", "Evaristo")
				.put("phones", JSONObject.NULL);

		paxsArray.put(infantPax);

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxsArray);
	}

	public JSONObject generateRequestBody4(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Sao Paulo").put("complement", "10th floor")
				.put("county", "BR").put("number", "123").put("state", "SP").put("street", "Sample Street")
				.put("zipCode", "12345-678");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "1980-01-15")
				.put("documents", JSONObject.NULL).put("email", "adult@example.com")
				.put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
						.put("number", "987654321").put("type", "MOBILE")));

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda+","+bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONArray paxs = new JSONArray();

		Random random = new Random();
		List<String> generatedNames = new ArrayList<>(); // Lista para acompanhar nomes gerados

		for (int i = 1; i <= 9; i++) {
			String nome;
			String sobrenome;
			do {
				nome = nomes[random.nextInt(nomes.length)];
				sobrenome = sobrenomes[random.nextInt(sobrenomes.length)];
			} while (generatedNames.contains(nome + " " + sobrenome)); // Verificar se o nome já foi gerado

			generatedNames.add(nome + " " + sobrenome); // Adicionar o nome gerado à lista

			JSONObject adultPax = new JSONObject().put("birthDate", "1980-01-15")
					.put("documents", new JSONArray().put(createDocument("PASSPORT", "SK12115" + i, "BR",
							new JSONArray().put(2023).put(7).put(10), new JSONArray().put(2033).put(7).put(10), "BR")))
					.put("firstName", nome).put("gender", "M").put("id", i).put("lastName", sobrenome)
					.put("phones", JSONObject.NULL);

			paxs.put(adultPax);
		}

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxs);

	}

	public JSONObject generateRequestBody5(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Sao Paulo").put("complement", "10th floor")
				.put("county", "BR").put("number", "123").put("state", "SP").put("street", "Sample Street")
				.put("zipCode", "12345-678");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "1980-01-15")
				.put("documents", JSONObject.NULL).put("email", "adult@example.com")
				.put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
						.put("number", "987654321").put("type", "MOBILE")));

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda+","+bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONArray paxs = new JSONArray();

		Random random = new Random();

		String adultFirstName = nomes[random.nextInt(nomes.length)];
		String adultLastName = sobrenomes[random.nextInt(sobrenomes.length)];
		JSONObject adultPax = new JSONObject().put("birthDate", "1980-01-15")
				.put("documents", new JSONArray().put(createDocument("PASSPORT", "SK1211501", "BR",
						new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
				.put("firstName", adultFirstName).put("gender", "M").put("id", 1).put("lastName", adultLastName)
				.put("phones", JSONObject.NULL);

		paxs.put(adultPax);

		for (int i = 2; i <= 9; i++) {
			String childFirstName = nomes[random.nextInt(nomes.length)];
			String childLastName = sobrenomes[random.nextInt(sobrenomes.length)];
			JSONObject childPax = new JSONObject().put("birthDate", "2019-01-15")
					.put("documents", new JSONArray().put(createDocument("PASSPORT", "SK12115" + i, "BR",
							new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
					.put("firstName", childFirstName).put("gender", "M").put("id", i).put("lastName", childLastName)
					.put("phones", JSONObject.NULL);

			paxs.put(childPax);
		}

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxs);
	}

	public JSONObject generateRequestBody6(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Sao Paulo").put("complement", "10th floor")
				.put("county", "BR").put("number", "123").put("state", "SP").put("street", "Sample Street")
				.put("zipCode", "12345-678");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "1980-01-15")
				.put("documents", JSONObject.NULL).put("email", "adult@example.com")
				.put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
						.put("number", "987654321").put("type", "MOBILE")));

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda+","+bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONArray paxs = new JSONArray();

		Random random = new Random();

		for (int i = 1; i <= 3; i++) {
			String adultFirstName = nomes[random.nextInt(nomes.length)];
			String adultLastName = sobrenomes[random.nextInt(sobrenomes.length)];
			JSONObject adultPax = new JSONObject().put("birthDate", "1980-01-15")
					.put("documents", new JSONArray().put(createDocument("PASSPORT", "SK121150" + i, "BR",
							new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
					.put("firstName", adultFirstName).put("gender", "M").put("id", i).put("lastName", adultLastName)
					.put("phones", JSONObject.NULL);

			paxs.put(adultPax);
		}

		for (int i = 4; i <= 6; i++) {
			String childFirstName = nomes[random.nextInt(nomes.length)];
			String childLastName = sobrenomes[random.nextInt(sobrenomes.length)];
			JSONObject childPax = new JSONObject().put("birthDate", "2019-01-15")
					.put("documents", new JSONArray().put(createDocument("PASSPORT", "SK12115" + i, "BR",
							new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
					.put("firstName", childFirstName).put("gender", "M").put("id", i).put("lastName", childLastName)
					.put("phones", JSONObject.NULL);

			paxs.put(childPax);
		}

		for (int i = 7; i <= 9; i++) {
			String babyFirstName = nomes[random.nextInt(nomes.length)];
			String babyLastName = sobrenomes[random.nextInt(sobrenomes.length)];
			JSONObject babyPax = new JSONObject().put("birthDate", "2023-01-15")
					.put("documents", new JSONArray().put(createDocument("PASSPORT", "SK12116" + i, "BR",
							new JSONArray().put(2023).put(7).put(26), new JSONArray().put(2033).put(7).put(26), "BR")))
					.put("firstName", babyFirstName).put("gender", "M").put("id", i).put("lastName", babyLastName)
					.put("phones", JSONObject.NULL);

			paxs.put(babyPax);
		}

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxs);
	}

	public JSONObject generateRequestBody7(String bTokenIda, String bTokenVolta) {
		JSONObject address = new JSONObject().put("city", "Santo Andre").put("complement", "9 andar")
				.put("county", "BR").put("number", "227").put("state", "SP").put("street", "CATEQUESE")
				.put("zipCode", "09090-400");

		JSONObject emitter = new JSONObject().put("address", address).put("birthDate", "2024-03-08")
				.put("documents", JSONObject.NULL).put("email", "gustavo.teste@cvccorp.com.br")
				.put("phones", new JSONArray().put(new JSONObject().put("internationalCode", 55).put("localCode", 11)
						.put("number", "981227891").put("type", "LANDLINE")));

		JSONObject airBooking = new JSONObject().put("paxsId", JSONObject.NULL)
				.put("taxesCurrencyType", JSONObject.NULL).put("tokenizedRateTokens", bTokenIda + "," + bTokenVolta);

		JSONObject orderItems = new JSONObject().put("airBooking", airBooking);

		JSONObject document = new JSONObject().put("type", "PASSPORT").put("doc", "CBA654321")
				.put("issuingCountry", "PT").put("issuingDate", new JSONArray().put(2015).put(9).put(26))
				.put("expirationDate", new JSONArray().put(2025).put(9).put(26)).put("residenceCountry", "PT");

		JSONArray documents = new JSONArray().put(document);

		JSONObject pax = new JSONObject().put("birthDate", "1988-03-08").put("documents", documents)
				.put("firstName", "Cristiano").put("gender", "M").put("id", 1).put("lastName", "Ronaldo")
				.put("phones", JSONObject.NULL);

		JSONArray paxs = new JSONArray().put(pax);

		return new JSONObject().put("emitter", emitter).put("orderItems", orderItems).put("paxs", paxs);
	}

}
