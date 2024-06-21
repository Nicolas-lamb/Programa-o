package exAcesso3;

public class Main {
    public static void main(String[] args) {
        Conta c1= new Conta("Ana", "123", 10);
        System.out.println("Conta cadastrada com id: "+c1.getIdentificador());
        Conta c2= new Conta("José", "345", 100);
        System.out.println("Conta cadastrada com id: "+c2.getIdentificador());
        c1.depositar(100);
        c1.sacar(10);
        System.out.println(c1.verificaSaldo());

    }
}
