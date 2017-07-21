/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_salud.vista;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class NuevoUsuarioController implements Initializable {

    private Sistema  sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @FXML
    private JFXTextField txtId;
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtApellido;
    @FXML
    private JFXTextField txtCorreo;
    @FXML
    private JFXTextField txtUser;
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private JFXComboBox<String> comboBoxSexo;
    @FXML
    private JFXComboBox<String> ComboBoxTipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ObservableList<String> items = FXCollections.observableArrayList("Administrador","Usuario");
        ComboBoxTipo.setItems(items);
        
        ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino");
        comboBoxSexo.setItems(itemSex);
    }    
    
     @FXML
    void agregarUsuario(ActionEvent event) throws Exception {
        
        Usuario nuevoUser = new Usuario(txtId.getText(), txtNombre.getText(),txtApellido.getText(), 
                txtCorreo.getText(),ComboBoxTipo.getValue(), comboBoxSexo.getValue(), txtUser.getText(), txtPassword.getText());
        sistema.adicionarUsuario(nuevoUser);
        
        //Cargar el sistema en 
        FXMLLoader cargar = new FXMLLoader();
        cargar.setLocation(Sistema_Salud.class.getResource("../vista/ContenidoUsuarios.fxml"));
        ContenidoUsuariosController ControlUserContent = cargar.getController();
        ControlUserContent.setSistema(sistema);
        
    }
    
}
