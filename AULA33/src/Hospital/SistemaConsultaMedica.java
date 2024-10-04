package Hospital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SistemaConsultaMedica {
    static ArrayList<Paciente> pacientes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int opc = 0;
        try {
            do {
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
                System.out.println("--------------------------------------");


                switch (opc) {
                    case 1 -> incluirPaciente();
                    case 2 -> alterarPaciente();
                    case 3 -> realizarAtendimento();
                    case 4 -> listarPacientes();
                    case 5 -> mostrarPaciente();
                    case 6 -> apagarPaciente();
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (opc != 0);


        }catch (Exception e){
            System.out.println(e);
        }
    }




    public static void incluirPaciente(){
        String nome;
        String sobrenome;
        System.out.print("Digite o primeiro nome do paciente: ");
        nome = scanner.next();
        System.out.print("Digite o sobrenome do paciente: ");
        sobrenome = scanner.next();
        System.out.print("Digite o dia de nascimento: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês de nascimento: ");
        int mes = scanner.nextInt();
        System.out.print("Digite o ano de nascimento: ");
        int ano = scanner.nextInt();
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);

        Paciente paciente = new Paciente(nome, sobrenome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setAtivo(true);
        pacientes.add(paciente);
        System.out.println(pacientes);
    }

    public static void alterarPaciente(){
        try{
            String tipo = "alterar";
            String nomeCompleto = pegarPaciente(tipo);
            for(Paciente paciente: pacientes){
                if(nomeCompleto.equals(paciente.getNome())){
                    System.out.print("Digite o primeiro nome do paciente: ");
                    String nomeMud = scanner.next();
                    System.out.print("Digite o sobrenome do paciente: ");
                    String sobrenomeMud = scanner.next();
                    paciente.setNome(nomeMud);
                    paciente.setSobrenome(sobrenomeMud);
                }else{
                    System.out.println("Paciente não encontrado!");
                }

            }
        }catch (Exception e){
            System.out.println("[ERRO] O nome digitado não é um texto!");
        }
    }

    private static void realizarAtendimento() {
        String tipo = "atendimento";
        String nomeCompleto = pegarPaciente(tipo);
        for (Paciente paciente : pacientes) {
            if (nomeCompleto.equals(paciente.getNome())){
                Atendimento atendimento = new Atendimento();
                System.out.println("Digite a descrição do atendimento: ");
                String descricao = scanner.nextLine();
                atendimento.setDescricao(descricao);
                System.out.print("Digite o dia do atendimento: ");
                int dia = scanner.nextInt();
                System.out.print("Digite o mês do atendimento ");
                int mes = scanner.nextInt();
                System.out.print("Digite o ano do atendimento ");
                int ano = scanner.nextInt();
                LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
                atendimento.setData(dataNascimento);

                paciente.adicionarConsulta(atendimento);
            }
        }


    }

    public static void listarPacientes(){
        for(Paciente paciente: pacientes){
            if(paciente.isAtivo()){
                System.out.println(paciente);
            }
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        }

    }

    public static void mostrarPaciente() {
        try {
            String tipo = "mostrar";
            String nomeCompleto = pegarPaciente(tipo);
            for (Paciente paciente : pacientes) {
                if (nomeCompleto.equals(paciente.getNome())){
                    System.out.println(paciente);
                    //fazendo com que mostre os atendimentos
                    int i =1;
                        for (Atendimento a : paciente.getAtendimentos()) {
                            //separa os atendimentos de 5 em 5
                            if(i==5){
                                System.out.println(a);
                                System.out.println("-----------------------------------------------------------");
                                i = 1;
                                System.out.println(i);
                            }else {
                                System.out.println(a);
                                ++i;
                            }
                            if(a == null){
                                System.out.println("Paciente não marcou consulta");
                            }
                        }

                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void apagarPaciente(){
            String tipo = "apagar";
            String nomeCompleto = pegarPaciente(tipo);
            for(int i =0; i<pacientes.size(); i++){
                if (nomeCompleto.equals(pacientes.get(i).getNome())){
                    pacientes.remove(pacientes.get(i));
                }
            }
           // for (Paciente paciente : pacientes) {
               // if (nomeCompleto.equals(paciente.getNome())){
                //    pacientes.remove(paciente);
               // }
            //}
    }

    public static String pegarPaciente(String tipo){
        switch (tipo){
            case "alterar"->{
                scanner.nextLine();
                System.out.print("Digite o nome completo do paciente que deseja alterar: ");
                String nomeCompleto = scanner.nextLine();
                return nomeCompleto;
            }
            case "mostrar" -> {
                scanner.nextLine();
                System.out.print("Digite o nome completo do paciente que deseja mostrar: ");
                String nomeCompleto = scanner.nextLine();
                return nomeCompleto;
            }
            case "apagar" -> {
                scanner.nextLine();
                System.out.print("Digite o nome completo do paciente que deseja apagar: ");
                String nomeCompleto = scanner.nextLine();
                return nomeCompleto;
            }
            case "atendimento" -> {
                scanner.nextLine();
                System.out.print("Digite o nome completo do paciente que deseja atender: ");
                String nomeCompleto = scanner.nextLine();
                return nomeCompleto;
            }
        }
        return "nao reconhecido";
    }


}
