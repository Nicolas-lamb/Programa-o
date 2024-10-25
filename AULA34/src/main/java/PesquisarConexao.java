import java.sql.*;
import java.util.Scanner;

public class PesquisarConexao {
    public static void main(String[] args) {
        try{

            Scanner ler = new Scanner(System.in);
            //loader do driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //tentar conectar
            Connection conexao = DriverManager.getConnection("jdbc:mysql"+"://localhost:3306/prog2sexta", "prog2sexta", "123456");
            System.out.println("Estou conectado");

            String sql = " select contato_id, nome, e_mail, telefone, now() as now, time_to_sec(curtime()) as sec from tb_contato where SOUNDEX(nome) like soundex(?) or e_mail like ? or telefone like ?";
            

            PreparedStatement requisicao = conexao.prepareStatement(sql);
            System.out.print("Qual o termo de busca: ");
            String termo = ler.next();

            requisicao.setString(1, "%"+termo+"%");
            requisicao.setString(2, "%"+termo+"%");
            requisicao.setString(3, "%"+termo+"%");
            ResultSet resultado = requisicao.executeQuery();
            while(resultado.next()){
                int idContato = resultado.getInt("contato_id");
                String nome = resultado.getString("nome");
                String email = resultado.getString("e_mail");
                String telefone = resultado.getString("telefone");
                String data = resultado.getString("now");
                String segundos = resultado.getString("sec");

                System.out.println("Id: "+idContato);
                System.out.println("Nome: "+nome);
                System.out.println("E-mail: "+email);
                System.out.println("Telefone: "+ telefone);
                System.out.println("Hora requisição: "+data);
                System.out.println("Segundos: "+ segundos);
                System.out.println("---------------------------------------");

            }






            conexao.close();
        }catch (ClassNotFoundException e){
            System.out.println("Erro ao carrgar o driver!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}