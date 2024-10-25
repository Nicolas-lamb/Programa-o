package Trabalho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contato {

    private Integer idContato;
    private String nome;
    private String email;
    private String telefone;
    private Connection conexao;

    Scanner ler = new Scanner(System.in);

    public Contato(Connection conexao){
        this.conexao = conexao;
    }
    public Contato(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void gravarContato() throws SQLException {
        String sql = "insert into tb_contato(nome, e_mail, telefone) values (?, ?, ?)";

        //criando requisição
        PreparedStatement requisicao = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


        requisicao.setString(1, nome);
        requisicao.setString(2,email);
        requisicao.setString(3,telefone);

        //executar a requisição
        requisicao.execute();
        //recuperando o id gerado
        ResultSet resultado = requisicao.getGeneratedKeys();
        if (resultado.next()){
            this.idContato = resultado.getInt(1);
            System.out.println("Contato "+nome+" gravado no banco com o id "+this.idContato);
        }

        if(conexao == null){
            throw new SQLException("Contato sem conexão");
        }

    }
    public void atualizaContado() throws SQLException {
        String sql = "UPDATE tb_contato set nome = ?, e_mail = ?, telefone = ? WHERE contato_id = "+this.idContato;

        PreparedStatement requisicao = conexao.prepareStatement(sql);

        System.out.print("Nome: ");
        String nome = ler.next();
        System.out.print("E-mail: ");
        String email = ler.next();
        System.out.print("Telefone: ");
        String telefone = ler.next();

        requisicao.setString(1, nome);
        requisicao.setString(2, email);
        requisicao.setString(3, telefone);

        int res = requisicao.executeUpdate();

        if(res >0){
            System.out.println("Alteração feita");
        }else{
            System.out.println("Não foi possível realizar a alteração");
        }
    }

    public void atualizaContatoById() throws SQLException {
        String sql = "UPDATE tb_contato set nome = ?, e_mail = ?, telefone = ? WHERE contato_id = ?";
        PreparedStatement requisicao =  conexao.prepareStatement(sql);

        System.out.print("Digite o id que deseja alterar: ");
        int id = ler.nextInt();

        System.out.print("Nome: ");
        String nome = ler.next();
        System.out.print("E-mail: ");
        String email = ler.next();
        System.out.print("Telefone: ");
        String telefone = ler.next();

        requisicao.setString(1, nome);
        requisicao.setString(2, email);
        requisicao.setString(3, telefone);
        requisicao.setInt(4, id);
        int res = requisicao.executeUpdate();

        if(res >0){
            System.out.println("Alteração feita");
        }else{
            System.out.println("Não foi possível realizar a alteração");
        }
    }
    public void deletarContado() throws SQLException {
        String sql = "delete from tb_contato WHERE contato_id = "+this.idContato;

        PreparedStatement requisicao = conexao.prepareStatement(sql);


        int res = requisicao.executeUpdate();

        if(res >0){
            System.out.println("Exclusão feita");
        }else{
            System.out.println("Não foi possível realizar a exclusão");
        }


    }

    public void deletarContatoById() throws SQLException {
        String sql = "delete from tb_contato WHERE contato_id = ?";
        PreparedStatement requisicao =  conexao.prepareStatement(sql);

        System.out.print("Digite o id que deseja excluir: ");
        int id = ler.nextInt();


        requisicao.setInt(1, id);
        int res = requisicao.executeUpdate();

        if(res >0){
            System.out.println("Exclusão feita");
        }else{
            System.out.println("Não foi possível realizar a exclusão");
        }
    }

    public ResultSet obterContatoById(int idContato) throws SQLException {
        String sql = " select contato_id, nome, e_mail, telefone from tb_contato where contato_id =" + idContato;


        PreparedStatement requisicao = conexao.prepareStatement(sql);

        return  requisicao.executeQuery();

    }
    public ResultSet obterContatos() throws SQLException {
        String sql = " select contato_id, nome, e_mail, telefone from tb_contato where contato_id =" + this.idContato;


        PreparedStatement requisicao = conexao.prepareStatement(sql);

        return requisicao.executeQuery();
    }

    public List<Contato> obterListaContato() throws SQLException {
        List<Contato> list = new ArrayList<>();
        String sql = " select contato_id, nome, e_mail, telefone from tb_contato";

        PreparedStatement requisicao = conexao.prepareStatement(sql);

        ResultSet resultado = requisicao.executeQuery();

        while(resultado.next()){

            Contato contato = new Contato();

            int idContato = resultado.getInt("contato_id");
            String nome = resultado.getString("nome");
            String email = resultado.getString("e_mail");
            String telefone = resultado.getString("telefone");
            contato.setIdContato(idContato);
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setTelefone(telefone);

            list.add(contato);

        }
        return list;
    }

    public List<Contato> pesquisarContato(String termo) throws SQLException {
        List<Contato> list = new ArrayList<>();
        String sql = " select contato_id, nome, e_mail, telefone from tb_contato where nome like ? or e_mail like ? or telefone like ?";

        PreparedStatement requisicao = conexao.prepareStatement(sql);
        requisicao.setString(1, "%"+termo+"%");
        requisicao.setString(2, "%"+termo+"%");
        requisicao.setString(3, "%"+termo+"%");



        ResultSet resultado = requisicao.executeQuery();

        while(resultado.next()){

            Contato contato = new Contato();

            int idContato = resultado.getInt("contato_id");
            String nome = resultado.getString("nome");
            String email = resultado.getString("e_mail");
            String telefone = resultado.getString("telefone");
            contato.setIdContato(idContato);
            contato.setNome(nome);
            contato.setEmail(email);
            contato.setTelefone(telefone);

            list.add(contato);

        }

        return list;
    }

    @Override
    public String toString() {
        return "Contato{id=" + idContato + ", nome='" + nome + '\'' + ", email='" + email + '\'' + ", telefone='" + telefone + '\'' + '}';
    }


}
