import java.util.List;
import java.util.ArrayList;

public class ExemploArrayList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("A");
        lista.add("C");
        lista.add("B");
        lista.add("J");
        lista.add("O");
        lista.add("C");
        lista.add(3, "D");
        System.out.println("Lista desordenada: "+lista);
        lista.sort(null);
        System.out.println("Lista ordenada: "+lista);
        System.out.println(lista.contains("J")? "A lista tem o valor J":"A lista não tem o valor J");
        System.out.println("O 'C' está na posição "+lista.indexOf("C"));
        System.out.println("A última ocorrencia de 'C' esta na posição "+lista.lastIndexOf("C"));
        System.out.println("Removendo da lista o '"+ lista.remove(2)+"'");
        System.out.println(lista.remove("D")?"Removendo o 'D' da lista":"Não foi posivel resolver");
        System.out.println(lista.isEmpty()?"Lista vazia": "Lista não vazia");
        lista.clear();
        System.out.println(lista.isEmpty()?"Lista vazia": "Lista não vazia");



    }
}
