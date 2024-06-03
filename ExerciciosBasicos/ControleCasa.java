/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class ControleCasa {
    public static void main(String[] args) {
        Casa cas = new Casa();
        cas.pinta("Cinza");
        cas.porta1 = false;
        cas.porta2 = true;
        cas.porta3 = true;
        
        System.out.println("Cor: "+cas.cor);
        System.out.println("Portas abertas: "+cas.quantasPortasEstaoAbertas());
    }
    
}
