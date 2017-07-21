/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;
import sistema_salud.vista.LoginController;

/**
 *
 * @author LENOVO
 */
public class Sistema_Salud extends Application {
    
    private Stage contenedor;
    private Sistema sistema = new Sistema();

    
    @Override
    public void start(Stage contenedor) {
       this.contenedor = contenedor;
       this.contenedor.setTitle("Login");
       crearUsuario();
       iniciarLogin();
    }
    
    void crearUsuario() {
        try {
            Usuario user = new Usuario("1045674309", "Anderson", "Jimenez", "andersonjesusujv@hotmail.com", "Administrador", "M", "Anderson", "123");
            Usuario user2 = new Usuario("1067890354", "Andres", "Padilla", "andrestrilli@hotmail.com", "Administrador", "M", "Andres", "12345");
            this.sistema.adicionarUsuario(user);
            this.sistema.adicionarUsuario(user2);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    void iniciarLogin(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/Login.fxml"));
           // cargar.setLocation(Sistema_Salud.class.getResource("../vista/.fxml"));
            AnchorPane login = (AnchorPane) cargar.load();
            Scene escena = new Scene(login);
            contenedor.setScene(escena);
            LoginController loginC = cargar.getController();
            loginC.setSistema(sistema);
            contenedor.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Sistema_Salud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
