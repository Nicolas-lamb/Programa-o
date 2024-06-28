package exHeranca.AULA20.src.ex1;

public class Main {
    public static void main(String[] args) {
        Conta c1= new Conta("Ana", "123", 10);
        System.out.println("Conta cadastrada com id: "+c1.identificador);
        Conta c2= new Conta("Ana", "123", 10);
        System.out.println("Conta cadastrada com id: "+c2.identificador);
        //testando atributo estático
//        c1.nomeBanco = "Banco CIMOL";
//        System.out.println("Nome do banco c1"+c1.nomeBanco);
//        System.out.println("Nome do banco c1"+c2.nomeBanco);
//        //Acesso diretamente pela classe, ja que é atributo statico
//        Conta.nomeBanco = "Teste";
//        System.out.println("Nome do banco c1"+c1.nomeBanco);
//        System.out.println("Nome do banco c1"+c2.nomeBanco);
    }
}
