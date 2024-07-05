package exemplos.exemploExcecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo2 {
    public static int leNumero(String mensagem){
        Scanner ler = new Scanner(System.in);
        boolean correto = false;
        int numero = 0;
        do{
            try{
                System.out.println(mensagem +": ");
                numero = ler.nextInt();
                correto = true;

            }catch(InputMismatchException error){
                System.out.print("O valor precisa ser um número");
                ler.next();
                correto=false;
            }
        }while(!correto);
        return numero;

    };

    public static void main(String[] args) {
        int n1 = leNumero("Digite um número");
        System.out.println("O número é "+n1);
    }
}
