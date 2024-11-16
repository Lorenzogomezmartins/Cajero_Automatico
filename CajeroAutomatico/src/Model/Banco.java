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
public class Banco {
    private String nombre;
    private List<Cuenta> cuentasBancarias;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentasBancarias = new ArrayList<>();
        
    }
    
    /**
     * Método para agregar una cuenta al banco.
     * 
     * @param cuenta La cuenta a agregar.
     */
    public void agregarCuenta(Cuenta cuenta) {
        cuentasBancarias.add(cuenta);
    }
    
    

    /**
     * Método para buscar un usuario por su número de cuenta.
     * 
     * @param nroCuenta El número de cuenta a buscar.
     * @return El número de cuenta si se encuentra, o null si no existe.
     */
    public String buscarUsuarioPorCuenta(String nroCuenta) {
        for (Cuenta cuenta : cuentasBancarias) {
            if (cuenta.getNroCuenta().equals(nroCuenta)) {
                return nroCuenta;
            }
        }
        return null; // Si no se encuentra la cuenta
    }

    /**
     * Método para mostrar todas las cuentas en el banco.
     */
   public void mostrarCuentas() {
        System.out.println("Cuentas en el banco " + nombre + ":");
        for (Cuenta cuenta : cuentasBancarias) {
            System.out.println("Número de cuenta: " + cuenta.getNroCuenta() + ", Saldo: " + cuenta.MostrarSaldo());
        }
   }
   
   /**
     * Método para buscar un usuario por su número de tarjeta.
     * 
     * @param nroTarjeta El número de tarjeta a buscar.
     * @return El usuario asociado a la tarjeta si se encuentra, o null si no existe.
     */
   public Usuario buscarUsuarioPorTarjeta(String nroTarjeta) {
        for (Cuenta cuenta : cuentasBancarias) {
            Usuario usuario = cuenta.getUsuario();  // Obtén el usuario asociado a la cuenta
            if (usuario != null && usuario.getTarjeta().getNroTarjeta().equals(nroTarjeta)) {
                return usuario; // Si encuentra el usuario con el número de tarjeta proporcionado
            }
        }
        return null; // Si no encuentra el usuario
    }
   }