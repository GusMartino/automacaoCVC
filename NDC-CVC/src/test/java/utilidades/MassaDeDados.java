package utilidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MassaDeDados {
    private static Map<String, String> rateTokens = new HashMap<>();
    private static Map<String, Double> numericValues = new HashMap<>();  

    public static void setRateToken(String key, String rateToken) {
        rateTokens.put(key, rateToken);
    }

    public static String getRateToken(String key) {
        return rateTokens.get(key);
    }

    public static void setNumericValue(String key, Double value) {
        numericValues.put(key, value);
    }

    public static Double getNumericValue(String key) {
        return numericValues.get(key);
    }

	public static String getRateToken(List<String> tokens) {

		return null;
	}
}
