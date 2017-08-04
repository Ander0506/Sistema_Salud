
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;


public class Programa implements Serializable {

    private String id;
    private String nombre;
    private LinkedList<Item> items;
    private LinkedList<Restriccion> restricciones;

    public Programa(String codigo, String nombre) throws Exception {
        if (codigo == null) {
            throw new Exception("EL codigo No puede Ser nulo");
        }
        if (nombre == null) {
            throw new Exception("EL nombre No puede Ser nulo");
        }

        this.id = codigo;
        this.nombre = nombre;
        this.items = new LinkedList<>();
        this.restricciones = new LinkedList<>();

    }

    public LinkedList<Restriccion> getRestricciones() {
        return restricciones;
    }
    
    public LinkedList<Item> getItems() {
        return items;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id == null) {
            throw new Exception("EL codigo No puede Ser nulo");
        } else {
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) throws Exception {
        if (nombre == null) {
            throw new Exception("EL nombre No puede Ser nulo");
        } else {
            this.nombre = Nombre;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.items);
        hash = 13 * hash + Objects.hashCode(this.restricciones);
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
        return id + " " + nombre + "  " + items + " " + restricciones;
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
    
    //Metodos para gestionar lista de Restricciones
    
    public void adicionarRestricciones(Restriccion restriccionAdicionar) throws Exception {
        if (restriccionAdicionar == null) {
            throw new Exception("La restriccion no puede ser nula");
        }
        restricciones.add(restriccionAdicionar);
    }

    public boolean buscarRestriccion(Restriccion restriccionABuscar) throws Exception {
        if (restriccionABuscar == null) {
            throw new Exception("La restriccion no se encuentra");
        }
        return restricciones.contains(restriccionABuscar);
    }

    public boolean eliminarRestriccion(Restriccion restriccionAEliminar) throws Exception {
        if (restriccionAEliminar == null) {
            throw new Exception("La restriccion a eliminar no se encuentra");
        }
        return restricciones.remove(restriccionAEliminar);
    }

}
