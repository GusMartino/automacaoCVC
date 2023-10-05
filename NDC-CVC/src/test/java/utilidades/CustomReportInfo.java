package utilidades;

import java.util.HashMap;
import java.util.Map;

public class CustomReportInfo {
    private Map<String, String> customInfoMap;

    public CustomReportInfo() {
        customInfoMap = new HashMap<>();
    }

    public void addCustomInfo(String label, String value) {
        customInfoMap.put(label, value);
    }

    public Map<String, String> getCustomInfoMap() {
        return customInfoMap;
    }

    // Método para gerar o relatório com base nas informações personalizadas
    public void generateCustomReport() {
        System.out.println("Relatório de Informações Personalizadas:");
        for (Map.Entry<String, String> entry : customInfoMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
