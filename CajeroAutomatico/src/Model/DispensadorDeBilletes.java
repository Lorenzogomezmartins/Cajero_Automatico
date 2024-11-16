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
    /**
     * Método para reabastecer billetes en el dispensador.
     * 
     * @param billete El billete a reabastecer.
     * @param cantidad La cantidad de billetes a agregar.
     */
    public void reabastecerBilletes(Billete billete, int cantidad){
        this.billetes.put(billete, cantidad);

    }
    
    /**
     * Método para retirar un monto específico de dinero.
     * 
     * @param monto El monto a retirar.
     * @return Un mapa que contiene los billetes dispensados y su cantidad, o null si no se puede dispensar el monto.
     */
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
    
    /**
     * Método para verificar si hay billetes disponibles para un monto específico.
     * 
     * @param monto El monto a verificar.
     * @return true si hay suficientes billetes disponibles, false en caso contrario.
     */
     public boolean tieneBilletesDisponibles(int monto) {
        int restante = monto;

        ArrayList<Billete> denominaciones = new ArrayList<>(billetes.keySet());
        denominaciones.sort((b1, b2) -> Integer.compare(b2.getValor(), b1.getValor()));

        for (Billete billete : denominaciones) {
            int denominacion = billete.getValor();
            int cantidadDisponible = this.billetes.get(billete);

            if (denominacion <= restante) {
                int billetesNecesarios = Math.min(restante / denominacion, cantidadDisponible);
                restante -= billetesNecesarios * denominacion;
            }
        }

        return restante == 0;
    }
     
    /**
     * Método para dispensar billetes para un monto específico.
     * 
     * @param monto El monto a dispensar.
     */
     public void dispensarBilletes(int monto) {
        Map<Billete, Integer> resultado = retirar(monto);
        if (resultado != null) {
            System.out.println("Billetes dispensados:");
            for (Map.Entry<Billete, Integer> entry : resultado.entrySet()) {
                Billete billete = entry.getKey();
                int cantidad = entry.getValue();
                System.out.println("Billete de " + billete.getValor() + ": " + cantidad + " billetes");
            }
        }
    }
}
