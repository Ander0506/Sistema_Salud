/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema_salud.modelo.Sistema;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField userTxt;
    @FXML
    private JFXButton IniciarBt;
    @FXML
    private JFXPasswordField passwordTxt;
    private Sistema sistema = new Sistema();

 

    void crearUsuario() {
        try {
            Usuario user = new Usuario("Andres", "12345");
            user.setid("12345");
            user.setnombre("Andres");
            user.setapellidos("Padilla");
            sistema.adicionarUsuario(user);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    void inicioPrincipal(Usuario nuevoUsuario){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/Principal.fxml"));
            AnchorPane principal = (AnchorPane)cargar.load();
            Stage contenedor = new Stage();
            contenedor.setTitle("Sistema de Salud");
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(principal);
            contenedor.setScene(escena);
            PrincipalController principalC = cargar.getController();
            principalC.setNuevoUsuario(nuevoUsuario);
            contenedor.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void IniciarSesion(ActionEvent event) {
        if (userTxt.getText().isEmpty() || passwordTxt.getText().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("Uno de los campos esta vacio");
            alerta.show();

        } else {
            if (sistema.getUsuarios().isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error!");
                alerta.setHeaderText("Usuario No Encontrado");
                alerta.setContentText("Lista de usuarios vacia");
                alerta.show();
            } else {
                try {
                    Usuario user = sistema.RetornarUsuarioPorUser(userTxt.getText());
                    if (user != null && user.getPassword().equals(passwordTxt.getText())) {
                             Stage ventana = (Stage)IniciarBt.getScene().getWindow();
                            ventana.close();
                             inicioPrincipal(user);

                    } else {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Error!");
                        alerta.setHeaderText("Usuario no encontrado");
                        alerta.setContentText("Usuario o Contraseña incorrectas");
                        alerta.show();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearUsuario();
    }

}
