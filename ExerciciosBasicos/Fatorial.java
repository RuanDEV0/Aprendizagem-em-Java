/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Fatorial {
    public static void main(String agrs[]){
        int i, n;
        for(i = 1; i <= 10; i++){
            int resul = 1;
            for(n = 1; n <= i; n++){
                resul = resul*n; 
            }
            System.out.printf("%d! = %d\n", i, resul);
        }
    }
}
