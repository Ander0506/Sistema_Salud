/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.modelo;

import java.io.Serializable;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author andre
 */
public class Sistema implements Serializable{
    
    private ObservableList<Programa> programas;
    private ObservableList<Eps> epss;
    private ObservableList<Paciente> pacientes;
    private ObservableList<Usuario> usuarios;
   
    public Sistema() {
        programas = FXCollections.observableArrayList();
        epss = FXCollections.observableArrayList();
        pacientes = FXCollections.observableArrayList(); 
        usuarios = FXCollections.observableArrayList();
    }

    public ObservableList<Programa> getProgramas() {
        return programas;
    }
    public ObservableList<Eps> getEpss() {
        return epss;
    }
    public ObservableList<Paciente> getPacientes() {
        return pacientes;
    }
    public ObservableList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void adicionarPrograma(Programa progAdicionar)throws Exception{
       if (progAdicionar == null) {
            throw new Exception("El programa no puede ser nulo");
        }
        programas.add(progAdicionar);
    }
    public boolean buscarPrograma(Programa progABuscar)throws Exception{
        if (progABuscar == null) {
            throw new Exception("El programa no se encuentra");
        }
        return programas.contains(progABuscar);
    }
    public boolean eliminarPrograma(Programa progAEliminar) throws Exception{
        if (progAEliminar == null) {
            throw new Exception("El programa a eliminar no se encuentra");
        }
        return programas.remove(progAEliminar);
    }
    public Programa RetornarProgramaPorCodigo(String Id){
         Iterator<Programa> it = programas.iterator(); 
         boolean encontrado = false;
         Programa actual = programas.get(0);
      while(it.hasNext()&& encontrado == false){
           actual = it.next();
          if (actual.getId().equals(Id)) {
              encontrado = true;
          }
         }
      return actual;
    }
    
    public void adicionarEps(Eps epsAdicionar)throws Exception{
       if (epsAdicionar == null) {
            throw new Exception("La eps no puede ser nulo");
        }
        epss.add(epsAdicionar);
    }
    public boolean buscarEps(Eps epsABuscar)throws Exception{
        if (epsABuscar == null) {
            throw new Exception("La eps no se encuentra");
        }
        return epss.contains(epsABuscar);
    }
    public boolean eliminarEps(Eps epsAEliminar) throws Exception{
        if (epsAEliminar == null) {
            throw new Exception("La columna a eliminar no se encuentra");
        }
        return epss.remove(epsAEliminar);
    }
    public Eps RetornarEpsPorNombre(String nombreAbuscar) {
        Iterator<Eps> it = epss.iterator();
        boolean encontrado = false;
        Eps actual = epss.get(0);
        while (it.hasNext() && encontrado == false) {
            actual = it.next();
            if (actual.getNombre().equals(nombreAbuscar)) {
                encontrado = true;
            }
        }
        return actual;
    }
 
    public void adicionarPaciente(Paciente UsuarioAdicionar)throws Exception{
       if (UsuarioAdicionar == null) {
            throw new Exception("El usuario no puede ser nulo");
        }
        pacientes.add(UsuarioAdicionar);
    }
    public boolean buscarPaciente(Paciente UsuarioABuscar)throws Exception{
        if (UsuarioABuscar == null) {
            throw new Exception("El usuario no se encuentra");
        }
        return pacientes.contains(UsuarioABuscar);
    }
    public boolean eliminarPaciente(Paciente usuarioAEliminar) throws Exception{
        if (usuarioAEliminar == null) {
            throw new Exception("El usuario a eliminar no se encuentra");
        }
        return pacientes.remove(usuarioAEliminar);
    }
    public Paciente RetornarPacientePorCC(String doc){
         Iterator<Paciente> it = pacientes.iterator(); 
         boolean encontrado = false;
         Paciente actual = pacientes.get(0);
      while(it.hasNext()&& encontrado == false){
           actual = it.next();
          if (actual.getDocumento().equals(doc)) {
              encontrado = true;
          }
         }
      return actual;
    }
    
