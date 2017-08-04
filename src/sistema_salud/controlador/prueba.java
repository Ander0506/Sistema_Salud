/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.controlador;

import sistema_salud.modelo.SistemaSer;

/**
 *
 * @author LENOVO
 */
public class prueba {

    
    public static void main(String[] args) {
    String ruta = "src/Datos/Sistema.txt";
    SistemaSer sistema = SistemaSer.cargar(ruta);
    System.out.println(sistema.getUsuarios().get(0).getNombre());
    }
    
}
