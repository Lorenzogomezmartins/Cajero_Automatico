/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


public class Deposito extends Transaccion{
    private String tipo;
    
    public Deposito(int cantidad, String nroTarjeta, boolean estadoTransaccion) {
        super(cantidad, nroTarjeta, estadoTransaccion);
        this.tipo = "Deposito";
    }


    @Override
    public String toString() {
        return "Transaccion{" + "cantidad= " + cantidad + ", nroTarjeta= " + nroTarjeta + ", estadoTransaccion= " + estadoTransaccion + "tipo= " + tipo + '}';
    }

    
    
}
