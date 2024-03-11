package interfac;

public class MeuServico {

    private MinhaInterface minhaInterface;

    public MeuServico(MinhaInterface minhaInterface) {
        this.minhaInterface = minhaInterface;
    }

    public String algumaFuncionalidade() {
        return minhaInterface.metodo();
    }
}
