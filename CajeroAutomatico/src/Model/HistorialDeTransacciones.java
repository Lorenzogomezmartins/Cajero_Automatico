/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MIPC
 */
public class HistorialDeTransacciones {
    private List<Transaccion> historial;

    public HistorialDeTransacciones() {
        this.historial = new ArrayList<Transaccion>();
    }
    
    /**
     * Método para agregar una transacción al historial.
     * 
     * @param transaccion La transacción a agregar al historial.
     */
    public void agregarTransaccion(Transaccion transaccion){
        this.historial.add(transaccion);
    }

    /**
     * Método para mostrar todas las transacciones en el historial.
     * 
     * @return La lista de transacciones almacenadas en el historial.
     */
    public List<Transaccion> mostrarTransacciones() {
        return historial;
    }
    
    
}
