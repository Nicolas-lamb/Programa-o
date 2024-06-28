package exercicio;

import java.util.Random;

public class Conta {
    private String titular;
    private String identificador;
    protected float saldo;
    private String senha;


    public Conta(String titular, String senha){
        this.titular = titular;
        this.senha = senha;
        geraIdentificador();
    }

    public void depositar(float valor){
            this.saldo+=valor;
    }

    public void geraIdentificador(){
        Random alea = new Random();
        String id="";
        for(int i=0; i<4; i++){
            id+=(char)alea.nextInt(65,90);
        }
        id+= alea.nextInt(1000,2000);
        identificador =  id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public boolean validaAcesso(String identificador, String senha){
        return identificador.equals(this.identificador) && senha.equals(this.senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
