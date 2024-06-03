/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise;

/**
 *
 * @author olive
 */
public class TestarAnimais {

    public static void main(String[] args) {
        Mamifero camelo = new Mamifero("Camelo", 150F, 4, "amarelo", "terra", 2.0F, "");
        Peixe tubarao = new Peixe("Tubarao", 300F, 0, "Cinzento", "Mar", 1.5F, "Barbatanas e cauda");
        Mamifero ursoCanada = new Mamifero("Urso-do-canada", 180F, 4, "Vermelho", "Terra", 0.5F, "Mel");
        System.out.println(camelo.toString());
        System.out.println();
        System.out.println(ursoCanada.toString());
        System.out.println();
        System.out.println(tubarao.toString());
        System.out.println();
    }
}
