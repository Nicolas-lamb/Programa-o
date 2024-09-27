import java.util.HashSet;

public class ExemploHashSet {
    public static void main(String[] args) {
        HashSet<String> compras = new HashSet<>();
        System.out.println(compras.add("Arroz")?"Adicionando arroz na lista ":"Não foi posivel adicionar");
        System.out.println(compras.add("Queijo")?"Adicionando queijo na lista ":"Não foi posivel adicionar");
        System.out.println(compras.add("Pastel")?"Adicionando pastel na lista ":"Não foi posivel adicionar");
        System.out.println(compras.add("Pastel")?"Adicionando pastel na lista ":"Não foi posivel adicionar mais pastel");
        System.out.println(compras.add("Chocolate")?"Adicionando chocolate na lista ":"Não foi posivel adicionar");
        System.out.println(compras);
    }
}
