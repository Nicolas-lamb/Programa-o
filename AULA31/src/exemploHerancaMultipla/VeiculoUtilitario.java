package exemploHerancaMultipla;

public class VeiculoUtilitario implements VeiculoCarga, VeioPasseio{

    @Override
    public String carregar() {
        return "carregando...";
    }

    @Override
    public String descarregar() {
        return "descarregando...";
    }

    @Override
    public String embarcarPassageiro() {
        return "embarcando...";
    }

    @Override
    public String desembarcarPassageiro() {
        return "desembarcando...";
    }

    @Override
    public String andar() {
        return "andando...";
    }

    @Override
    public String parar() {
        return "parando...";
    }
}
