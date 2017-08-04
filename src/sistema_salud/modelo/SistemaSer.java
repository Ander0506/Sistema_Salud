
package sistema_salud.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class SistemaSer implements Serializable{
    
    private LinkedList<Programa> programas;
    private LinkedList<Eps> epss;
    private LinkedList<Paciente> pacientes;
    private LinkedList<Usuario> usuarios;

    public SistemaSer() {
        this.programas = new LinkedList<>();
        this.epss = new LinkedList<>();
        this.pacientes = new LinkedList<>();
        this.usuarios = new LinkedList<>();
    }

    public void setEpss(ObservableList<Eps> epss) {
        this.epss.clear();
        this.epss.addAll(epss);
    }
    public void setProgramas(ObservableList<Programa> programas) {
        this.programas.clear();
        this.programas.addAll(programas);
    }
    public void setPacientes(ObservableList<Paciente> pacientes) {
        this.pacientes.clear();
        this.pacientes.addAll(pacientes);
    }
    public void setUsuarios(ObservableList<Usuario> usuarios) {
        this.usuarios.clear();
        this.usuarios.addAll(usuarios);
    }

    public LinkedList<Programa> getProgramas() {
        return programas;
    }

    public LinkedList<Eps> getEpss() {
        return epss;
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void guardar(String archivo) {
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SistemaSer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SistemaSer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    public static SistemaSer cargar(String archivo) {
        try {
            FileInputStream fis = new FileInputStream(archivo);
            if (fis.available() == 0) {
                SistemaSer sistemaLeido = new SistemaSer();
                sistemaLeido.guardar(archivo);
            }
            ObjectInputStream ois = new ObjectInputStream(fis);
            SistemaSer sistemaLeido = (SistemaSer) ois.readObject();
            return sistemaLeido;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SistemaSer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SistemaSer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaSer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
}
