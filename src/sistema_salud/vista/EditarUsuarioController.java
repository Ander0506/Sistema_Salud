
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;


public class EditarUsuarioController {
    private Sistema  sistema;
    private Usuario user;

    public void setUsuario(Usuario usuario){
        this.user= usuario;
        txtId.setText(this.user.getId());
        txtNombre.setText(this.user.getNombre());
        txtApellido.setText(this.user.getApellidos());
        txtCorreo.setText(this.user.getCorreo());
        txtPassword.setText(this.user.getPassword());
        txtUser.setText(this.user.getUser());
        comboBoxSexo.setValue(user.getSexo());
        comboBoxTipo.setValue(user.getTipo());
    }
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
    @FXML    private JFXComboBox<String> comboBoxTipo;
    @FXML    private JFXButton btOk;
    @FXML    private JFXButton btcancelar;

    ObservableList<String> items = FXCollections.observableArrayList("Administrador","Usuario");
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino");
  
    @FXML
    public void initialize() {
        comboBoxTipo.setItems(items);        
        comboBoxSexo.setItems(itemSex);
    }    
    
    @FXML private void editarUsuario() {
       
        try {
            user.setId(txtId.getText());
            user.setNombre(txtNombre.getText());
            user.setApellidos(txtApellido.getText());
            user.setCorreo(txtCorreo.getText());
            user.setUser(txtUser.getText());
            user.setPassword(txtPassword.getText());
            user.setTipo(comboBoxTipo.getValue());
            user.setSexo(comboBoxSexo.getValue());
            Stage ventana = (Stage)btOk.getScene().getWindow();
            ventana.close();
        } catch (Exception ex) {
            Logger.getLogger(EditarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cancelarUsuario() {
       Stage ventana = (Stage)btcancelar.getScene().getWindow();
       ventana.close();
    }
    
}
