/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Azulejo {
    public static void main(String agrs[]){
        float hp = 2.6f, lp = 1.6f, ha = 0.35f, la = 0.3f, resul;
        resul = (hp*lp)/(ha*la);
        System.out.printf("Azulejos necessarios = %.2f\n", resul);
    }
}
