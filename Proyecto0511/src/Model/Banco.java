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
    
    
}
