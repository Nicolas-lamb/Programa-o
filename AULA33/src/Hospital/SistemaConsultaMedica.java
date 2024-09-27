package Hospital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaConsultaMedica {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>();

        int opc = 0;
        do{
            System.out.println("\n--- Sistema de Consulta Médica ---");
            System.out.println("1- Incluir paciente");
            System.out.println("2- Alterar paciente");
            System.out.println("3- Realizar um atendimento");
            System.out.println("4- Listar pacientes ativos");
            System.out.println("5- Mostrar paciente");
            System.out.println("6- Apagar paciente");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1 ->
                        incluirPaciente();
                     
                case 2 -> alterarPaciente();
                case 3 -> realizarAtendimento();
                case 4 -> listarPacientes();
                case 5 -> mostrarPaciente();
                case 6 -> apagarPaciente();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }while(opc!=0);



    }

    public static void incluirPaciente(){
        String nome;
        String sobrenome;
        LocalDate dataNascimento;
        System.out.print("Digite o primeiro nome do paciente: ");
        nome = scanner.next();
        System.out.println("Digite o sobrenome do paciente: ");
        sobrenome = scanner.next();
        System.out.println("Digite o dia de nascimento");
        int dia = scanner.nextInt();
        System.out.println("Digite o mês de nascimento");
        int mes = scanner.nextInt();
        System.out.println("Digite o ano de nascimento");
        int ano = scanner.nextInt();
        dataNascimento = LocalDate.of(ano, mes, dia);

    }

}
