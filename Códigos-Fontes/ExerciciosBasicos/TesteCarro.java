import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class TesteCarro {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Carro carroOne = new Carro();
        System.out.println("whats is name car: ");
        String name= ler.next();
        carroOne.setNome(name);
        System.out.println("Whats is years car: ");
        int ano = ler.nextInt();
        carroOne.setAno(ano);
        System.out.println("Preco do carro: ");
        double preco = ler.nextDouble();
        carroOne.setPreco(preco);
        System.out.println("Marca do carro: ");
        String marca = ler.next();
        carroOne.setMarca(marca);
        
        
        System.out.println(carroOne.impressaoCarro());
    }
}
