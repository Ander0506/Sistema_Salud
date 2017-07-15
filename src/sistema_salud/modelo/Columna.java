/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author andre
 */
public class Columna implements Serializable{
    
    private String codigo;
    private String nombre;
    private LinkedList<Item> items;

    public Columna(String codigo, String nombre) throws Exception {
        if (codigo == null) { throw new Exception("EL codigo No puede Ser nulo"); }
        if (nombre == null) { throw new Exception("EL nombre No puede Ser nulo"); }   
        this.codigo = codigo;
        this.nombre = nombre;
        items = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Exception {
    if (codigo == null) { throw new Exception("EL codigo No puede Ser nulo"); }
    else{
        this.codigo = codigo;
    }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) throws Exception {
      if (nombre == null) { throw new Exception("EL nombre No puede Ser nulo"); }   
      else{
        this.nombre = Nombre;}
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Columna other = (Columna) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + " Nombre: " + nombre + " Items: " + items;
    }
    
    //Metodos para gestionar lista de Items
    
     public void adicionarItem(Item itemAdicionar)throws Exception{
       if (itemAdicionar == null) {
            throw new Exception("El Item no puede ser nulo");
        }
        items.add(itemAdicionar);
    }
    
    public boolean buscarItem(Item itemABuscar)throws Exception{
        if (itemABuscar == null) {
            throw new Exception("El item no se encuentra");
        }
        return items.contains(itemABuscar);
    }
    
    public boolean eliminarArticulo(Item itemAEliminar) throws Exception{
        if (itemAEliminar == null) {
            throw new Exception("El item a eliminar no se encuentra");
        }
        return items.remove(itemAEliminar);
    }
    
       
}
