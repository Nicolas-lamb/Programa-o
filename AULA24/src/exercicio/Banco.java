package exercicio;
import java.util.Scanner;
import java.io.*;

public class Banco {



    public static ContaCorrente[] LerObjetoContaCor(){
        File caminho = new File("C:\\Users\\nikel\\Documents\\aula24");
        File arquivo = new File(caminho,"contaCorrente.db");
        ContaCorrente[] listaCC = new ContaCorrente[20];

        try{
             ObjectInputStream arquivoObj = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
             listaCC = (ContaCorrente[]) arquivoObj.readObject();//le o arquivo como objeto e transforma essa objeto em array Pessoa

            int cont = 0;
            ContaCorrente p;
            do{
                p = listaCC[cont];
                if(p!=null){
                    cont++;
                }
            }while(p!=null);
            for(int i=0; i<cont;i++){
                System.out.println(listaCC[i]);
            }
            arquivoObj.close();
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada");
        }
        return listaCC;
    };
    public static void LerObjetoContaPou(ContaPoupanca[] lista){
        File caminho = new File("C:\\Users\\nikel\\Documents\\aula24");
        File arquivo = new File(caminho,"contaPoupanca.db");
        try{
            ObjectInputStream arquivoObj = new ObjectInputStream(new FileInputStream(arquivo.getAbsolutePath()));
            lista = (ContaPoupanca[]) arquivoObj.readObject();//le o arquivo como objeto e transforma essa objeto em array Pessoa

            int cont =0;
            ContaPoupanca p;
            do{
                p = lista[cont];
                if(p!=null){
                    cont++;
                }
            }while(p!=null);
            for(int i=0; i<cont;i++){
                System.out.println(lista[i]);
            }
            arquivoObj.close();
        }catch(IOException e){
            System.out.println("Erro ao ler o arquivo");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada");
        }
    }

    public static void EscreverObjetoContaCor(ContaCorrente[] lista){
        File caminho = new File("C:\\Users\\nikel\\Documents\\aula24");

        if(caminho.exists()){
            System.out.println("A pasta ja existe");
        }else{
            caminho.mkdirs();//cria o caminho pra o arquivo
            System.out.println("Caminho criado");
        }
        //Declarando o arquivo para salvar a Pessoa
        File arquivo = new File(caminho,"contaCorrente.db");

        try{
            ObjectOutputStream arquivoObj = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));

