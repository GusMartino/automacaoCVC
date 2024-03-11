package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import driver.WebDriverSingleton;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps", 
    tags = "@TESTE", 
    plugin = {"pretty", "html:target/cucumber-report.html" }, 
    dryRun = false,
    snippets = SnippetType.CAMELCASE
)
public class Executa {
    
    @BeforeClass
    public static void setUp() {
        // Inicializar o WebDriver em todo teste
        WebDriverSingleton.abrirNavegador();
    }

    @AfterClass
    public static void tearDown() {
        // Fechar o WebDriver após a execução dos testes
        WebDriverSingleton.fecharNavegador();
    }
}
