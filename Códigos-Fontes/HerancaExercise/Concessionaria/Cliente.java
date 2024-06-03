/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise.Concessionaria;

/**
 *
 * @author olive
 */
public class Cliente {
    private String name;
    private int numberIdent;
    private Carro carro;

    Cliente(String name, int numberIdent){
        this.name = name;
        this.numberIdent= numberIdent;
    }
    Cliente(String name, int numberIdent, Carro carro){
        this(name, numberIdent);
        this.carro = carro;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numberIdent
     */
    public int getNumberIdent() {
        return numberIdent;
    }

    /**
     * @param numberIdent the numberIdent to set
     */
    public void setNumberIdent(int numberIdent) {
        this.numberIdent = numberIdent;
    }

    /**
     * @return the carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
