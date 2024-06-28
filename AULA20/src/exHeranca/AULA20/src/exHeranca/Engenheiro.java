package exHeranca.AULA20.src.exHeranca;

public class Engenheiro extends Funcionario {
    private String crea;

    public Engenheiro(String nome, String sobrenome, int matricula){
        super(nome,sobrenome,matricula);
    }

    public String getCrea() {
        return crea;
    }

    public void setCrea(String crea) {
        this.crea = crea;
    }
}
