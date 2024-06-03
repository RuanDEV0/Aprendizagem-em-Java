/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HerancaExercise;

/**
 *
 * @author olive
 */
public abstract class Animal {

    private String nome;
    private float comprimento;
    private int numeroDePatas;
    private String cor;
    private String ambiente;
    private float velocidadeMedia;
    
    
    Animal(String nome, float comprimento, int numeroDePatas, String cor, String ambiente, float velocidadeMedia) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.numeroDePatas = numeroDePatas;
        this.cor = cor;
        this.ambiente = ambiente;
        this.velocidadeMedia = velocidadeMedia;
    }
    
    public String toString() {
        String dados = "Nome: " + this.getNome();
        dados += "\nComprimento: " + this.getComprimento();
        dados += "\nNumero de Patas: " + this.getNumeroDePatas();
        dados += "\nCor: " + this.getCor();
        dados += "\nAmbiente: " + this.getAmbiente();
        dados += "\nVelocidade Media: " + this.getVelocidadeMedia();
        return dados;
    }

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
     * @return the comprimento
     */
    public float getComprimento() {
        return this.comprimento;
    }

    /**
     * @param comprimento the comprimento to set
     */
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    /**
     * @return the numeroDePatas
     */
    public int getNumeroDePatas() {
        return this.numeroDePatas;
    }

    /**
     * @param numeroDePatas the numeroDePatas to set
     */
    public void setNumeroDePatas(int numeroDePatas) {
        this.numeroDePatas = numeroDePatas;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return this.cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return this.ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the velocidadeMedia
     */
    public float getVelocidadeMedia() {
        return this.velocidadeMedia;
    }

    /**
     * @param velocidadeMedia the velocidadeMedia to set
     */
    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

}
