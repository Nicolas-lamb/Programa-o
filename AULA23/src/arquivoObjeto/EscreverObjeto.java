package arquivoObjeto;

import java.io.*;
import java.util.Scanner;
public class EscreverObjeto {
    public static void main(String[] args) {
        File caminho = new File("C:\\Users\\nikel\\Documents\\aula23");

        if(caminho.exists()){
            System.out.println("A pasta existe: Sobrescrevendo arquivos");
        }else{
            caminho.mkdirs();//cria o caminho pra o arquivo
            System.out.println("Caminho criado");
        }
        //Declarando o arquivo para salvar a Pessoa
        File arquivo = new File(caminho,"pessoa.db");
        System.out.println(arquivo.getAbsolutePath());
        try{
            ObjectOutputStream arquivoObj = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));

            //criando uma lista de pessoa
            Pessoa[] lista = new Pessoa[10];
            Scanner ler = new Scanner(System.in);
            String opc;
            int cont =0;
            do{
                System.out.println("Lendo informação da pessoa "+(cont+1));
                System.out.print("Qual o nome: ");
                String nome = ler.next();
                System.out.print("Qual o sobrenome: ");
                String sobrenomenome = ler.next();
                lista[cont]= new Pessoa();
                lista[cont].setNome(nome);
                lista[cont].setSobrenome(sobrenomenome);
                System.out.print("Tem mais pessoas(s - sim n - não): ");
                opc = ler.next().toLowerCase();
                while(!opc.equals("s") && !opc.equals("n")){
                    System.out.print("Tem mais pessoas(s - sim n - não): ");
                    opc = ler.next().toLowerCase();
                }
                cont++;
            }while(opc.equals("s"));

            //escreve o array inteiro da lista
            arquivoObj.writeObject(lista);
            //fecha o arquivo
            arquivoObj.close();

        }catch(IOException e){
            System.out.println("Erro ao criar ao criar o arquivo");
        }
    }
}
