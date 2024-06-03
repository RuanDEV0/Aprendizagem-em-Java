/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Porta {
    boolean aberta = false;
    String cor;
    double dimensaoX;
    double dimensaoY;
    double dimensaoZ;
    
    public void abre(){
        if(this.aberta != true){
            this.aberta = true;
            System.out.println("Porta aberta!");
        }else{
            System.out.println("Ainda aberta!");
        }
    }
    public void fecha(){
        if(this.aberta != false){
            this.aberta = false;
            System.out.println("Porta Fechada!");
        }else{
            System.out.println("Ainda fechada!");
        }
    }
    public void pinta(String s){
        this.cor = s;
    }
    public boolean estaAberta(){
        return this.aberta;
    }
    public void alteraDimensao(double x, double y, double z){
        this.dimensaoX = x;
        this.dimensaoY = y;
        this.dimensaoZ = z;
    }
}
