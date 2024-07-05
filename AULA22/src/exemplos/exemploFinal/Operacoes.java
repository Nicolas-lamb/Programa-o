package exemplos.exemploFinal;

public class Operacoes {
    //Atributos com modificador final precisam ser inicializados, caso não
    //seja a inicialização deve ocorrer até o final do constructor

    final double valor;

    //Para criar uma constante ela deve ser estática e final ao mesmo tempo
    public static final double PI = 3.141592653589793;

    public Operacoes(){
        valor = 10;
    }
}
