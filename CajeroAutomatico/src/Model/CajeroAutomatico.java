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
    
    
    /**
     * Método para autenticar al usuario ingresando número de tarjeta y PIN.
     * 
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
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
    
    /**
     * Método para mostrar el saldo de la cuenta del usuario autenticado.
     */
    public void mostrarSaldo(){
        if (usuarioAutenticado == null) {
        System.out.println("Debe autenticarse primero.");
        return;
    }
    double saldo = usuarioAutenticado.getCuenta().getSaldo();
    System.out.println("Saldo disponible: " + saldo);

    } 
    
    /**
     * Método para retirar efectivo de la cuenta del usuario autenticado.
     * 
     * @param cantidad la cantidad de dinero a retirar.
     */
    public  void retirarEfectivo(int cantidad){
        if (usuarioAutenticado == null) {
        System.out.println("Debe autenticarse primero.");
        return;
    }

    Cuenta cuenta = usuarioAutenticado.getCuenta();
    if (cuenta != null) {
        boolean exito = cuenta.retiro(cantidad);  // Llama al método retiro()
        if (exito) {
            System.out.println("Retiro de " + cantidad + " realizado con éxito. Saldo actual: " + cuenta.getSaldo());
        } else {
            System.out.println("No se pudo realizar el retiro. Saldo insuficiente.");
        }
    } else {
        System.out.println("Error: la cuenta no está asociada al usuario.");
    }
}
}
