package Testes;

import org.junit.Before;
import org.junit.Test;

import interfac.CalculadoraVendas;

import java.text.DecimalFormat;

public class CalculoVendasTest {
    private CalculadoraVendas calculadora;
    private double custo; // Valor do custo que será definido dinamicamente

    @Before
    public void setUp() {
        calculadora = new CalculadoraVendas();
        custo = 1000.00; // Defina o valor do custo aqui
        calculadora.setCusto(custo); // Configura o valor do custo na calculadora
    }

    @Test
    public void testCalcularComissao() {
        double[] markups = {0.80, 0.79, 0.78, 0.77, 0.76, 0.75, 0.74, 0.73, 0.72, 0.71, 0.70}; // Opções de markup
        double[] percentuaisComissao = {0.100, 0.105, 0.110, 0.115, 0.120, 0.125, 0.130, 0.135, 0.140, 0.145, 0.150}; // Opções de comissão
        DecimalFormat df = new DecimalFormat("#.##"); // Formato para exibir apenas duas casas decimais

        for (int i = 0; i < markups.length; i++) {
            double vlVenda = calculadora.calcularVlVenda(markups[i]); // Valor de venda com markup da opção atual
            double valorComissaoCalculado = calculadora.calcularComissao(vlVenda, percentuaisComissao[i]);
            double lucroBruto = calculadora.calcularLucroBruto(vlVenda); // Lucro bruto
            
            // Imprimir os valores calculados para cada opção
            System.out.println("Opção " + (i+1) + " do slider:");
            System.out.println("Valor de venda: " + df.format(vlVenda));
            System.out.println("Lucro bruto calculado: " + df.format(lucroBruto));
            System.out.println("Valor da comissão calculado: " + df.format(valorComissaoCalculado));
        }
    }
}
