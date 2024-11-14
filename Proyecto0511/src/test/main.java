/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.Billete;
import Model.DispensadorDeBilletes;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MIPC
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Billete billete1 = new Billete(1000);
        Billete billete2 = new Billete(2000);
        Billete billete3 = new Billete(500);
        
        /*
        
        
        */
        DispensadorDeBilletes dispenser = new DispensadorDeBilletes();
        dispenser.reabastecerBilletes(billete3, 1);
        dispenser.reabastecerBilletes(billete2, 5);
        dispenser.reabastecerBilletes(billete1, 5);
        
        Map<Billete, Integer> resultado = dispenser.retirar(15500);
        System.out.println("retiro: " + resultado);
        
        Map<Billete, Integer> resultado2 = dispenser.retirar(500);
        System.out.println("retiro: " + resultado2);
    }
    
}
