/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Programa2 {
    public static void main(String[] args) {
        Porta p1 = new Porta();
        p1.dimensaoX = 8;
        p1.dimensaoY = 14;
        p1.dimensaoZ = 2;
        
        p1.abre();
        p1.fecha();
        p1.pinta("Preto");
        p1.pinta("Azul");
        p1.pinta("Branco");
        System.out.println("Cor: "+p1.cor);
        p1.alteraDimensao(6,23,9);
        System.out.println("Porta esta aberta: "+p1.estaAberta());
    }
}
