package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
        // Construtor privado para impedir instanciação externa
    }

    public static WebDriver abrirNavegador() {
        if (driver == null) {
            // Configuração do WebDriver usando o WebDriverManager
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Executar em modo headless (sem interface gráfica)
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void fecharNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null; // Limpar a instância para garantir que não seja reutilizada
        }
    }
}
