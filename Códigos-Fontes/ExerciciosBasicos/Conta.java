/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TADS
 */
public class Conta {
    private int numero;
    private double saldo;
    private double limite;
    private String nome;
    private int identificador;
    private static int totalConta = 0;
    
    public void deposita(double valor){
        this.setSaldo(this.getSaldo() + valor);
    }
    public boolean saca(double valor){
        if(valor <= this.getSaldo() + this.getLimite()){
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }else{
            return false;
        }
    }
    public boolean transfere1(Conta destino, double valor){
        if(saca(valor) == true){
            destino.deposita(valor);
            return true;
        }else{
            return false;
        }
    }
    public String recuperaDadosParaImpressao(){
        String dados = "\nNumero: "+this.getNumero();
        dados += "\nSaldo: "+this.getSaldo();
        dados += "\nLimite: "+this.getLimite();
        dados += "\nNome: "+this.getNome();
        return dados;
    }
    public String calculaRendimento(){
        String dados = "\nRendimento = "+this.getSaldo()*0.1;
        return dados;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return this.numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return this.limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getRendimento(){
        double resultado = this.saldo*0.1;
        return resultado;
    }
    public int getIdentificador(){
        return this.identificador;
    }
    public static int getTotalConta(){
        return totalConta;
    }
    Conta(){
        this.identificador = ++Conta.totalConta;
        System.out.println("Concluido!");
    }
}