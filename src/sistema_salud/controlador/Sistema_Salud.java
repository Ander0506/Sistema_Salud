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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class Sistema_Salud extends Application {
    
    private Stage contenedor;
    
    @Override
    public void start(Stage contenedor) {
       this.contenedor = contenedor;
       this.contenedor.setTitle("Login");
       iniciarLogin();
    }
    
    
    void iniciarLogin(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/Login.fxml"));
            AnchorPane login = (AnchorPane) cargar.load();
            Scene escena = new Scene(login);
            contenedor.setScene(escena);
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
