/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Programa1 {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Ruan";
        p1.idade = 19;
        
        p1.fazAniversario();
        p1.fazAniversario();
        System.out.println("Nome: "+p1.nome);
        System.out.println("Idade: "+p1.idade);
    }
}
