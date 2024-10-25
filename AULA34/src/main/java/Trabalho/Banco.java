package Trabalho;

import java.sql.*;

public class Banco {

    private Connection conexao;
    private  boolean estaConectado;
    private String mensagemErro;

    private String server;
    private String port;
    private String user;
    private String key;


    public Banco(String server, String port, String user, String key){
        this.server = server;
        this.port = port;
        this.user = user;
        this.key = key;

    }

    public Banco(String user, String key){
        this.user = user;
        this.key = key;

    }

    public Connection obterConexao(){
        try{
            if(server!=null){
                conexao = DriverManager.getConnection("jdbc:mysql"+"://localhost:3306/prog2sexta", "prog2sexta", "123456"/*"jdbc:mysql"+ server + port+ "/"+user, ""+user, ""+key*/);
            }else{
                conexao = DriverManager.getConnection("jdbc:mysql"+"://localhost:3306"+ "/"+user, ""+user, ""+key);
            }


        } catch (SQLException e) {
            mensagemErro = "Erro ao conectar-se com o banco";
        }

        return conexao;
    }

    public String obterMensagemErro(){
        return mensagemErro;
    }

    public String encerraConexao() throws SQLException {

        if(conexao!=null){
            conexao.close();
        }
        return "Status conexão com o banco("+conexao+"): Encerrado";

    }
}
