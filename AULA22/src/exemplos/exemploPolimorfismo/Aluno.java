package exemplos.exemploPolimorfismo;

public class Aluno extends Pessoa{
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String obterDados(){
        return "Nome: "+getNome()+" Sobrenome: "+getSobrenome()+" Matrícula: "+matricula;
    }

    //obterdados de jeito diferente
    @Override
    public String toString(){
        return "Nome: "+getNome()+" Sobrenome: "+getSobrenome()+" Matrícula: "+matricula;
    }
}
