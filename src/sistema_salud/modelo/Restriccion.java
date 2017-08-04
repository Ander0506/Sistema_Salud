
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Objects;


public class Restriccion implements Serializable {

    private String id;
    private Double edadMin;
    private Double edadMax;
    private String descripcion;
    private String sexo;

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
        this.id = id;
        this.sexo = sexo;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.descripcion = descripcion;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String value) {
        this.sexo = value;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    public Double getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(Double value) {
        this.edadMax = value;
    }

    public Double getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(Double value) {
        this.edadMin = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        hash = 73 * hash + Objects.hashCode(this.edadMin);
        hash = 73 * hash + Objects.hashCode(this.edadMax);
        hash = 73 * hash + Objects.hashCode(this.descripcion);
        hash = 73 * hash + Objects.hashCode(this.sexo);
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
        final Restriccion other = (Restriccion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " " + descripcion;
    }
    
    

}