    public void adicionarUsuario(Usuario UsuarioAdicionar)throws Exception{
       if (UsuarioAdicionar == null) {
            throw new Exception("La columna no puede ser nulo");
        }
       if (usuarios.contains(UsuarioAdicionar)) {
            throw new Exception("Usuario ya existente");
        }
        usuarios.add(UsuarioAdicionar);
    }    
    public Usuario RetornarUsuarioPorUser(String user){
         Iterator<Usuario> it = usuarios.iterator(); 
         boolean encontrado = false;
         Usuario actual = usuarios.get(0);
         while(it.hasNext()&& encontrado == false){
               actual = it.next();
          if (actual.getUser().equals(user)) {
              encontrado = true;
          }
         }
      return actual;
    }
    
    public ObservableList<Usuario> retornarListaDeUsuario(String user){
        ObservableList resultado = FXCollections.observableArrayList();
         Iterator<Usuario> it = usuarios.iterator(); 
         Usuario actual = usuarios.get(0); 
         user = user.toLowerCase();
         while(it.hasNext()){
               actual = it.next();
         
               //Busco por nombre
               if(actual.getNombre().toLowerCase().indexOf(user) >= 0 && !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
               //Busco por apellido y pregunto si esta en la lista ya
               if(actual.getApellidos().toLowerCase().indexOf(user) >= 0 && !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               //Busco por id y pregunto si esta en la lista ya
               if(actual.getId().toLowerCase().indexOf(user) >= 0 &&  !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
         }
      return resultado;
    }
    public ObservableList<Programa> retornarListaDeProgramas(String programa){
        ObservableList resultado = FXCollections.observableArrayList();
         Iterator<Programa> it = programas.iterator(); 
         Programa actual = programas.get(0); 
         programa = programa.toLowerCase();
         while(it.hasNext()){
               actual = it.next();
         
               //Busco por nombre
               if(actual.getNombre().toLowerCase().indexOf(programa) >= 0 && !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
               //Busco por id y pregunto si esta en la lista ya
               if(actual.getId().indexOf(programa) >= 0 &&  !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
         }
      return resultado;
    }
    public ObservableList<Eps> retornarListaDeEPS(String eps){
        ObservableList resultado = FXCollections.observableArrayList();
         Iterator<Eps> it = epss.iterator(); 
         Eps actual = epss.get(0); 
         eps = eps.toLowerCase();
         while(it.hasNext()){
               actual = it.next();
         
               //Busco por nombre
               if(actual.getNombre().toLowerCase().indexOf(eps) >= 0 && !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
               //Busco por id y pregunto si esta en la lista ya
               if(actual.getCodigo().indexOf(eps) >= 0 &&  !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
         }
      return resultado;
    }
    public ObservableList<Paciente> retornarListaDePacientes(String paciente){
        ObservableList resultado = FXCollections.observableArrayList();
         Iterator<Paciente> it = pacientes.iterator(); 
         Paciente actual = pacientes.get(0); 
         paciente = paciente.toLowerCase();
         while(it.hasNext()){
               actual = it.next();
         
               //Busco por nombre
               if(actual.getNombre1().toLowerCase().indexOf(paciente) >= 0 && !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
               //Busco por apellido y pregunto si esta en la lista ya
               if(actual.getApellido1().toLowerCase().indexOf(paciente) >= 0 && !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               //Busco por id y pregunto si esta en la lista ya
               if(actual.getDocumento().toLowerCase().indexOf(paciente) >= 0 &&  !(resultado.contains(actual))){
                   resultado.add(actual);
               }
               
         }
      return resultado;
    }

    //metodo que uso para obtener los nombre y codigos de cada una de las Eps
    // para posteirormente llenar el combo box
//    public ObservableList<String> retornarNombresYCodigoEps(){
//        ObservableList<String> resultado = FXCollections.observableArrayList();
//         Iterator<Eps> it = epss.iterator(); 
//         Eps actual = epss.get(0); 
//         while(it.hasNext()){
//               actual = it.next();
//               resultado.add(actual.getNombre());
//         }
//      return resultado;
//    }
    
    public boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
}
