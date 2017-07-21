
package sistema_salud.vista;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistema_salud.modelo.Usuario;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Sistema;

public class DrawerContentController {

    @FXML private Label nombreUsuario;
    @FXML private JFXButton btSalir;
    
    private Usuario nuevoUsuario;
    private Sistema sistema = new Sistema();
    private AnchorPane resultado = new AnchorPane();
    private PrincipalController Principal;


    public void setPrincipal(PrincipalController Principal) {
        this.Principal = Principal;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    
    
    public AnchorPane getResultado() {
        return resultado;
    }
    
     public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
        nombreUsuario.setText(this.nuevoUsuario.getNombre()+" "+this.nuevoUsuario.getApellidos());
    }
    
    public void iniciarLogin(){
        try {
            Stage contenedor = new Stage();
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/Login.fxml"));
            AnchorPane login = (AnchorPane)cargar.load();
            Scene escena = new Scene(login);
            contenedor.setScene(escena);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(Sistema_Salud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void contenidoUsuario(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/ContenidoUsuarios.fxml"));
            resultado = (AnchorPane)cargar.load();
            ContenidoUsuariosController usuarioC = cargar.getController();
            usuarioC.setSistema(sistema);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML void usuarios(){
        contenidoUsuario();
        Principal.presBoton(getResultado());
    }
    

    @FXML void salir(){
        Stage ventana = (Stage)btSalir.getScene().getWindow();
        ventana.close();
        iniciarLogin();
    }
    
    @FXML public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}