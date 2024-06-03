/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Olimpiadas;

/**
 *
 * @author olive
 */
public class Modalidade {

    private TipoModalidade tipoModalidade;

    Modalidade(TipoModalidade tipoModalidade) {
        this.tipoModalidade = tipoModalidade;
    }
    
    public String toString(){
        return " "+tipoModalidade.getValor();
    }

    /**
     * @return the tipoModalidade
     */
    public TipoModalidade getTipoModalidade() {
        return tipoModalidade;
    }

}
