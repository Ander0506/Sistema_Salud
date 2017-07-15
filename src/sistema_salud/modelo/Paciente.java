
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Objects;

public class Paciente implements Serializable {
    
    private int id;
    private String nombre1;
    private String nombre2;    
    private String apellido1;
    private String apellido2;
    private String Tipodocumento;
    private String documento;
    private Calendar FechaNacimiento;
    private String sexo;
    private LinkedList<Programa> programasAccedidos;
    private Eps EpsUser;
    private Boolean estado;

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
        
        this.id = id;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.documento = Documento;
        this.FechaNacimiento = FechaNacimiento;
        this.sexo = sexo;
        this.EpsUser = EpsUser;
        this.Tipodocumento = TipoDocumento;
        programasAccedidos = new LinkedList<>();
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDocumento() {
        return documento;
    }

    public Calendar getFechaNacimiento() {
        return FechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public Eps getEpsUser() {
        return EpsUser;
    }

    public String getTipodocumento() {
        return Tipodocumento;
    }

    public Boolean getEstado() {
        return estado;
    }
    
    
    public void setid(int id) throws Exception {
        if (id < 0) { throw new Exception("EL id No puede ser menor que cero"); }
        else{
        this.id = id;
        }
    }
    
    public void setnombre1(String nombre1) throws Exception {
        if (nombre1 == null) { throw new Exception("EL nombre uno No puede ser nulo"); }
        else{
        this.nombre1 = nombre1;
        }
    }
    
    public void setnombre2(String nombre2) throws Exception {
        if (nombre2 == null) { throw new Exception("EL segundo nombre No puede ser nulo"); }
        else{
        this.nombre2 = nombre2;
        }
    }
    
    public void setapellido1(String apellido1) throws Exception {
        if (apellido1 == null) { throw new Exception("EL primer apellido No puede ser nulo"); }
        else{
        this.apellido1 = apellido1;
        }
    }
    
    public void setapellido2(String apellido2) throws Exception {
        if (apellido2 == null) { throw new Exception("EL segundo apellido No puede ser nulo"); }
        else{
        this.apellido2 = apellido2;
        }
    }
    
    public void setdocumento(String documento) throws Exception {
        if (documento == null) { throw new Exception("EL documento No puede ser nulo"); }
        else{
        this.documento = documento;
        }
    }
    
    public void setFechaNaciemiento(Calendar FechaNacimiento) throws Exception {
        if (FechaNacimiento.after(Calendar.getInstance())) { 
            throw new Exception("La Fecha de Naciemiento No puede ser despues de la actual"); }
        else{
        this.FechaNacimiento = FechaNacimiento;
        }
    }
    
    public void setSexo(String sexo) throws Exception {
        if (sexo == null) { throw new Exception("EL Sexo No puede ser nulo"); }
        else{
        this.sexo = sexo;
        }
    }
    
    public void setEpsUSer(Eps EpsUser) throws Exception {
        if (EpsUser == null) { throw new Exception("La Eps No puede ser nulo"); }
        else{
        this.EpsUser = EpsUser;
        }
    }

    public void setTipodocumento(String Tipodocumento) throws Exception {
      if (Tipodocumento == null){ throw new Exception("El tipo de documento no puede ser nulo");}
      else{
         this.Tipodocumento = Tipodocumento; 
      }
        
    }
    
    public void activar(){
        estado = true;
    }
    
    public void desactivar(){
        estado = false;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nombre1);
        hash = 89 * hash + Objects.hashCode(this.nombre2);
        hash = 89 * hash + Objects.hashCode(this.apellido1);
        hash = 89 * hash + Objects.hashCode(this.apellido2);
        hash = 89 * hash + Objects.hashCode(this.documento);
        hash = 89 * hash + Objects.hashCode(this.FechaNacimiento);
        hash = 89 * hash + Objects.hashCode(this.sexo);
        hash = 89 * hash + Objects.hashCode(this.programasAccedidos);
        hash = 89 * hash + Objects.hashCode(this.EpsUser);
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
                " " + apellido2 + " doc: " + documento + " FechaNacimiento: " + FechaNacimiento + " " +
                sexo + " programas Accedidos: " + programasAccedidos + " Eps: " + EpsUser +" Estado: "+estado;
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
