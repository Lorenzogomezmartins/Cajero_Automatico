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
    
    public void agregarTransaccion(Transaccion transaccion){
        this.historial.add(transaccion);
    }

    public List<Transaccion> mostrarTransacciones() {
        return historial;
    }
    
    
}
