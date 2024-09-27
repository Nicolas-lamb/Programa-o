import java.util.Stack;

public class ExemploStack {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();
        System.out.println(pilha.push("Arroz"));
        System.out.println(pilha.push("Queijo"));
        System.out.println(pilha.push("Pastel"));
        System.out.println(pilha.push("Pastel"));
        System.out.println(pilha.push("Chocolate"));
        System.out.println(pilha);
        System.out.println("Tirando ultima posição: "+pilha.pop());
        System.out.println(pilha);
    }
}
