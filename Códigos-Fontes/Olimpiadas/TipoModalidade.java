/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Olimpiadas;

/**
 *
 * @author olive
 */
public enum TipoModalidade {
    FUTEBOL(1)
    ,GINASTICA(2)
    ,NATACAO(3)
    ,ATLETISMO(4);
    
    private int valor;
    private static int [] valores;
    TipoModalidade(int valor){
        this.valor = valor;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }
}
