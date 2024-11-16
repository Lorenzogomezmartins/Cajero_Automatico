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
public class Usuario {
    private  String pin;
    private Cuenta cuenta;
    private Tarjeta tarjeta;

    public Usuario(String pin, Cuenta cuenta, Tarjeta tarjeta) {
        this.pin = pin;
        this.cuenta = cuenta;
        this.tarjeta = tarjeta;
    }
    
    /**
     * Método para autenticar al usuario.
     * Verifica que el número de la tarjeta y el PIN proporcionados
     * coincidan con los datos del usuario.
     *
     * @param nroTarjeta El número de la tarjeta de débito a verificar.
     * @param pin El PIN ingresado para autenticación.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
    public boolean autenticar(String nroTarjeta, String pin) {
    return this.tarjeta.getNroTarjeta().equals(nroTarjeta) && this.pin.equals(pin);
}

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public String getPin() {
        return pin;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    
    
}
