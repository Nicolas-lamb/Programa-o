package exemploInterface;

public class Main {
    public static void main(String[] args) {
        Vetor v1 = new Vetor(10);

        v1.adiciona("J");
        v1.adiciona("E");
        v1.adiciona("A");
        v1.adiciona("N");
        System.out.println("Qual o tamanho de v1 "+v1.getTamanho());
        System.out.println(v1);
        System.out.println("Apagando o elemento "+v1.remove());
        System.out.println(v1);

        Lista l1 = new Vetor(5);

        l1.adiciona("teste");
        l1.remove();
        System.out.println(l1);
        //l1.getTamanho(); não é comum dos dois não dá;
    }
}
