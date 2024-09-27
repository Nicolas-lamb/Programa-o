import java.util.HashMap;

public class ExemploHashMap {
    public static void main(String[] args) {
        HashMap<String, String> capitais= new HashMap<>();//só tipos de objeto
        capitais.put("RS", "Porto Alegre");
        capitais.put("PR", "Curitiba");
        capitais.put("SC", "Florianópolis");
        capitais.put("RJ", "Rio de Janeiro");
        capitais.put("SP", "São Paulo");
        System.out.println(capitais);
        capitais.put("RS", "Rio Grande");//sobreescreve
        System.out.println(capitais);
        System.out.println(capitais.remove("RS"));
        capitais.put("RS", "Porto Alegre");
        System.out.println(capitais);
        for(String estado:capitais.keySet())//keySet pega as chaves ex:RS
            System.out.println(estado+ " ");
        for(String cidades:capitais.values())//values pega os valores ex:Porto Alegre
            System.out.println(cidades);
        System.out.println(capitais.containsKey("RS")?"Tem Rio Grande do Sul":"Não tem RS");
        System.out.println(capitais.containsValue("Porto Alegre")?"Tem Porto Alegre": "Não tem Porto Alegre");
    }
}
