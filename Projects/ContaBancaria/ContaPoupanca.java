/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise.ContaBancaria;

/**
 *
 * @author olive
 */
public class ContaPoupanca extends ContaBancaria {

    protected int dayInPerformance;

    ContaPoupanca(String client, float balance, int dayInPerformance) {
        super(client, balance);
        this.dayInPerformance = dayInPerformance;
    }

    public void calculateNewBalance(float yieldRate) {
        setBalance(getBalance() * yieldRate);
    }

    public void setDayInPerformance(int dayInPerformance) {
        this.dayInPerformance = dayInPerformance;
    }

    public int getDayInPerformance() {
        return dayInPerformance;
    }
}
