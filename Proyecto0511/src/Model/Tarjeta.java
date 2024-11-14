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
    private String nroTrajeta ;
    private String bancoPerteneciente;

    public Tarjeta(String nroTrajeta, String bancoPerteneciente) {
        this.nroTrajeta = nroTrajeta;
        this.bancoPerteneciente = bancoPerteneciente;
    }

    
    public String obtenerNroTrajeta() {
        return nroTrajeta;
    }

    public String obtenerNombreDelBanco() {
        return bancoPerteneciente;
    }
    
}
