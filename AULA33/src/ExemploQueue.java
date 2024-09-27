import java.util.ArrayDeque;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {
        Queue<String> fila = new ArrayDeque<>();
        fila.add("João");
        fila.add("Maria");
        fila.add("Jean");
        fila.add("Pedro");
        fila.add("Ana");
        fila.add("Lucas");
        System.out.println("O próximo da fila é "+fila.peek());//pega primeiro elemento
        System.out.println("Atendendo "+fila.remove()); // tira primeiro elemento
        System.out.println(fila);
    }
}
