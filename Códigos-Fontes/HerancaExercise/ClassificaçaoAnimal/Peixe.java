/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise;

/**
 *
 * @author olive
 */
public class Peixe extends Animal {
    protected String caracteristica;

    public Peixe(String nome, float comprimento, int numeroDePatas, String cor, String ambiente, float velocidadeMedia, String caracteristica) {
        super(nome, comprimento, numeroDePatas, cor, ambiente, velocidadeMedia);
        this.caracteristica = caracteristica;
    }
    
    public void setCaracteristica(String caracteristica){
        this.caracteristica = caracteristica;
    }
    
    public String getCaracteristica(){
        return caracteristica;
    }
    
    public String toString(){
        String dados = super.toString();
        dados += "\n Caracteristica: "+this.caracteristica;
        return dados;
    }
}
