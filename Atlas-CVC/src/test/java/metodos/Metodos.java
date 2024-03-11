package metodos;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Metodos {

    private WebDriver driver;

    public Metodos(WebDriver driver) {
        this.driver = driver;
    }

    public void clicar(By byElemento) {
        WebElement elemento = driver.findElement(byElemento);
        elemento.click();
    }

    public void digitar(By byElemento, String texto) {
        WebElement elemento = driver.findElement(byElemento);
        elemento.sendKeys(texto);
    
    }

    public void validarTexto(By byElemento, String textoEsperado) {
        WebElement elemento = driver.findElement(byElemento);
        String textoAtual = elemento.getText();

        if (!textoAtual.equals(textoEsperado)) {
            throw new RuntimeException(
                    "Erro ao validar texto. Texto esperado: " + textoEsperado + ", Texto atual: " + textoAtual);
        }

        System.out.println("Texto validado com sucesso: " + textoEsperado);
    }

    public void tirarPrint(String cenario, String nomeEvidencia) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String caminhoEvidencias = "target/evidencias/";

            File cenarioDir = new File(caminhoEvidencias + cenario);
            if (!cenarioDir.exists()) {
                cenarioDir.mkdirs();
            }

            File evidenciaFile = new File(cenarioDir, nomeEvidencia + ".png");
            FileUtils.copyFile(screenshot, evidenciaFile);

            System.out.println("Print tirado com sucesso: " + nomeEvidencia);
            System.out.println("Caminho da evidência: " + evidenciaFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Erro ao tentar tirar o print: " + e.getMessage());
        }
    }
}
