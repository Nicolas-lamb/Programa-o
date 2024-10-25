import java.sql.*;
import java.util.Scanner;

public class AlterarConexão {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        try{
            //loader do driver

            //tentar conectar
            Connection conexao = DriverManager.getConnection("jdbc:mysql"+"://localhost:3306/prog2sexta", "prog2sexta", "123456");
            System.out.println("Estou conectado");

            String sql = " select contato_id, nome, e_mail, telefone, now() as now, time_to_sec(curtime()) as sec from tb_contato;";

            PreparedStatement requisicao = conexao.prepareStatement(sql);
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

            sql = "UPDATE tb_contato set nome = ?, e_mail = ?, telefone = ? WHERE contato_id = ?";
            requisicao =  conexao.prepareStatement(sql);

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
            System.out.println(requisicao);


            conexao.close();
        }//catch (ClassNotFoundException e){
           // System.out.println("Erro ao carrgar o driver!");
        //}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}