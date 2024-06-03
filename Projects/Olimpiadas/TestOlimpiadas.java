/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Olimpiadas;

/**
 *
 * @author olive
 */
public class TestOlimpiadas {
    public static void main(String[] args) {
        Modalidade modalidade = new Modalidade(TipoModalidade.FUTEBOL);
        Modalidade modalidade2 = new Modalidade(TipoModalidade.GINASTICA);
        Modalidade modalidade3 = new Modalidade(TipoModalidade.ATLETISMO);
        System.out.println("Codigos das modalidades presentes: "+modalidade+", "+modalidade2+", "+modalidade3);
    }
}
