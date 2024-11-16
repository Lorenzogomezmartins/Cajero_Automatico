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
    
/**
     * Método para mostrar el saldo actual de la cuenta.
     *
     * @return El saldo actual de la cuenta.
     */
    public double MostrarSaldo() {
        return saldo;
    }
    
/**
     * Método para realizar un depósito en la cuenta.
     *
     * @param monto La cantidad a depositar. Debe ser un valor positivo.
     */
    public void deposito(int monto){
        if (monto > 0){
            this.saldo += monto;
        } else {
            System.out.println("Monto de depósito no válido");
        }
    }

    /**
     * Método para realizar un retiro de la cuenta.
     * Verifica si hay saldo suficiente antes de deducir el monto.
     *
     * @param monto La cantidad a retirar. Debe ser menor o igual al saldo disponible.
     * @return true si el retiro se realizó con éxito, false si el saldo es insuficiente.
     */
    public boolean retiro(int monto){
        if (monto > saldo) {
            System.out.println("No hay saldo suficiente.");
            return false;
        }
        this.saldo -= monto;
        return true;
    }

    //GETTERS Y SETTERS
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

   
    
    
    }
    