            //escreve o array inteiro da lista
            arquivoObj.writeObject(lista);
            //fecha o arquivo
            arquivoObj.close();

        }catch(IOException e){
            System.out.println("Erro ao criar ao criar o arquivo");
        }
    };
    public static void EscreverObjetoContaPou(ContaPoupanca[] lista){
        File caminho = new File("C:\\Users\\nikel\\Documents\\aula24");

        if(caminho.exists()){
            System.out.println("A pasta existe");
        }else{
            caminho.mkdirs();//cria o caminho pra o arquivo
            System.out.println("Caminho criado");
        }
        //Declarando o arquivo para salvar a Pessoa
        File arquivo = new File(caminho,"contaPoupanca.db");

        try{
            ObjectOutputStream arquivoObj = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));

            //escreve o array inteiro da lista
            arquivoObj.writeObject(lista);
            //fecha o arquivo
            arquivoObj.close();

        }catch(IOException e){
            System.out.println("Erro ao criar ao criar o arquivo");
        }
    };

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

    public static ContaCorrente acessaCC(ContaCorrente c1){
        String opc;
        System.out.println("Acessando a conta "+c1.getIdentificador());
        System.out.println("Bem vindo, "+c1.getTitular());
        do{
            System.out.println("Selecione uma opção");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar o saldo");
            System.out.println("a - alterar a senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc){
                case "d"->{
                    float valor = leFloat("Qual valor deseja depositar");
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case "s"->{
                    float valor = leFloat("Qual o valor do saque");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado");
                    else
                        System.out.println("Saldo mais limite insuficientes");
                }
                case "v"->System.out.println(c1.verificaSaldo());
                case "a"->{
                    String senha = leString("Qual a nova senha");
                    c1.setSenha(senha);
                }
            }
        }
        while(!opc.equals("e"));
        return c1;
    }

    public static ContaPoupanca acessaCP(ContaPoupanca c1){
        String opc;
        System.out.println("Acessando a conta "+c1.getIdentificador());
        System.out.println("Bem vindo, "+c1.getTitular());
        do{
            System.out.println("Selecione uma opção");
            System.out.println("d - realizar um depósito");
            System.out.println("s - realizar um saque");
            System.out.println("v - verificar o saldo");
            System.out.println("a - alterar a senha");
            System.out.println("e - sair");
            opc = leString("").toLowerCase();
            switch (opc){
                case "d"->{
                    float valor = leFloat("Qual valor deseja depositar");
                    c1.depositar(valor);
                    System.out.println("Depósito realizado!");
                }
                case "s"->{
                    float valor = leFloat("Qual o valor do saque");
                    if(c1.sacar(valor))
                        System.out.println("Saque realizado");
                    else
                        System.out.println("Saldo insuficiente");
                }
                case "v"->System.out.println(c1.verificaSaldo());
                case "a"->{
                    String senha = leString("Qual a nova senha");
                    c1.setSenha(senha);
                }
            }
        }
        while(!opc.equals("e"));
        return c1;
    }

    public static ContaCorrente cadastraCC(){
        String titular = leString("Qual o titular da conta");
        String senha = leString("Qual a senha");
        float limite = leFloat("Qual o limite inicial");
        ContaCorrente c1 = new ContaCorrente(titular,senha,limite);
        System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
        return c1;
    }

    public static ContaPoupanca cadastraCP(){
        String titular = leString("Qual o titular da conta");
        String senha = leString("Qual a senha");
        float deposito = leFloat("Qual valor depositar");
        ContaPoupanca c1 = new ContaPoupanca(titular,senha,deposito);
        System.out.println("Conta cadastrada com o identificador "+c1.getIdentificador());
        return c1;
    }

    public static void main(String[] args) {
        ContaPoupanca[] listaCP = new ContaPoupanca[20];
        int contCC = 0;
        int contCP = 0;
        ContaCorrente[] listaCC = LerObjetoContaCor();

        for ( ContaCorrente valor : listaCC) {
            System.out.println(valor);
        }

        String opc;
        do{
            System.out.println("Selecione uma opção");
            System.out.println("cc - cadastrar conta corrente");
            System.out.println("cp - cadastrar conta poupança");
            System.out.println("ac - acessar conta corrente");
            System.out.println("ap - acessar conta poupança");
            System.out.println("e - sair");
            opc = leString("");
            switch (opc){
                case "cc"->{
                    listaCC[contCC] = cadastraCC();

                    contCC++;
                }
                case "cp"->{
                    listaCP[contCP] = cadastraCP();
                    contCP++;
                }
                case "ac"->{
                    String identificador = leString("Qual o identificador");
                    String senha = leString("Qual a senha");
                    int posicao = -1;
                    for(int i=0;i<contCC;i++){
                        if(listaCC[i].validaAcesso(identificador,senha))
                            posicao = i;
                    }
                    if(posicao>=0){
                        listaCC[posicao] = acessaCC(listaCC[posicao]);
                    }
                    else{
                        System.out.println("Conta inexistente ou senha incorreta!");
                    }
                }
                case "ap"->{
                    String identificador = leString("Qual o identificador");
                    String senha = leString("Qual a senha");
                    int posicao = -1;
                    for(int i=0;i<contCP;i++){
                        if(listaCP[i].validaAcesso(identificador,senha))
                            posicao = i;
                    }
                    if(posicao>=0){
                        listaCP[posicao] = acessaCP(listaCP[posicao]);
                    }
                    else{
                        System.out.println("Conta inexistente ou senha incorreta!");
                    }
                }
            }
        }
        while(!opc.equals("e"));

        EscreverObjetoContaCor(listaCC);
        EscreverObjetoContaPou(listaCP);
    }
}