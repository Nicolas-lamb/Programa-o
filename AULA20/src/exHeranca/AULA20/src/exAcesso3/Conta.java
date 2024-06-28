package exHeranca.AULA20.src.exAcesso3;

import java.util.Random;

public class Conta {
    private String titular;
    private String identificador;
    private String senha;
    private float saldo;
    static String nomeBanco;

//criando atributo



//constructor
    Conta(String titular, String senha, float deposito){
        this.titular = titular;
        this.senha = senha;
        saldo = deposito;
        geraIdentificador();
    }

    public void depositar(float valor){
        saldo +=valor;
    }
    public void sacar(float valor){
        saldo-=valor;
    }

    public float verificaSaldo(){
        return saldo;
    }

    private void geraIdentificador(){
        Random alea = new Random();
        String identificador="";
        for(int i=0; i<4; i++){
            identificador+=(char)alea.nextInt(65,90);
        }
        identificador+= alea.nextInt(1000,2000);
        this.identificador = identificador;

    }
    public String getIdentificador(){
        return identificador;
    }
    public String getTitular(){
        return titular;

    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setTitular(String titular){
        this.titular = titular;
    }


}
