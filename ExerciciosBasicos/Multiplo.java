/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Multiplo {
    public static void main(String agrs[]){
        int i;
        System.out.println("Multiplos de 3: ");
        for(i = 1; i < 100;i++){
            if(i%3 == 0){
                System.out.println("- "+i);
            }
        }
    }
}
