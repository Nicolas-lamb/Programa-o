
package Hospital;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Paciente {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private ArrayList<Atendimento> atendimentos;
    private boolean ativo;

    public Paciente(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.atendimentos = new ArrayList<Atendimento>();
    }

    public boolean isAtivo() {
            return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome(){
        String nomeCompleto = nome +" "+sobrenome;
        return nomeCompleto;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){;
        return sobrenome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void adicionarConsulta(Atendimento atendimento) {
        this.atendimentos.add(atendimento);
    }

    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        // Calcula a diferença entre as datas
       Period periodo = Period.between(dataNascimento, dataAtual);
        //Obtém a idade da pessoa
       return periodo.getYears();
    }

    @Override
    public String toString() {
        String retorno = "Nome: " + nome + " " + sobrenome;
        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = formatoBr.format(this.dataNascimento);
        retorno += ", Data de nascimento: " + data;
        retorno += ", Idade: " + getIdade();
        return retorno;
    }

}
