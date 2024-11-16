/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author MIPC
 */
public class CajeroAutomatico {
    private Banco bancoAccesible;
    private HistorialDeTransacciones historial;
    private Usuario usuarioAutenticado;
    private DispensadorDeBilletes dispensador;

    public CajeroAutomatico(Banco bancoAccesible) {
        this.bancoAccesible = bancoAccesible;
        this.historial =  new HistorialDeTransacciones();
        this.dispensador = new DispensadorDeBilletes();
    }
    
    
    
    public  boolean autentificar(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su número de tarjeta: ");
        String nroTarjeta = scanner.nextLine();
        System.out.print("Ingrese su PIN: ");
        String pin = scanner.nextLine();
        
        // Buscar al usuario por la tarjeta
        Usuario usuario = bancoAccesible.buscarUsuarioPorTarjeta(nroTarjeta);
        
        if (usuario != null && usuario.autenticar(nroTarjeta, pin)) {
            usuarioAutenticado = usuario;  // Guardar el usuario autenticado
            System.out.println("Autenticación exitosa. Bienvenido.");
            return true;
        } else {
            System.out.println("Número de tarjeta o PIN incorrecto. Intente de nuevo.");
            return false;
        }

    }
    
    public void mostrarSaldo(){
        if (usuarioAutenticado == null) {
        System.out.println("Debe autenticarse primero.");
        return;
    }
    double saldo = usuarioAutenticado.getCuenta().getSaldo();
    System.out.println("Saldo disponible: " + saldo);

    } 
    
    public  void retirarEfectivo(int cantidad){
        if (usuarioAutenticado == null) {
        System.out.println("Debe autenticarse primero.");
        return;
    }

    Cuenta cuenta = usuarioAutenticado.getCuenta();
    if (cuenta != null && cuenta.getSaldo() >= cantidad) {
        // Verificamos si el dispensador tiene billetes suficientes para el retiro
        Map<Billete, Integer> billetesRetirados = dispensador.retirar(cantidad); // Cambié el método a 'retirar'
        
        if (billetesRetirados != null) {
            // Si el dispensador tiene los billetes, realizamos el retiro
            cuenta.retiro(cantidad);  // Actualizamos el saldo de la cuenta

            // Crear una nueva transacción de tipo Retiro
            Retiro transaccion = new Retiro(cantidad, usuarioAutenticado.getTarjeta().getNroTarjeta(), true);
            historial.agregarTransaccion(transaccion);  // Agregamos la transacción al historial

            System.out.println("Retiro de " + cantidad + " realizado con éxito.");
        } else {
            // Si no tiene billetes suficientes
            System.out.println("Fondos insuficientes en el dispensador o no se puede hacer el cambio solicitado.");
        }
    } else {
        System.out.println("Fondos insuficientes en la cuenta.");
    }
 }
}
