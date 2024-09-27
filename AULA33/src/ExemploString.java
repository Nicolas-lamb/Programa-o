public class ExemploString {
    public static void main(String[] args) {
        String nome = "Jonas";
        String sobrenome = "Silva";
        String nomeCompleto = nome.concat(sobrenome);
        System.out.println("Nome completo: " +nomeCompleto);
        System.out.println(nomeCompleto.indexOf("a"));
        System.out.println(nomeCompleto.lastIndexOf("a"));
        System.out.println(nomeCompleto.startsWith("J")?"Começa com 'J'":"Não termina com 'J'");
        System.out.println(nomeCompleto.endsWith("a")?"Termina com 'a'":"Não termina com 'a'");
        String frase = "aula de programação";
        System.out.println(frase);
        frase = frase.replace("programação", "programação II");//troca o target pelo replacement
        System.out.println(frase);
        String[] vetor = frase.split(" ");//quebra quando encontrar o caracter
        for(String palavra:vetor){
            System.out.println(palavra);
        }
    }
}
