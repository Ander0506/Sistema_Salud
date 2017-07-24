/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class EditarUsuarioController implements Initializable {
    private Sistema  sistema = new Sistema();
    private Usuario user;

    public void setUsuario(Usuario usuario){
        this.user= usuario;
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
    @FXML    private JFXComboBox<String> ComboBoxTipo;
    @FXML    private JFXButton BtOk;
    @FXML    private JFXButton btcancelar;

    ObservableList<String> items = FXCollections.observableArrayList("Administrador","Usuario");
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxTipo.setItems(items);        
        comboBoxSexo.setItems(itemSex);

    }    
    
    
    @FXML
    private void ObtenerValores(){
        txtId.setText(user.getId());
        txtNombre.setText(user.getNombre());
        txtApellido.setText(user.getApellidos());
        txtCorreo.setText(user.getCorreo());
        txtUser.setText(user.getUser());
        txtPassword.setText(user.getPassword());
        comboBoxSexo.setValue(user.getSexo());
        ComboBoxTipo.setValue(user.getTipo());
        
    }

    @FXML
    private void editarUsuario() {
       
        try {
            user.setId(txtId.getText());
            user.setNombre(txtNombre.getText());
            user.setApellidos(txtApellido.getText());
            user.setCorreo(txtCorreo.getText());
            user.setUser(txtUser.getText());
            user.setPassword(txtPassword.getText());
            user.setTipo(ComboBoxTipo.getValue());
            user.setSexo(comboBoxSexo.getValue());
            
            Stage ventana = (Stage)btcancelar.getScene().getWindow();
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
