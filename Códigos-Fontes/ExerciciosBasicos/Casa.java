/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Casa {
    String cor;
    boolean porta1;
    boolean porta2;
    boolean porta3;
    
    public void pinta(String s){
        this.cor = s;
    }
    public int quantasPortasEstaoAbertas(){
        int cont = 0;
        if(this.porta1 == true)
            cont++;
        if(this.porta2 == true)
            cont++;
        if(this.porta3 == true)
            cont++;
        return cont;
        
    }
}
