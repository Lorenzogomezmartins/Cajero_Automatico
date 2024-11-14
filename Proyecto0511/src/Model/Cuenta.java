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
public class Cuenta {
    private String bancoPerteneciente;
    private String nroCuenta;
    private double saldo;

    public double MostrarSaldo() {
        return saldo;
    }
    
    public void deposito(int monto){
        this.saldo += monto;
    }
    
    public void retiro(int monto){
        if (monto > this.saldo){
            this.saldo -= monto;
        }else{
            System.out.println("No hay saldo suficiente.");
        }
        
    }
    
}
