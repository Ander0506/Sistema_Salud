
package sistema_salud.vista;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    @FXML private JFXButton btUsuarios;
    @FXML private JFXButton btProgramas;
    @FXML private JFXButton btEPS;
    
    private Usuario nuevoUsuario;
    private Sistema sistema;
    private AnchorPane resultado = new AnchorPane();
    private PrincipalController Principal;
     private final String ruta = "src/Datos/Sistema.txt";


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
        if (nuevoUsuario.getTipo().equalsIgnoreCase("Usuario")) {
           btUsuarios.setDisable(true);
           btProgramas.setDisable(true);
           btEPS.setDisable(true);
        }
    }
    
    public void iniciarLogin(){
        try {
            Stage contenedor = new Stage();
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/Login.fxml"));
            AnchorPane login = (AnchorPane)cargar.load();
            LoginController loginC = cargar.getController();
            loginC.setSistema(sistema);
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
            Logger.getLogger(ContenidoUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void contenidoColumnas(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/ContenidoColumnas.fxml"));
            resultado = (AnchorPane)cargar.load();
            ContenidoColumnasController columnaC = cargar.getController();
            columnaC.setSistema(sistema);
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void contenidoEPS(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/ContenidoEPS.fxml"));
            resultado = (AnchorPane)cargar.load();
            ContenidoEPSController newEpsC = cargar.getController();
            newEpsC.setSistema(sistema);
        } catch (IOException ex) {
            Logger.getLogger(ContenidoEPSController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void contenidoPacientes(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/ContenidoPacientes.fxml"));
            resultado = (AnchorPane)cargar.load();
            ContenidoPacientesController newPacienteC = cargar.getController();
            newPacienteC.setSistema(sistema);
        } catch (IOException ex) {
            Logger.getLogger(ContenidoPacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML void columnas(){
        contenidoColumnas();
        Principal.presBoton(getResultado());
    }
    
    @FXML void usuarios(){
        contenidoUsuario();
        Principal.presBoton(getResultado());
    }
    
    
    @FXML void Eps(){
        contenidoEPS();
        Principal.presBoton(getResultado());
    }
    
    @FXML void Pacientes(){
        contenidoPacientes();
        Principal.presBoton(getResultado());
    }
    

    @FXML void salir(){
        Stage ventana = (Stage)btSalir.getScene().getWindow();
        ventana.close();
        sistema.guardar(ruta);
        iniciarLogin();
    }
    
    @FXML public void initialize() {
        
    }    
}