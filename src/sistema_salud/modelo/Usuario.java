
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Usuario implements Serializable {
    
    public String nombre;
    public String user;
    public String apellidos;
    public String id;
    public String correo;
    public String tipo;
    public String sexo;
    public boolean estado;
    public String password;
    

    public Usuario(String id, String nombre, String apellidos, String correo, String tipo, String sexo, String user, String password)throws Exception{
        if (user == null) {
            throw new Exception("El user no puede ser nulo");
        }
        if (id == null) {
            throw new Exception("El id no puede ser nulo");
        }
        if (password == null) {
            throw new Exception("La contraseña no puede ser nulo");
        }
        if (nombre == null) {
            throw new Exception("El nombre no puede ser nulo");
        }
        if (apellidos == null) {
            throw new Exception("El apellido no puede ser nulo");
        }
        this.nombre = nombre;
        this.user = user;
        this.apellidos = apellidos;
        this.id = id;
        this.correo = correo;
        this.tipo = tipo;
        this.sexo = sexo;
        this.password = password;
        this.estado = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) throws Exception {
        if (user == null) {
            throw new Exception("El user no puede ser nulo");
        }
        this.user = user;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) throws Exception{
         if (apellidos == null) {
            throw new Exception("El apellido no puede ser nulo");
        }
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id == null) {
            throw new Exception("El id no puede ser nulo");
        }
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password == null) {
            throw new Exception("La contraseña no puede ser nulo");
        }
        this.password = password;
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
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.apellidos);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + (this.estado ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.password);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
