
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;


public class ContenidoUsuariosController {
    
    @FXML private TextField txtBuscar;
    @FXML private TableColumn<Usuario, String> colId;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colApellido;
    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private Label labelUser;
    @FXML private Label labelCorreo;
    @FXML private Label labelTipoDeUsuario;
    @FXML private Label labelSexo;
    @FXML private Label labelEstado;
    @FXML private Label labelContraseña;
    @FXML private Label labelId;
    @FXML private Label labelNombre;
    @FXML private Label labelApellido;
    @FXML private JFXButton btEditarUsuario;
    @FXML private JFXButton btActivarUsuario;
    @FXML private JFXButton btDesactivarUsuario;

    private Sistema sistema;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaUsuarios.setItems(sistema.getUsuarios());
    }
    
    private void detalleUsuario(Usuario usuarioSelect){
        if (usuarioSelect != null) {
            if (usuarioSelect.getEstado()) {
                btDesactivarUsuario.setDisable(false);
                btActivarUsuario.setDisable(true);
            }else{
                btDesactivarUsuario.setDisable(true);
                btActivarUsuario.setDisable(false);
            }
            btEditarUsuario.setDisable(false);
            labelId.setText(usuarioSelect.getId());
            labelNombre.setText(usuarioSelect.getNombre());
            labelApellido.setText(usuarioSelect.getApellidos());
            labelUser.setText(usuarioSelect.getUser());
            labelCorreo.setText(usuarioSelect.getCorreo());
            labelContraseña.setText(usuarioSelect.getPassword());
            labelSexo.setText(usuarioSelect.getSexo());
            labelTipoDeUsuario.setText(usuarioSelect.getTipo());
            if (usuarioSelect.getEstado()) {
                labelEstado.setText("Activo");
            }else{
                labelEstado.setText("Inactivo");
            }
        }else{
            labelId.setText("");
            labelNombre.setText("");
            labelApellido.setText("");
            labelUser.setText("");
            labelCorreo.setText("");
            labelContraseña.setText("");
            labelSexo.setText("");
            labelTipoDeUsuario.setText("");
            labelEstado.setText("");
        }
    }
    
    @FXML void buscarUsuario(){
        if (txtBuscar.getText().isEmpty()) {
            tablaUsuarios.setItems(sistema.getUsuarios());
        }else{
            tablaUsuarios.setItems(sistema.retornarListaDeUsuario(txtBuscar.getText()));
        }
    }
    
    @FXML void nuevoUsuario(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/NuevoUsuario.fxml"));
            AnchorPane login = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(login);
            contenedor.setScene(escena);
            NuevoUsuarioController NewUser = cargar.getController();
            NewUser.setSistema(sistema);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void obtenerUsuario(Usuario user) {
        usuario = user;
    }
   
    @FXML void editarUsuario() {
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/EditarUsuario.fxml"));
            AnchorPane editarUsuario = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(editarUsuario);
            contenedor.setScene(escena);
            EditarUsuarioController  editarUsuarioC = cargar.getController();
            editarUsuarioC.setSistema(sistema);
            editarUsuarioC.setUsuario(getUsuario());
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML void desactivarUsuario(){
        Usuario user = tablaUsuarios.getSelectionModel().selectedItemProperty().get();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Nombre: "+user.getNombre()+"\n Apellido: "+user.getApellidos());
        alert.setContentText("Desea Desactivar este usuario?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           user.desactivar();
        } else {
            // ... user chose CANCEL or closed the dialog
        }    
    }
    
    @FXML void activarUsuario(){
        Usuario user = tablaUsuarios.getSelectionModel().selectedItemProperty().get();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Nombre: "+user.getNombre()+"\n Apellido: "+user.getApellidos());
        alert.setContentText("Desea activar este usuario?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           user.activar();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
    } 
            
    @FXML public void initialize() {
        btActivarUsuario.setDisable(true);
        btDesactivarUsuario.setDisable(true);
        btEditarUsuario.setDisable(true);
        colNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellidos"));
        colId.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id"));
        detalleUsuario(null);
        obtenerUsuario(null);
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> detalleUsuario(newValue));
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> obtenerUsuario(newValue));

    }    
    
}
