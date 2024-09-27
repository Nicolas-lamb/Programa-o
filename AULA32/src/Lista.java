public class Lista <T>{
    private T[] elementos;
    private int tamanho;

    public Lista(int capacidade){
        elementos= (T[])new Object[capacidade];
        tamanho = 0;
    }
    public Lista(){
        elementos = (T[])new Object[10];
        tamanho=0;
    }

    public boolean remove(T elemento) throws IllegalAccessException {
        int posicao = posicaoDe(elemento);

        if(posicao<0 || posicao>=tamanho){
            throw new IllegalAccessException("posição inválida");
        }
        for(int i = posicao;i<tamanho-1;i++ ){
            elementos[i] = elementos[i+1];
        }
        tamanho--;
        return true;
    }

    public void limpar(){
        T[] lista2 = (T[])new Object[10];
        tamanho =0;
        elementos = lista2;
    }
    public int tamanho(){
        return elementos.length;
    }

    public boolean estaVazia(){
        for(int i = 0;i<tamanho;i++ ){
            if(elementos[i]!= null){
                return false;
            }
        }
        return true;
    }

    public int ultimaPosicaoElemento(T elemento){
        int posicao = 0;
        for(int i =0; i<tamanho; i++){
            if(elementos[i].equals(elemento)) {
                posicao = i;
            }
        }
        if(posicao !=0){
            return posicao;
        }
        return -1;
    }

    public void adiciona(T elemento){
        aumentaCapacidade();
            elementos[tamanho++] = elemento;
    }

    public void adiciona(int posicao, T elemento) throws IllegalAccessException {
        if(posicao<0 || posicao>=tamanho){
            throw new IllegalAccessException("posição inválida");
        }
        aumentaCapacidade();
        for(int i = tamanho-1;i>=posicao; i--){
            elementos[i+1] = elementos[i];
        }
        elementos[posicao] = elemento;
        tamanho++;
    }

    public boolean contem(T elemento){
        for(int i =0; i<tamanho; i++){
            if(elementos[i].equals(elemento))
                return true;
        }
        return false;
    }

    public T obter(int posicao) throws IllegalAccessException {
        if(posicao<0 || posicao>=tamanho){
            throw new IllegalAccessException("posição inválida");
        }
        return elementos[posicao];
    }

    public int posicaoDe(T elemento){
        for(int i =0; i<tamanho; i++){
            if(elementos[i].equals(elemento))
                return i;
        }
        return -1;
    }


    private void aumentaCapacidade(){
        if(tamanho== elementos.length){
            T[] aux = (T[])new Object[tamanho*2];
            //System.arraycopy(elementos,0,aux,elementos.length mesma coisa que o for
            for(int i=0; i<tamanho; i++)
                aux[i] = elementos[i];
            elementos = aux;

        }
    }

    public T remove(int posicao) throws IllegalAccessException {
        if(posicao<0 || posicao>=tamanho){
            throw new IllegalAccessException("posição inválida");
        }
        T elemento = elementos[posicao];
        for(int i = posicao;i<tamanho-1;i++ ){
            elementos[i] = elementos[i+1];
        }
        tamanho--;
        return elemento;
    }



    @Override
    public String toString(){
        String retorno = "[";
        if(tamanho>0){
            for(int i = 0; i<tamanho-1; i++){
                retorno+=elementos[i]+", ";
            }
            retorno+=elementos[tamanho-1];
        }
        retorno+="]";
        return retorno;
    }


}
