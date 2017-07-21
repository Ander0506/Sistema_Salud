
package sistema_salud.modelo;

import java.util.Objects;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Usuario {
    
    public final StringProperty nombre;
    public final StringProperty user;
    public final StringProperty apellidos;
    public final StringProperty id;
    public final StringProperty correo;
    public final StringProperty tipo;
    public final StringProperty sexo;
    public final BooleanProperty estado;
    public final StringProperty password;

    public Usuario(String id, String nombre, String apellidos, String correo, String tipo, String sexo,  String user, String password) throws Exception {
        if(user == null){ throw new Exception("El usuario no puede ser nulo"); }
        if(password == null){ throw new Exception("la contraseña no puede ser nula");}
 
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.correo = new SimpleStringProperty(correo);
        this.tipo = new SimpleStringProperty(tipo);
        this.sexo = new SimpleStringProperty(sexo);
        this.user = new SimpleStringProperty(user);
        this.password = new SimpleStringProperty(password);
        this.estado = new SimpleBooleanProperty(true);    
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) throws Exception {
        this.nombre.set(nombre);
    }

    public String getUser() {
        return user.get();
    }

    public void setUser(String user) throws Exception {
        if (user == null) {
            throw new Exception("USER No puede Ser nulo");
        } else {
            this.user.set(user);
        }
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) throws Exception {
        this.apellidos.set(apellidos);
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) throws Exception {
        this.id.set(id);
    }

    public String getCorreo() {
        return correo.get();
    }

    public void setCorreo(String correo) throws Exception {
        this.correo.set(correo);
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) throws Exception {
        this.tipo.set(tipo);
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String sexo) throws Exception {
        this.sexo.set(sexo);
    }

    public Boolean getEstado() {
        return estado.get();
    }

    public void setEstado(Boolean estado) throws Exception {
        this.estado.set(estado);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) throws Exception {
        if (password == null) {
            throw new Exception("PASSWORD No puede Ser nulo");
        } else {
            this.password.set(password);
        }
    }
    
    public void activar(){
        estado.set(true);
    }
    
    public void desactivar(){
        estado.set(false);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.user);
        hash = 97 * hash + Objects.hashCode(this.apellidos);
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.estado);
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
