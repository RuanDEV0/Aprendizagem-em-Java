import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class VolumeOleo {
    public static void main(String args[]){
        Scanner ler = new Scanner(System.in);
        float v, r, a;
        System.out.println("Informe o raio: ");
        r = ler.nextFloat();
        System.out.println("InForme a altura: ");
        a = ler.nextFloat();
        v = (float) (3.14159*r*r*a);
        System.out.println("Volume = "+v);
    }
}
