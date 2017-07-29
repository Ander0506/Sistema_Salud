
package sistema_salud.modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Restriccion {

    private final StringProperty id;
    private final DoubleProperty edadMin;
    private final DoubleProperty edadMax;
    private final StringProperty descripcion;
    private final StringProperty sexo;

    public Restriccion(String id, Double edadMin, Double edadMax, String sexo, String descripcion)throws Exception{
        if (id == null) {
            throw new Exception("El ID no puede ser nulo");
        }
        if (sexo == null) {
            throw new Exception("El sexo no puede ser nulo");
        }
        if (edadMin < 0) {
            throw new Exception("La edad minima debe ser posistiva");
        }
        if (edadMax < 0) {
            throw new Exception("La edad maxima debe ser posistiva");
        }
        this.id = new SimpleStringProperty(id);
        this.sexo = new SimpleStringProperty(sexo);
        this.edadMin = new SimpleDoubleProperty(edadMin);
        this.edadMax = new SimpleDoubleProperty(edadMax);
        this.descripcion = new SimpleStringProperty(descripcion);
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
    
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String value) {
        descripcion.set(value);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }
    public Double getEdadMax() {
        return edadMax.get();
    }

    public void setEdadMax(Double value) {
        edadMax.set(value);
    }

    public DoubleProperty edadMaxProperty() {
        return edadMax;
    }
    

    public Double getEdadMin() {
        return edadMin.get();
    }

    public void setEdadMin(Double value) {
        edadMin.set(value);
    }

    public DoubleProperty edadMinProperty() {
        return edadMin;
    }
    

    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public StringProperty idProperty() {
        return id;
    }
    
    
}
