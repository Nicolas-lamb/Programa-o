package exHeranca.AULA20.src.ex1;

public class Calculadora {
    public static void main(String[] args) {
        int v1 = 10;
        int v2 = 20;
        System.out.println(Operacoes.soma(v1,v2));
        System.out.println(Operacoes.multiplica(v1,v2));
        //clases do java que usam o static
        int v3 = Integer.parseInt("10");
    }
}
