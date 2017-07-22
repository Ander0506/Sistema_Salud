/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.modelo;

import java.io.Serializable;
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

    private final StringProperty id;
    private final StringProperty nombre;
    private ObservableList<Item> items;

    public Programa(String codigo, String nombre) throws Exception {
        if (codigo == null) {
            throw new Exception("EL codigo No puede Ser nulo");
        }
        if (nombre == null) {
            throw new Exception("EL nombre No puede Ser nulo");
        }

        this.id = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.items = FXCollections.observableArrayList();

    }

    public ObservableList<Item> getItems() {
        return items;
    }
    
    public String getId() {
        return id.get();
    }

    public void setId(String id) throws Exception {
        if (id == null) {
            throw new Exception("EL codigo No puede Ser nulo");
        } else {
            this.id.set(id);
        }
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String Nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("EL nombre No puede Ser nulo");
        } else {
            this.nombre.set(Nombre);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.items);
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
        return "codigo: " + id + " Nombre: " + nombre + " Items: " + items;
    }

    //Metodos para gestionar lista de Items
    public void adicionarItem(Item itemAdicionar) throws Exception {
        if (itemAdicionar == null) {
            throw new Exception("El Item no puede ser nulo");
        }
        items.add(itemAdicionar);
    }

    public boolean buscarItem(Item itemABuscar) throws Exception {
        if (itemABuscar == null) {
            throw new Exception("El item no se encuentra");
        }
        return items.contains(itemABuscar);
    }

    public boolean eliminarItem(Item itemAEliminar) throws Exception {
        if (itemAEliminar == null) {
            throw new Exception("El item a eliminar no se encuentra");
        }
        return items.remove(itemAEliminar);
    }

}
