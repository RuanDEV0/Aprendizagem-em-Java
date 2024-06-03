
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TADS
 */
public class PrincipalConta {

    public static void main(String agrs[]) {
        Conta c1 = new Conta();
        c1.setNumero(1545);
        c1.setSaldo(25000);
        c1.setLimite(10000);
        c1.setNome("Arrascaeta");
        
        Conta c2 = new Conta();
        Conta c3 = new Conta();
        Conta c4 = new Conta();
        Conta c5 = new Conta();
        Conta c6 = new Conta();
//        String bagCompleted  = "Bag completed!";
//        String bagNotCompleted = "Bag not completed!";
//        String resultado = c1.saca(50000) == true ? bagCompleted : bagNotCompleted;
//        System.out.println(resultado);
        System.out.println(c1.getIdentificador());
        System.out.println(c2.getIdentificador());
        System.out.println(c5.getIdentificador());
        System.out.println("Contas: "+Conta.getTotalConta());
   }
}
