package exHeranca;

public class Principal {
    public static void main(String[] args) {
        Motorista m1 = new Motorista("João", "Silva", 123 );
//        String nome = setNome("João");
//        m1.setSobrenome("Silva");
//        m1.setMatricula(123);
        m1.setSalario(1200);
        m1.setCnh("42735835");
        System.out.println("Nome do motorista: "+m1.getNome()+" "+m1.getSobrenome());
        System.out.println(("Recebe R$"+String.format("%.2f", m1.getSalario())));

        Engenheiro e1 = new Engenheiro("Jean", "William", 1234);
//        e1.setNome("Jean");
//        e1.setSobrenome("Willian");
//        e1.setMatricula(1234);
        e1.setSalario(30000);
        e1.setCrea("2314224425");
        System.out.println("Nome do engenheiro: "+e1.getNome()+" "+e1.getSobrenome());
        System.out.println(("Recebe R$"+String.format("%.2f", e1.getSalario())));
        float media = (m1.getSalario()+e1.getSalario())/2;
        System.out.println("Média salarial: "+String.format("%.2f", media));
    }
}
