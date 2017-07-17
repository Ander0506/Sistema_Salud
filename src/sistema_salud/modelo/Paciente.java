
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Objects;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Paciente implements Serializable {
    
    private IntegerProperty id;
    private StringProperty nombre1;
    private StringProperty nombre2;    
    private StringProperty apellido1;
    private StringProperty apellido2;
    private StringProperty tipoDocumento;
    private StringProperty documento;
    private Calendar fechaNacimiento;
    private StringProperty sexo;
    private ObservableList<Programa> programasAccedidos;
    private Eps epsUser;
    private BooleanProperty estado;

    public Paciente(int id, String nombre1, String apellido1, String apellido2,String TipoDocumento ,String Documento, Calendar FechaNacimiento, String sexo, Eps EpsUser) throws Exception {
        if (id < 0) { throw new Exception("id No puede ser menor que cero"); }
        if (nombre1== null) { throw new Exception("nombre1 No puede Ser nulo"); }
        if (apellido1== null) { throw new Exception("apellido1 No puede Ser nulo"); } 
        if (apellido2== null) { throw new Exception("apellido2 No puede Ser nulo"); } 
        if (Documento== null) { throw new Exception("documento No puede Ser nulo"); } 
        if (FechaNacimiento.after(Calendar.getInstance())) { throw new Exception("Fecha de Naciemiento No puede Ser nulo"); } 
        if (sexo == null) { throw new Exception("Sexo No puede Ser nulo"); } 
        if (EpsUser == null) { throw new Exception("EpsUSer No puede Ser nulo"); } 
        if (TipoDocumento == null){ throw new Exception("El tipo de documento no puede ser nulo");}
        
        this.id = new SimpleIntegerProperty(id);
        this.nombre1 = new SimpleStringProperty(nombre1);
        this.apellido1 = new SimpleStringProperty(apellido1);
        this.apellido2 = new SimpleStringProperty(apellido2);
        this.documento = new SimpleStringProperty(Documento);
        this.sexo = new SimpleStringProperty(sexo);
        this.tipoDocumento = new SimpleStringProperty(TipoDocumento);
        this.estado = new SimpleBooleanProperty(true);
        this.epsUser = EpsUser;
        this.fechaNacimiento = FechaNacimiento;
        programasAccedidos = FXCollections.observableArrayList();
       
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) throws Exception {
        if (id < 0) {
            throw new Exception("ID No puede ser menor que cero");
        } else {
            this.id.set(id);
        }
    }

    public String getNombre1() {
        return nombre1.get();
    }

    public void setNombre1(String nombre1) throws Exception {
        if (nombre1 == null) {
            throw new Exception("NOMBRE1 No puede Ser nulo");
        } else {
            this.nombre1.set(nombre1);
        }
    }

    public String getApellido1() {
        return apellido1.get();
    }

    public void setApellido1(String apellido1) throws Exception {
        if (apellido1 == null) {
            throw new Exception("APELLIDO1 No puede Ser nulo");
        } else {
            this.apellido1.set(apellido1);
        }
    }

    public String getApellido2() {
        return apellido2.get();
    }

    public void setApellido2(String apellido2) throws Exception {
        if (apellido2 == null) {
            throw new Exception("APELLIDO2 No puede Ser nulo");
        } else {
            this.apellido2.set(apellido2);
        }
    }

    public String getDocumento() {
        return documento.get();
    }

    public void setDocumento(String documento) throws Exception {
        if (documento == null) {
            throw new Exception("DOCUMENTO No puede Ser nulo");
        } else {
            this.documento.set(documento);
        }
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String sexo) throws Exception {
        if (sexo == null) {
            throw new Exception("SEXO No puede Ser nulo");
        } else {
            this.sexo.set(sexo);
        }
    }
    
    public String getTipoDocumento() {
        return tipoDocumento.get();
    }

    public void setTipoDocumento(String tipoDocumento) throws Exception {
        if (tipoDocumento == null) {
            throw new Exception("TIPODOCUMENTO No puede Ser nulo");
        } else {
            this.tipoDocumento.set(tipoDocumento);
        }
    }

    public boolean getEstado() {
        return estado.get();
    }

    public void setEstado(boolean estado) throws Exception {
            this.estado.set(estado);
        
    }
    

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Eps getEpsUser() {
        return epsUser;
    }
    
    public void setFechaNaciemiento(Calendar FechaNacimiento) throws Exception {
        if (FechaNacimiento.after(Calendar.getInstance())) { 
            throw new Exception("La Fecha de Naciemiento No puede ser despues de la actual"); }
        else{
        this.fechaNacimiento = FechaNacimiento;
        }
    }
    
    public void setEpsUSer(Eps EpsUser) throws Exception {
        if (EpsUser == null) { throw new Exception("La Eps No puede ser nulo"); }
        else{
        this.epsUser = EpsUser;
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
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nombre1);
        hash = 37 * hash + Objects.hashCode(this.nombre2);
        hash = 37 * hash + Objects.hashCode(this.apellido1);
        hash = 37 * hash + Objects.hashCode(this.apellido2);
        hash = 37 * hash + Objects.hashCode(this.tipoDocumento);
        hash = 37 * hash + Objects.hashCode(this.documento);
        hash = 37 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 37 * hash + Objects.hashCode(this.sexo);
        hash = 37 * hash + Objects.hashCode(this.programasAccedidos);
        hash = 37 * hash + Objects.hashCode(this.epsUser);
        hash = 37 * hash + Objects.hashCode(this.estado);
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
