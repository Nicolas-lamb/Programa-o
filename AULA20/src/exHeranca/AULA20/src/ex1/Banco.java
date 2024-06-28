package exHeranca.AULA20.src.ex1;

import java.util.Scanner;

public class Banco {

    static float deposito(float valor, float saldo) {
        saldo+= valor;
        return saldo;
    }
    static float retirada(float valor, float saldo) {
        saldo-= valor;
        return saldo;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta[] conta = new Conta[10];
        char opc;
        int cont=0;
        do{
            System.out.println("--------------------------------------- ");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Acessar conta");
            System.out.println("3 - Sair");
            System.out.println("--------------------------------------- ");
            opc = ler.next().toLowerCase().charAt(0);



            switch (opc) {
                case '1' -> {
                    for (int c = 0; c < 10; c++) {
                        if (c == cont) {
                            String titular = "";
                            String senha = "";
                            int saldo = 0;
                            System.out.println("--------------------------------------- ");
                            System.out.print("Digite o nome do titular: ");
                            titular = ler.next();
                            System.out.print("Digite a senha: ");
                            senha = ler.next();
                            System.out.print("Digite o saldo inicial: ");
                            saldo = ler.nextInt();
                            System.out.println("--------------------------------------- ");
                            conta[c] = new Conta(titular, senha, saldo);
                            System.out.println("identificador: "+conta[c].identificador);
                        }

                    }
                    cont++;

                }
                case '2' -> {
                    char res;
                    System.out.print("Digite o identificador que deseja: ");
                    String idres = ler.next();
                    System.out.print("Digite a senha: ");
                    String senha = ler.next();
                    for (int c = 0; c < 10; c++) {
                        if (idres.equals(conta[c].identificador)) {
                            while (!senha.equals(conta[c].senha) && !idres.equals(conta[c].identificador)) {

                                System.out.print("[ERRO 404] Digite o identificador que deseja: ");
                                idres = ler.next();
                                System.out.print("[ERRO 404] Digite a senha: ");
                                senha = ler.next();
                            }
                            cont++;

                            do {
                                System.out.println("--------------------------------------- ");
                                System.out.println("1 - Depositar");
                                System.out.println("2 - Sacar");
                                System.out.println("3 - Verificar saldo");
                                System.out.println("4 - Sair");
                                res = ler.next().toLowerCase().charAt(0);
                                System.out.println("--------------------------------------- ");

                                switch (res) {
                                    case '1' -> {
                                        System.out.print("Digite o valor do deposito: ");
                                        float valor = ler.nextFloat();
                                        conta[c].saldo = deposito(valor, conta[c].saldo);
                                        System.out.println("Deposito realizado: ");
                                    }
                                    case '2' -> {
                                        System.out.print("Digite o valor da retirada: ");
                                        float valor = ler.nextFloat();
                                        while (valor > conta[c].saldo) {
                                            System.out.print("Valor de retirada maior que saldo: ");
                                            valor = ler.nextFloat();
                                        }
                                        conta[c].saldo = retirada(valor, conta[c].saldo);
                                        System.out.println("Saque realizado.");
                                    }
                                    case '3' -> {
                                        System.out.println("O saldo de "+conta[c].titular+" atual é R$" + String.format("%,2f", conta[c].saldo));
                                    }


                                }


                            } while (res != '4');
                        }


                    }

                }
            }
        }while(opc!='3');


    };




};

