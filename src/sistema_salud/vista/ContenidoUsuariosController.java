
package sistema_salud.vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaUsuarios.setItems(sistema.getUsuarios());
    }
    
    private void detalleUsuario(Usuario usuarioSelect){
        if (usuarioSelect != null) {
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
    
    @FXML
    public void initialize() {
//        txtBuscar.addEventHandler(KeyEvent.KEY_PRESSED,(e) -> {
//           tablaUsuarios.setItems(sistema.retornarListaDeUsuario(txtBuscar.getText()));
//        });
        colNombre.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Usuario, String>("apellidos"));
        colId.setCellValueFactory(new PropertyValueFactory<Usuario, String>("id"));
        detalleUsuario(null);
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> detalleUsuario(newValue));
    }    
    
}
