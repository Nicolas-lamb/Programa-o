

package exemploHerancaMultipla;

public class Main {
    public static void main(String[] args) {

        VeiculoUtilitario v1 = new VeiculoUtilitario();

        System.out.println(v1.andar());
        v1.carregar();
        v1.descarregar();
        v1.parar();
        v1.embarcarPassageiro();
        v1.desembarcarPassageiro();

    }
}
