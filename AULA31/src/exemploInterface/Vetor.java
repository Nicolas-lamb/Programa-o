/**
 * @version 1
 * @author Nicolas
 */

package exemploInterface;

public class Vetor implements Lista{
    private String[] elementos;
    private int tamanho;
    /**
     *@param capacidade capacidade inicial da lista
     */
    public Vetor(int capacidade){
        elementos = new String[capacidade];
        tamanho = 0;
    }
    /**
     *@param elemento elemento que sera adicionado
     */
    @Override
    public void adiciona(String elemento){
        elementos[tamanho] = elemento;
        tamanho++;
    }
    /**
     *Método remove o último elemento da lista
     * @return retorna o tamanho atualizado
     */
    public String remove(){
        if(tamanho>0){
            return elementos[--tamanho];
        }
        return null;
    }
    /**
    * Retorna a quantidade de elementos atualmente da lista
    * @return inteiro do tamanho da lista
    */
    public int getTamanho(){
        return tamanho;
    }
    /**
     * Monta uma string com os elementos presentes na lista
     * @return um conjunto vazio para listas vazias = [] ou um conjunto com os
     * elementos da lista = ['a' 'b' 'c']
     */
    @Override
    public String toString(){
        String resultado = "[";
        if(tamanho>0){
            for(int i=0;i<tamanho; i++){
                resultado+=elementos[i]+" ";
            }
        }
        resultado+="]";
        return resultado;
    }

}
