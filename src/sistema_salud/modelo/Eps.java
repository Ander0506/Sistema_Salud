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

/**
 *
 * @author andre
 */
public class Eps implements Serializable {

    private StringProperty name;
    private StringProperty code;

    public Eps(String name, String code) throws Exception {
        if (name == null) {
            throw new Exception("NAME No puede Ser nulo");
        }
         if (code == null) {
            throw new Exception("CODE No puede Ser nulo");
        }
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
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

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) throws Exception {
        if (code == null) {
            throw new Exception("CODE No puede Ser nulo");
        } else {
            this.code.set(code);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.code);
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
        final Eps other = (Eps) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "name: " + name + " code: " + code;
    }

}
