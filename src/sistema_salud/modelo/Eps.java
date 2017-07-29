/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author andre
 */
public class Eps implements Serializable {

    private final StringProperty nombre;
    private final StringProperty codigo;

    public Eps(String nombre, String codigo) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre no puede ser nulo");
        }
         if (codigo == null) {
            throw new Exception("El codigo no puede ser nulo");
        }
        this.nombre = new SimpleStringProperty(nombre);
        this.codigo = new SimpleStringProperty(codigo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre no puede ser nulo");
        } else {
            this.nombre.set(nombre); 
        }
    }

    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) throws Exception {
        if (codigo == null) {
            throw new Exception("El codigo no puede ser nulo");
        } else {
            this.codigo.set(codigo);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Eps other = (Eps) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + " codigo: " + codigo;
    }

}
