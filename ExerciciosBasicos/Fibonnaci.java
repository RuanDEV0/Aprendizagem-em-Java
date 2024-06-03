/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Fibonnaci {
    public static void main(String agrs[]){
        int i, n1 = -1, n2 = 1, n3;
        do{
            n3 = n1+n2;
            n1 = n2;
            n2 = n3;
            System.out.println(n3);
        }while(n3<100);
    }
}
