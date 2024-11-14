/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MIPC
 */
public class DispensadorDeBilletes {
    private HashMap<Billete, Integer> billetes;

    public DispensadorDeBilletes() {
        this.billetes = new HashMap<Billete, Integer>();
        
    }
    public void reabastecerBilletes(Billete billete, int cantidad){
        this.billetes.put(billete, cantidad);

    }
    public Map<Billete, Integer> retirar(int monto){
        Map<Billete, Integer> resultado = new HashMap<>(); 
        int restante = monto;

        ArrayList<Billete> denominaciones = new ArrayList<>(billetes.keySet());
        denominaciones.sort((b1, b2) -> Integer.compare(b2.getValor(), b1.getValor()));

        for (Billete billete : denominaciones) {
            int denominacion = billete.getValor();
            int cantidadDisponible = this.billetes.get(billete);

            if (denominacion <= restante && cantidadDisponible > 0) {
                int billetesNecesarios = Math.min(restante / denominacion, cantidadDisponible);
                if (billetesNecesarios > 0) {
                    resultado.put(billete, billetesNecesarios);
                    restante -= billetesNecesarios * denominacion;
                }
            }
        }

        if (restante > 0) {
            System.out.println("No hay suficiente cambio para el monto solicitado.");
            return null; 
        }

        // Actualiza las cantidades de billetes después de realizar el retiro
        for (Map.Entry<Billete, Integer> entrega : resultado.entrySet()) {
            Billete billete = entrega.getKey();
            int cantidadUsada = entrega.getValue();
            billetes.put(billete, billetes.get(billete) - cantidadUsada);
        }

        return resultado; 
    }
    
}
