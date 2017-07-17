/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author andre
 */
public class Programa implements Serializable {
    
    private StringProperty id;
    private StringProperty name;
    private ObservableList<Columna> columnaProg;

    public Programa(String id, String name) throws Exception {
        if (id == null) { throw new Exception("EL id No puede Ser nulo"); }
        if (name == null) { throw new Exception("EL nombre No puede Ser nulo"); }
        
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        
        columnaProg= FXCollections.observableArrayList();
    }

    public String getId() {
        return id.get();
    }

    public void setId(String id) throws Exception {
        if (id == null) {
            throw new Exception("ID No puede Ser nulo");
        } else {
            this.id.set(id);
        }
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("NAME No puede Ser nulo");
        } else {
            this.name.set(name);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.columnaProg);
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
        final Programa other = (Programa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " columnaProg: " + columnaProg;
    }

    //Metodos para gestionar Columnas del Programa
    
    public void adicionarcolumna(Columna columnaAdicionar)throws Exception{
       if (columnaAdicionar == null) {
            throw new Exception("La columna no puede ser nulo");
        }
        columnaProg.add(columnaAdicionar);
    }
    
    public boolean buscarColumna(Columna columnaABuscar)throws Exception{
        if (columnaABuscar == null) {
            throw new Exception("La columna no se encuentra");
        }
        return columnaProg.contains(columnaABuscar);
    }
    
    public boolean eliminarColumna(Columna columnaAEliminar) throws Exception{
        if (columnaAEliminar == null) {
            throw new Exception("La columna a eliminar no se encuentra");
        }
        return columnaProg.remove(columnaAEliminar);
    }
    
    
    
    
    
   
    
    
}
