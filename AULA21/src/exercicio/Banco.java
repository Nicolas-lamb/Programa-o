package exercicio;

import java.util.Scanner;

public class Banco {

    public static String leString(String mensagem){
        Scanner ler = new Scanner(System.in);
        System.out.print(mensagem+": ");
        return ler.nextLine();
    }

    public static float leFloat(String mensagem){
        Scanner ler = new Scanner(System.in);
        System.out.print(mensagem+": ");
        return ler.nextFloat();
    }

    public static ContaCor acessaCC(ContaCor c1){
        String opc;
        System.out.println("Acessando a conta "+c1.getIdentificador());
        do{
            System.out.println("Selecione uma opção");
            System.out.println("d- depositar");
            System.out.println("s - sacar");
            System.out.println("v - verificar o saldo");
            System.out.println("e - sair");
            opc= leString("").toLowerCase();

            switch (opc){
                case "d"->{
                    float valor = leFloat("Qual o valor do depósito");
                    c1.depositar(valor);
                }
                case "s"->{
                    float valor = leFloat("Qual o valor deseja sacar");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado com sucesso!");
                    else System.out.println("Saldo insuficiente!");
                }
            }
        }while(!opc.equals("e"));
        return c1;
    }

    public static ContaPou acessaCP(ContaPou c1) {
        String opc;
        System.out.println("Acessando a conta " + c1.getIdentificador());
        do {
            System.out.println("Selecione uma opção");
            System.out.println("d- depositar");
            System.out.println("s - sacar");
            System.out.println("v - verificar o saldo");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();

            switch (opc) {
                case "d" -> {
                    float valor = leFloat("Qual o valor do depósito");
                    c1.depositar(valor);
                }
                case "s" -> {
                    float valor = leFloat("Qual o valor deseja sacar");
                    if (c1.sacar(valor))
                        System.out.println("Saque realizado com sucesso!");
                    else System.out.println("Saldo insuficiente!");
                }
            }
        }while(!opc.equals("e"));
        return c1;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ContaCor[] listaCC = new ContaCor[20];
        ContaPou[] listaCP = new ContaPou[20];
        int contCC = 0;
        int contCP = 0;
        String opc;

        do{
            System.out.println("Selecione uma opção");
            System.out.println("cc - cadastrar conta corrente");
            System.out.println("cp - cadastrar conta poupança");
            System.out.println("ac - acessar conta corrente");
            System.out.println("ap - acessar conta poupança");
            System.out.println("e - sair");
            opc = leString("Digite");


            switch (opc){
                case "cc" ->{
                    String titular;
                    String senha;
                    float limite;
                    titular= leString("Digite o titular da conta corrente:");
                    senha= ler.next("Digite a senha desse titular: ");
                    limite= leFloat("Digite o limite inicial: ");
                    listaCC[contCC] = new ContaCor(titular, senha, limite);
                    contCC++;
                }
                case "cp" ->{
                    String titular;
                    String senha;
                    float deposito;
                    titular= leString("Digite o titular da conta corrente:");
                    senha= ler.next("Digite a senha desse titular: ");
                    deposito= leFloat("Digite o deposito inicial: ");
                    listaCP[contCP] = new ContaPou(titular, senha, deposito);
                    contCC++;
                }
                case "ac" ->{
                    String identificador;
                    String senha;
                    identificador= leString("Digite o identificador:");
                    senha= ler.next("Digite a senha desse titular: ");
                }
            }
        }
        while(!opc.equals("e"));

    }
}
