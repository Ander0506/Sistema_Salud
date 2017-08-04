package sistema_salud.modelo;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Eps {

    private String nombre;
    private String codigo;
    private boolean estado;

    public Eps(String nombre, String codigo) throws Exception {

        if (nombre == null) {
            throw new Exception("NOMBRE No puede Ser nulo");
        }
        if (codigo == null) {
            throw new Exception("CODIGO No puede Ser nulo");
        }

        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("NOMBRE No puede Ser nulo");
        } else {
            this.nombre = nombre;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Exception {
        if (codigo == null) {
            throw new Exception("CODIGO No puede Ser nulo");
        } else {
            this.codigo = codigo;
        }
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) throws Exception {
        this.estado = estado;
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
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.codigo);
        hash = 89 * hash + (this.estado ? 1 : 0);
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
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return this.nombre;
    }

}
