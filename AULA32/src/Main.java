public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Lista<String> l1 = new Lista();

        l1.adiciona("B");
        l1.adiciona("C");
        l1.adiciona(0, "A");
        l1.adiciona("D");
        l1.adiciona("E");
        l1.adiciona("F");
        l1.adiciona("G");
        l1.adiciona("H");
        l1.adiciona("I");
        l1.adiciona("J");
        l1.adiciona("K");
        l1.adiciona("L");
        l1.adiciona("B");
        System.out.println(l1);
        System.out.println(l1.obter(1));
        try{
            System.out.println("Elemento da posição -1 "+ l1.obter(-1));
        }catch (IllegalAccessException e){
            System.out.println(e);
        }
        System.out.println("Posição "+ l1.posicaoDe("B"));
        System.out.println(l1.posicaoDe("c"));
        System.out.println(l1.remove(0));
        System.out.println(l1);
        System.out.println(l1.contem("M"));
        System.out.println(l1.remove("B"));
        System.out.println(l1);
        l1.limpar();
        System.out.println(l1);
        System.out.println(l1.tamanho());
        System.out.println(l1.estaVazia());
        System.out.println(l1);
        Lista<Integer> listaInteiros = new Lista<>();
        listaInteiros.adiciona(25);
        listaInteiros.adiciona(9);
        listaInteiros.adiciona(5);
        listaInteiros.adiciona(10);
        listaInteiros.adiciona(87);
        listaInteiros.adiciona(96);
        listaInteiros.adiciona(58);
        listaInteiros.adiciona(10);
        listaInteiros.adiciona(21);

        System.out.println("Posição "+listaInteiros.ultimaPosicaoElemento(10));
        System.out.println(listaInteiros.estaVazia());

    }
}
