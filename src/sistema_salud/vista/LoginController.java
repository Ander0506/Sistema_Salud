
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema_salud.modelo.Sistema;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Usuario;


public class LoginController {

    @FXML private JFXTextField userTxt;
    @FXML private JFXButton IniciarBt;
    @FXML private JFXPasswordField passwordTxt;
    private Sistema sistema;

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
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
            principalC.setNuevoSistema(sistema);
            contenedor.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML void IniciarSesion() {
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
                        //Valido el estado
                        if (!user.getEstado()) {
                           
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Error!");
                            alerta.setHeaderText("Usuario Invalido");
                            alerta.setContentText("El usuario se Encuentra Desactivado");
                            alerta.show();
                        }else{
                             Stage ventana = (Stage)IniciarBt.getScene().getWindow();
                             ventana.close();
                             inicioPrincipal(user);
                            }
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
    
    @FXML
    public void initialize() {

    }

}
