package exercicio;

public class ContaPou extends Conta{
    private float deposito;

    public ContaPou(String titular, String senha, float deposito){
        super(titular,senha);
        saldo = deposito;
    }

    public boolean sacar(float valor){
        if(saldo>=valor){
            saldo-=valor;
            return true;
        }
        return false;
    }

    public String verificaSaldo(){
        String retorno = String.format("Seu saldo é de R$.2f\n",saldo);
        return retorno;
    }




}
