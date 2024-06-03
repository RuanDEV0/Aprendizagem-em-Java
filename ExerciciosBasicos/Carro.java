/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class Carro {

    private String nome;
    private double preco;
    private String marca;
    private int ano;
    private int identificador;
    private static int cont = 0;

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    Carro() {
        this.identificador = ++cont;
    }

    public String impressaoCarro() {
        String dados = "\n Nome: " + this.nome;
        dados += "\n Marca: " + this.marca;
        dados += "\n Ano: " + this.ano;
        dados += "\n Preco: " + this.preco;
        dados += "\n Identificador: " + this.identificador;
        return dados;
    }
}
