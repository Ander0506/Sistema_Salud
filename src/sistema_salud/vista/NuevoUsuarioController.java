
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;


public class NuevoUsuarioController {

    private Sistema  sistema;

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @FXML    private JFXTextField txtId;
    @FXML    private JFXTextField txtNombre;
    @FXML    private JFXTextField txtApellido;
    @FXML    private JFXTextField txtCorreo;
    @FXML    private JFXTextField txtUser;
    @FXML    private JFXTextField txtPassword;
    @FXML    private JFXComboBox<String> comboBoxSexo;
    @FXML    private JFXComboBox<String> ComboBoxTipo;
    @FXML    private JFXButton BtOk;
    @FXML    private JFXButton btcancelar;
    
    ObservableList<String> items = FXCollections.observableArrayList("Administrador","Usuario");
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino");

   
    @FXML
    public void initialize() {
       
        ComboBoxTipo.setItems(items);        
        comboBoxSexo.setItems(itemSex);
    }    
    
     @FXML
    void agregarUsuario() {
         if (sistema.isNumeric(txtId.getText())) {
             try {
                 Usuario nuevoUser = new Usuario(txtId.getText(), txtNombre.getText(),txtApellido.getText(),
                         txtCorreo.getText(),ComboBoxTipo.getValue(), comboBoxSexo.getValue(), txtUser.getText(), txtPassword.getText());
                 sistema.adicionarUsuario(nuevoUser);
                 
                 Stage ventana = (Stage)BtOk.getScene().getWindow();
                 ventana.close();
             } catch (Exception ex) {
                 Logger.getLogger(NuevoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
              Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("El campo de ID debe ser numerico");
            alerta.show();
         }
        
    }
    
    @FXML
    void cancelarUsuario() {
      Stage ventana = (Stage)btcancelar.getScene().getWindow();
       ventana.close();
    }
    
    
}
