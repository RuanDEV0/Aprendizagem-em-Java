import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author olive
 */
public class ConjuntoDeDados {
    public static void main(String args[]){
        Scanner ler = new Scanner(System.in);
        int i, sexo,QuantMas = 0,QuantFem = 0;
        double altura,alturaH = 0, maior = 0, menor = 0;
        for(i = 1; i <= 10; i++){
            System.out.println("Informe seu Sexo(1-masculino,2-feminino)");
            sexo = ler.nextInt();
            System.out.println("Informe a altura: ");
            altura = ler.nextDouble();
            if(sexo == 1){
                QuantMas++;
                alturaH += altura;
            }
            else if(sexo == 2)
                QuantFem++;
            else
                System.out.println("Genero invalido!");
            if(altura> maior)
                maior = altura;
            else if(altura < menor)
                menor = altura;
        }
        
        double media = (float)alturaH/QuantMas;
        System.out.println("Maior altura = "+maior);
        System.out.println("Menor altura = "+menor);
        System.out.println("Média de altura dos Homens = "+media);
        System.out.println("Numero de mulheres = "+QuantFem);
    }
}
