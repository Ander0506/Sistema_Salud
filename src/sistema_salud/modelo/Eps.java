
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Eps implements Serializable {

    private final StringProperty nombre;
    private final StringProperty codigo;
     public final BooleanProperty estado;

    public Eps(String nombre, String codigo) throws Exception {
        if (nombre == null) {
            throw new Exception("El nombre no puede ser nulo");
        }
         if (codigo == null) {
            throw new Exception("El codigo no puede ser nulo");
        }
        this.nombre = new SimpleStringProperty(nombre);
        this.codigo = new SimpleStringProperty(codigo);
        this.estado = new SimpleBooleanProperty(true);    
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
    
     public Boolean getEstado() {
        return estado.get();
    }

    public void setEstado(Boolean estado) throws Exception {
        this.estado.set(estado);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.codigo);
        return hash;
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
        return  this.nombre.getValue() + "  " + this.codigo.getValue();
    }

    

}
