
package sistema_salud.modelo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Paciente {
    
    private Integer id;
    private String nombre1;
    private String nombre2;    
    private String apellido1;
    private String apellido2;
    private String tipoDocumento;
    private String documento;
    private LocalDate fechaNacimiento;
    private String sexo;
    private LinkedList<Programa> programasAccedidos;
    private Eps epsUser;
    private Boolean estado;

    public Paciente(int id, String nombre1, String nombre2,String apellido1, String apellido2,String tipoDocumento ,String documento, LocalDate fechaNacimiento, String sexo, Eps epsUser) throws Exception {
        if (id < 0) { throw new Exception("id No puede ser menor que cero"); }
        if (nombre1== null) { throw new Exception("nombre1 No puede Ser nulo"); }
        if (apellido1== null) { throw new Exception("apellido1 No puede Ser nulo"); } 
        if (apellido2== null) { throw new Exception("apellido2 No puede Ser nulo"); } 
        if (documento== null) { throw new Exception("documento No puede Ser nulo"); } 
        if (fechaNacimiento == null) { throw new Exception("Fecha de Naciemiento No puede Ser nulo"); } 
        if (sexo == null) { throw new Exception("Sexo No puede Ser nulo"); } 
        if (epsUser == null) { throw new Exception("EpsUSer No puede Ser nulo"); } 
        if (tipoDocumento == null){ throw new Exception("El tipo de documento no puede ser nulo");}
        
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.documento = documento;
        this.sexo = sexo;
        this.tipoDocumento = tipoDocumento;
        this.estado = true;
        this.epsUser = epsUser;
        this.fechaNacimiento = fechaNacimiento;
        programasAccedidos = new LinkedList<>();
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id < 0) {
            throw new Exception("ID No puede ser menor que cero");
        } else {
            this.id = id;
        }
    }
    
    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) throws Exception {
        if (nombre1 == null) {
            throw new Exception("Primer nombre No puede Ser nulo");
        } else {
            this.nombre1 = nombre1;
        }
    }
    
    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
    
    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) throws Exception {
        if (apellido1 == null) {
            throw new Exception("APELLIDO1 No puede Ser nulo");
        } else {
            this.apellido1 = apellido1;
        }
    }
    
    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) throws Exception {
        if (apellido2 == null) {
            throw new Exception("APELLIDO2 No puede Ser nulo");
        } else {
            this.apellido2 = apellido2;
        }
    }
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) throws Exception {
        if (documento == null) {
            throw new Exception("DOCUMENTO No puede Ser nulo");
        } else {
            this.documento = documento;
        }
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) throws Exception {
        if (sexo == null) {
            throw new Exception("SEXO No puede Ser nulo");
        } else {
            this.sexo = sexo;
        }
    }
    
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) throws Exception {
        if (tipoDocumento == null) {
            throw new Exception("TIPODOCUMENTO No puede Ser nulo");
        } else {
            this.tipoDocumento = tipoDocumento;
        }
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getEstado() {
        return estado;
    }

    void setEstado(boolean estado) throws Exception {
            this.estado = estado;
        
    }

    public Eps getEpsUser() {
        return epsUser;
    }

    public void setEpsUSer(Eps EpsUser) throws Exception {
        if (EpsUser == null){
            throw new Exception("La Eps No puede ser nulo");
        }else{
            this.epsUser = EpsUser;
        }
    }
    
    public LinkedList<Programa> getProgramas() {
        return programasAccedidos;
    }
    
    public void activar(){
        try {
            setEstado(true);
        } catch (Exception ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desactivar(){
        try {
            setEstado(false);
        } catch (Exception ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nombre1);
        hash = 17 * hash + Objects.hashCode(this.nombre2);
        hash = 17 * hash + Objects.hashCode(this.apellido1);
        hash = 17 * hash + Objects.hashCode(this.apellido2);
        hash = 17 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 17 * hash + Objects.hashCode(this.documento);
        hash = 17 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 17 * hash + Objects.hashCode(this.sexo);
        hash = 17 * hash + Objects.hashCode(this.programasAccedidos);
        hash = 17 * hash + Objects.hashCode(this.epsUser);
        hash = 17 * hash + Objects.hashCode(this.estado);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id + " nombre: " + nombre1 + " " + nombre2 + " " + apellido1 +
                " " + apellido2 + " doc: " + documento + " FechaNacimiento: " + fechaNacimiento + " " +
                sexo + " programas Accedidos: " + programasAccedidos + " Eps: " + epsUser +" Estado: "+estado;
    }

    //Gestionar Pogramas Accedidos
    
    public void adicionarPrograma(Programa progAdicionar)throws Exception{
       if (progAdicionar == null) {
            throw new Exception("El programa no puede ser nulo");
        }
        programasAccedidos.add(progAdicionar);
    }
    
    public boolean buscarPrograma(Programa progABuscar)throws Exception{
        if (progABuscar == null) {
            throw new Exception("El programa no se encuentra");
        }
        return programasAccedidos.contains(progABuscar);
    }
    
    public boolean eliminarPrograma(Programa progAEliminar) throws Exception{
        if (progAEliminar == null) {
            throw new Exception("El programa a eliminar no se encuentra");
        }
        return programasAccedidos.remove(progAEliminar);
    }

}
