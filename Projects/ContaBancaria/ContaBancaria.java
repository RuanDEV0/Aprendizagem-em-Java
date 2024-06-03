/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise.ContaBancaria;

/**
 *
 * @author olive
 */
public class ContaBancaria {

    protected String client;
    protected int numAccount;
    protected float balance;
    protected static int cont;

    ContaBancaria(String client, float balance) {
        this.client = client;
        this.balance = balance;
        this.numAccount = ++cont;
    }
    public void toWithedraw(float value){
        if(value > getBalance()){
            System.out.println("Saque invalido!");
        }else{
            setBalance(getBalance() - value);
        }
    }

    /**
     * @return the client
     */
    public String getClient() {
        return client;
    }

    public static int getCont(){
        return cont;
    }
    /**
     * @param client the client to set
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * @return the numAccount
     */
    public int getNumAccount() {
        return numAccount;
    }

    /**
     * @param numAccount the numAccount to set
     */
    public void setNumAccount(int numAccount) {
        this.numAccount = numAccount;
    }

    /**
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }
}
