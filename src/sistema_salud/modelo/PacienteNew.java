
package sistema_salud.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PacienteNew implements Serializable {
    

    private Eps epsUser;
    private Boolean estado;
    private final StringProperty nombre1;
    private final StringProperty nombre2;
    private final StringProperty apellido1;
    private final StringProperty apellido2;
    private final StringProperty tipoDocumento;
    private final StringProperty documento;
    private final ObjectProperty<LocalDate> fechaNacimiento;
    private final StringProperty sexo;
    private final IntegerProperty id;

    public PacienteNew(String nombre1, String nombre2, String apellido1, String apellido2, String tipoDocumento, String documento, LocalDate fechaNacimiento, String sexo, Integer id, Eps epsUser)throws Exception{
        this.nombre1 = new SimpleStringProperty(nombre1);
        this.nombre2 = new SimpleStringProperty(nombre2);
        this.apellido1 = new SimpleStringProperty(apellido1);
        this.apellido2 = new SimpleStringProperty(apellido2);
        this.tipoDocumento = new SimpleStringProperty(tipoDocumento);
        this.documento = new SimpleStringProperty(tipoDocumento);
        this.fechaNacimiento = new SimpleObjectProperty<LocalDate>(fechaNacimiento);
        this.sexo = new SimpleStringProperty(sexo);
        this.id = new SimpleIntegerProperty(id);
        this.estado = true;
    }

    

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    
    public String getNombre1() {
        return nombre1.get();
    }

    public void setNombre1(String value) {
        nombre1.set(value);
    }

    public StringProperty nombre1Property() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2.get();
    }

    public void setNombre2(String value) {
        nombre2.set(value);
    }

    public StringProperty nombre2Property() {
        return nombre2;
    }

    public String getApellido1() {
        return apellido1.get();
    }

    public void setApellido1(String value) {
        apellido1.set(value);
    }

    public StringProperty apellido1Property() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2.get();
    }

    public void setApellido2(String value) {
        apellido2.set(value);
    }

    public StringProperty apellido2Property() {
        return apellido2;
    }

    public String getTipoDocumento() {
        return tipoDocumento.get();
    }

    public void setTipoDocumento(String value) {
        tipoDocumento.set(value);
    }

    public StringProperty tipoDocumentoProperty() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento.get();
    }

    public void setDocumento(String value) {
        documento.set(value);
    }

    public StringProperty documentoProperty() {
        return documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public void setFechaNacimiento(LocalDate value) {
        fechaNacimiento.set(value);
    }

    public ObjectProperty fechaNacimientoProperty() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo.get();
    }

    public void setSexo(String value) {
        sexo.set(value);
    }

    public StringProperty sexoProperty() {
        return sexo;
    }
    
    

    
}
