package utilidades;

import java.util.HashMap;
import java.util.Map;

public class MassaDeDados {
    private static Map<String, String> rateTokens = new HashMap<>();

    public static void setRateToken(String key, String rateToken) {
        rateTokens.put(key, rateToken);
    }

    public static String getRateToken(String key) {
        return rateTokens.get(key);
    }
}

