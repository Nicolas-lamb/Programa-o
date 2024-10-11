import java.sql.*;
import java.util.Scanner;

public class InserirConexao {
    public static void main(String[] args) {
        try{
            //loader do driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //tentar conectar
            Connection conexao = DriverManager.getConnection("jdbc:mysql"+"://localhost:3306/prog2sexta", "prog2sexta", "123456");
            System.out.println("Estou conectado");

            String sql = "insert into tb_contato(nome, e_mail, telefone) values (?, ?, ?)";

            //criando requisição
            PreparedStatement requisicao = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            Scanner ler =new Scanner(System.in);
            System.out.print("Nome: ");
            String nome = ler.nextLine();
            System.out.print("E-mail: ");

            String mail = ler.next();
            System.out.print("Fone: ");
            String fone = ler.next();

            requisicao.setString(1, nome);
            requisicao.setString(2,mail);
            requisicao.setString(3,fone);

            //executar a requisição
            requisicao.execute();
            //recuperando o id gerado
            ResultSet resultado = requisicao.getGeneratedKeys();
            if (resultado.next()){
                int idContato = resultado.getInt(1);
                System.out.println("Contato "+nome+" gravado com o id "+idContato);
            }
            conexao.close();
        }catch (ClassNotFoundException e){
            System.out.println("Erro ao carrgar o driver!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}