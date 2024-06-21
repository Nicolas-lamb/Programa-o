package exAcesso3;

public class Main {
    public static void main(String[] args) {
        Conta c1= new Conta("Ana", "123", 10);
        System.out.println("Conta cadastrada com id: "+c1.identificador);
        Conta c2= new Conta("Ana", "123", 10);
        System.out.println("Conta cadastrada com id: "+c2.identificador);

    }
}
