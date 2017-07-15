/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import sistema_salud.modelo.Sistema;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void crearUsuario() {
        try {
            Usuario user = new Usuario("Andres", "12345");
            sistema.adicionarUsuario(user);
        } catch (Exception ex) {
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
                    if (user != null && user.getPassword() == passwordTxt.getText()) {

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

}
