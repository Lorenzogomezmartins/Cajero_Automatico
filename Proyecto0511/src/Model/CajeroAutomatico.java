/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MIPC
 */
public class CajeroAutomatico {
    private Banco bancoAccesible;
    private HistorialDeTransacciones historial;
    private DispensadorDeBilletes dispensador;

    public CajeroAutomatico(Banco bancoAccesible) {
        this.bancoAccesible = bancoAccesible;
        this.historial =  new HistorialDeTransacciones();
        this.dispensador = new DispensadorDeBilletes();
    }
    
    
    
    public static boolean autentificar(String tarjeta, int pin){
        return true;
    }
    
    public static double mostrarSaldo(){
        return 0.0;
    } 
    
    public static void retirarEfectivo(int cantidad){
        
    }
    
    public static void depocitarEfectivo(int cantidad){
        
    }
    
    public static void cerrarSesion(){
        
    }
}
