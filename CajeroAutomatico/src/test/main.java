/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import Model.Banco;
import java.util.Scanner;
import Model.CajeroAutomatico;
import Model.Cuenta;
import Model.DispensadorDeBilletes;
import Model.Tarjeta;
import Model.Usuario;


/**
 *
 * @author MIPC
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear los objetos necesarios
        Banco banco = new Banco("Banco Central");
         
        CajeroAutomatico cajero = new CajeroAutomatico(banco);  // Usar 'cajero' en lugar de 'cajeroAutomatico'
        Tarjeta tarjeta1 = new Tarjeta("1234567890123456", "Banco Central");

        // Crear la cuenta
        Cuenta cuenta1 = new Cuenta("Banco Ejemplo", "001", 20000.0, null);  // Inicializa la cuenta sin usuario aún

        // Crear el usuario, asignándole la cuenta y la tarjeta
        Usuario usuario1 = new Usuario("1234", cuenta1, tarjeta1);

        
        // Agregar la cuenta al banco
        banco.agregarCuenta(cuenta1);
        cuenta1.setUsuario(usuario1);  // Asociar usuario a la cuenta

    // Agregar la cuenta al banco
    banco.agregarCuenta(cuenta1);
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        
        while (true) {
            System.out.println("\n*** MENÚ CAJERO AUTOMÁTICO ***");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Mostrar saldo");
            System.out.println("3. Retirar efectivo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    // Iniciar sesión
                    if (cajero.autentificar()) {
                        System.out.println("Inicio de sesión exitoso.");
                    } else {
                        System.out.println("Autenticación fallida.");
                    }
                    break;
                case 2:
                    // Mostrar saldo
                    cajero.mostrarSaldo();
                    break;
                case 3:
                    // Retirar efectivo
                    System.out.print("Ingrese la cantidad a retirar: ");
                    int cantidad = scanner.nextInt();
                    cajero.retirarEfectivo(cantidad);
                    break;
                case 4:
                    // Salir
                    System.out.println("Gracias por usar el cajero automático.");
                    return; // Termina el programa
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
    }
