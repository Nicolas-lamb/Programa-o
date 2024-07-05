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
    public static  ContaCor cadastraCC(){
        String titular = leString("Qual o nome do titular");
        String senha = leString("Qual a senha");
        float limite = leFloat("Qual o limite inicial");
        ContaCor c1 = new ContaCor(titular, senha, limite);
        System.out.println("Conta cadastrada com o id: "+c1.getIdentificador());
        return c1;
    }
    public static ContaPou cadastraCP(){
        String titular = leString("Qual o nome do titular");
        String senha = leString("Qual a senha");
        float deposito = leFloat("Qual o depósito inicial");
        ContaPou c1 = new ContaPou(titular, senha, deposito);
        System.out.println("Conta cadastrada com o id: "+c1.getIdentificador());
        return c1;
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
                case "v"->{
                    String res = c1.verificaSaldo();
                    System.out.println(res);
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
                case "v"->{
                    String res = c1.verificaSaldo();
                    System.out.println(res);
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
                    listaCC[contCC] = cadastraCC();
                    contCC++;
                }
                case "cp" ->{
                    listaCP[contCP] = cadastraCP();
                    contCP++;
                }
                case "ac" ->{
                    String identificador= leString("Digite o identificador");
                    String senha= leString("Digite a senha desse titular");
                    int posicao = -1;
                    for(int i = 0; i<contCC; i++){
                        if(listaCC[i].validaAcesso(identificador, senha)){
                            posicao = i;
                        }
                    }
                    if(posicao >= 0){
                        listaCC[posicao] = acessaCC(listaCC[posicao]);
                    }else{
                        System.out.println("Informações de acesso inválida");
                    }
                }
                case "ap" ->{
                    String identificador= leString("Digite o identificador");
                    String senha= leString("Digite a senha desse titular");
                    int posicao = -1;
                    for(int i = 0; i<contCP; i++){
                        if(listaCP[i].validaAcesso(identificador, senha)){
                            posicao = i;
                        }
                    }
                    if(posicao >= 0){
                        listaCP[posicao] = acessaCP(listaCP[posicao]);
                    }else{
                        System.out.println("Informações de acesso inválida");
                    }
                }
            }
        }
        while(!opc.equals("e"));

    }
}
