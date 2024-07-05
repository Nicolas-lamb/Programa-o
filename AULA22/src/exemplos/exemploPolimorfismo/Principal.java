package exemplos.exemploPolimorfismo;

public class Principal {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.setSobrenome("Jonas");
        p1.setNome("Silva");
        Aluno a1 = new Aluno();
        a1.setNome("Nicolas");
        a1.setSobrenome("Lamb");
        a1.setMatricula("a1234");

        System.out.println(p1.obterDados());
        System.out.println(a1.obterDados());
    }
}
