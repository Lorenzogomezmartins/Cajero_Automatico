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
public class Tarjeta {
    private String nroTarjeta ;
    private String bancoPerteneciente;

    public Tarjeta(String nroTarjeta, String bancoPerteneciente) {
        this.nroTarjeta = nroTarjeta;
        this.bancoPerteneciente = bancoPerteneciente;
    }

    
    public String obtenerNroTrajeta() {
        return nroTarjeta;
    }

    public String obtenerNombreDelBanco() {
        return bancoPerteneciente;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }
    
}
