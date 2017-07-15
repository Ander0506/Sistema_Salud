/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Item implements Serializable {
    
    private String nombre;
    private Boolean estado;

    public Item(String nombre) throws Exception {
        if (nombre == null) { throw new Exception("EL nombre no puede Ser nulo"); } 
        this.nombre = nombre;
        this.estado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
    if (nombre == null) { throw new Exception("EL nombre no puede Ser nulo"); } 
    else{
        this.nombre = nombre;
    }
    }

    public Boolean getEstado() {
        return estado;
    }

    public void activar(){
        estado = true;
    }
    
    public void desactivar(){
        estado = false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nombre:" + nombre + " estado:" + estado;
    }
    

    
    
}
