package arquivoTexto;

import java.io.*;
import java.nio.Buffer;

public class EscreverTexto {
    public static void main(String[] args) {
        try{
            BufferedWriter arquivoTexto = new BufferedWriter(new FileWriter("./AULA23/src/arquivoTexto/texto.txt"));
            for(int i=0; i<10;i++){
                arquivoTexto.append("Linha "+i+" do arquivo\n");
            }
            arquivoTexto.close();

        }catch(FileNotFoundException e){
            System.out.println("Erro ao escrever o arquivo");
        }catch(IOException e){
            System.out.println("Erro ao criar o arquivo");
        }


    }
}
