import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
    public static void main(String[] args) {
        try{
            //loader do driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //tentar conectar
            Connection conexao = DriverManager.getConnection("jdbc:mysql"+"://localhost:3306/prog2sexta", "prog2sexta", "123456");
            System.out.println("Estou conectado");
            conexao.close();
        }catch (ClassNotFoundException e){
            System.out.println("Erro ao carrgar o driver!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}