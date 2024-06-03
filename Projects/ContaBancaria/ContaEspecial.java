/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise.ContaBancaria;

/**
 *
 * @author olive
 */
public class ContaEspecial extends ContaBancaria{
    protected float limit;
    ContaEspecial(String client, float balance, float limit){
        super(client, balance);
        this.limit = limit;
    }
    public void toWithedraw(float value){
        if(value > getLimit()){
            System.out.println("Saque invalido!");
        }else{
            setBalance(getBalance() - value);
        }
    }
    public void setLimit(float limit){
        this.limit = limit;
    }
    public float getLimit(){
        return limit;
    }
}
