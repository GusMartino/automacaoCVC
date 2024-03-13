package interfac;

public class CalculadoraVendas {
    private double custo;

    public void setCusto(double custo) {
        this.custo = custo;

    }

    public double calcularVlVenda(double markup) {
        return custo / markup;
    }

    public double calcularComissao(double vlVenda, double percentualComissao) {
        return vlVenda * percentualComissao;
    }

    public double calcularLucroBruto(double vlVenda) {
        return vlVenda - custo;
    }
}
