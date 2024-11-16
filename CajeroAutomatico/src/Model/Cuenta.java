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
    private Usuario usuario;
    
    // Constructor que acepta bancoPerteneciente, nroCuenta y saldo
    public Cuenta(String bancoPerteneciente, String nroCuenta, double saldo, Usuario usuario) {
        this.bancoPerteneciente = bancoPerteneciente;
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public double MostrarSaldo() {
        return saldo;
    }

    public void deposito(int monto){
        if (monto > 0){
            this.saldo += monto;
        } else {
            System.out.println("Monto de depósito no válido");
        }
    }

    public boolean retiro(int monto){
        if (monto > saldo) {
            System.out.println("No hay saldo suficiente.");
            return false;
        }
        this.saldo -= monto;
        return true;
    }

    public String getBancoPerteneciente() {
        return bancoPerteneciente;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    
    
    }
    

