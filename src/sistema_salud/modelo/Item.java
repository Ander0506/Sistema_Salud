
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Item implements Serializable {

    private String nombre;
    private Boolean estado;
    private String codigo;

    
    public Item(String id, String nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("EL nombre no puede Ser nulo");
        }
        if (id == null) {
            throw new Exception("EL id no puede Ser nulo");
        }

        this.nombre = nombre;
        this.codigo = id;
        this.estado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre No puede Ser nulo");
        }
            this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
            this.estado = estado;
        
    }
    
    public String getId() {
        return codigo;
    }

    public void setId(String value) throws Exception {
        if (value == null) {
            throw new Exception("EL id no puede Ser nulo");
        }
        this.codigo = value;
    }

    public void activar(){
        try {
            setEstado(true);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desactivar(){
        try {
            setEstado(false);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.estado);
        hash = 47 * hash + Objects.hashCode(this.codigo);
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
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return codigo + " " + nombre + " " + estado;
    }

}
