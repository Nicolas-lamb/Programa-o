package Trabalho;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner ler = new Scanner(System.in);

        Banco banco = null;
        Contato contato = null;

        Class.forName("com.mysql.cj.jdbc.Driver");

        String opc;
        do{
            System.out.println("==========================");
            System.out.println("1 - Conectar com o banco");
            System.out.println("2 - Conectar com o banco local");
            System.out.println("3 - Adicionar contato");
            System.out.println("4 - Atribuir conexão ao contato");
            System.out.println("5 - Alterar contato");
            System.out.println("0 - Conectar com o banco local");
            System.out.println("===============================");
            System.out.print("Opção: ");
            opc = ler.next();



            switch (opc){
                case "1" ->{
                    System.out.print("Digite o servidor:");
                    String server = ler.next();
                    System.out.print("Digite a porta:");
                    String port = ler.next();
                    System.out.print("Digite o usuário:");
                    String user = ler.next();
                    System.out.print("Digite a senha:");
                    String key = ler.next();
                    banco = new Banco(server , port, user, key);
                    System.out.println(banco.obterConexao());
                }
                case "2" ->{
                    System.out.print("Digite o usuário:");
                    String user = ler.next();
                    System.out.print("Digite a senha:");
                    String key = ler.next();
                    banco = new Banco(user, key);
                    System.out.println(banco.obterConexao());
                }
                case "3"->{
                    String opc2;

                    do {
                        System.out.println("++++++++++++++++++++++++++++++");
                        System.out.println("1 - Deseja criar com conexão");
                        System.out.println("2 - Deseja criar sem conexão");
                        System.out.println("++++++++++++++++++++++++++++++");
                        System.out.print("Opção: ");
                        opc2 = ler.next();

                        switch (opc2) {
                            case "1" -> {
                                if (banco != null) {
                                    contato = new Contato(banco.obterConexao());
                                } else {
                                    System.out.println("Não há nenhuma conexão com o banco");
                                }
                            }
                            case "2" -> {
                                contato = new Contato();
                                System.out.println("[ALERTA] Você criou um contato sem conexão, portanto utilize a opção 4 antes de criar outra para que não perca esse");
                            }

                        }

                        ler.nextLine();
                        System.out.print("Nome: ");
                        contato.setNome(ler.nextLine());
                        System.out.print("E-mail: ");
                        contato.setEmail(ler.next());
                        System.out.print("Fone: ");
                        contato.setTelefone(ler.next());

                        if (contato.getConexao() != null) {
                            contato.gravarContato();
                        }
                    }while(opc2.equals("3"));
                }
                case "4"->{
                    if(banco!=null && contato!=null){
                        contato.setConexao(banco.obterConexao());
                        System.out.println("Conexão atribuida...");
                        contato.gravarContato();
                    }else{
                        System.out.println("Contato ou banco não adicionados");
                    }

                }
                case "5"->{
                    String opc3;

                    do {
                        System.out.println("++++++++++++++++++++++++++++++");
                        System.out.println("1 - Deseja alterar usuário por id");
                        System.out.println("2 - Deseja alterar usuário sem id(altera último usuário com conexão atribuída)");
                        System.out.println("3 - Voltar");
                        System.out.println("++++++++++++++++++++++++++++++");
                        System.out.print("Opção: ");
                        opc3 = ler.next();

                        if(opc3.equals("1")){
                            if(contato!=null)
                                contato.atualizaContatoById();
                            else
                                System.out.println("Não há nenhum contato criado na classe");

                            opc3 = "3";
                        }else if(opc3.equals("2")){
                            if(contato!=null) {
                                contato.atualizaContado();
                                System.out.println(contato.getIdContato());
                            }else
                                System.out.println("Não há nenhum contato criado na classe");
                            opc3 = "3";
                        }

                    }while(!opc3.equals("3"));
                }




                case "0"->{

                    if(banco!=null){
                        System.out.println(banco.encerraConexao());
                    }else{
                        System.out.println("Nenhum banco conectado");
                    }

                }


            }
        }while(!opc.equals("4"));





    }
}
