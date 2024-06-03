import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Temperatura {
    public static void main(String agrs[]){
        String nome = JOptionPane.showInputDialog("Informe a Temp em Graus Celsius: ");
        int cel = Integer.parseInt(nome);
        double kelvin, reaumur, rankine, fahre;
        kelvin = cel + 273.15;
        reaumur = cel*0.8;
        rankine = cel*1.8 + 32+459.67;
        fahre = cel*1.8 + 32;
        System.out.println("Temperatura convertida: \n");
        System.out.printf("Kelvin: %fK\n", kelvin);
        System.out.printf("Reaumur: %fRe\n", reaumur);
        System.out.printf("Rankine: %fRa\n", rankine);
        System.out.printf("Fahrenheit: %fF\n", fahre);
    }
}
