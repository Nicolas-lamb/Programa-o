package exemplos.exemploPolimorfismo;

public class Teste {
    public static void main(String[] args) {

        Operacoes op= new Operacoes();
        System.out.println("Somando dois números "+op.soma(5,7));
        System.out.println("Somando três números "+op.soma(7,5,1));
        System.out.println("Somando duas strings "+op.soma("Palavra", "teste"));
    }
}
