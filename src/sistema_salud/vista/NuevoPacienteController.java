
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Eps;
import sistema_salud.modelo.Paciente;
import sistema_salud.modelo.Sistema;


public class NuevoPacienteController {
    
    
    private Sistema sistema = new Sistema();
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        this.comboBoxEps.setItems(sistema.getEpss());
        
    }
    
    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNombre1;
    @FXML private JFXTextField txtNombre2;
    @FXML private JFXTextField txtApellido1;
    @FXML private JFXTextField txtApellido2;
    @FXML private JFXComboBox<String> ComboBoxTipoDeDocumento;
    @FXML private JFXTextField txtDocumento;
    @FXML private JFXComboBox<String> comboBoxSexo;
    @FXML private JFXComboBox<Eps> comboBoxEps;
    @FXML private JFXDatePicker txtFechaNacimiento;
    @FXML private JFXButton btOk;
    @FXML private JFXButton btCancelar;
    
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino");
    ObservableList<String> itemDoc = FXCollections.observableArrayList("Targeta Identidad.","Cedula de Ciudadania.","Cedula Extranjero");
    
    @FXML public void agregarPaciente(){
        if (sistema.isNumeric(txtId.getText())) {
                try {
                    Paciente paci = new Paciente(Integer.parseInt(txtId.getText()), txtNombre1.getText(), txtNombre2.getText(), txtApellido1.getText(),
                            txtApellido2.getText(), ComboBoxTipoDeDocumento.getValue(), txtDocumento.getText(),txtFechaNacimiento.getValue(),comboBoxSexo.getValue()
                            ,comboBoxEps.getValue());
                    sistema.adicionarPaciente(paci);
                Stage ventana = (Stage)btOk.getScene().getWindow();
                 ventana.close();
                 
                } catch (Exception ex) {
                    Logger.getLogger(NuevoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }else{
             Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("El campo de Id debe ser numerico");
            alerta.show();
        }
        
    }
    
    @FXML public void cancelar(){
        Stage ventana = (Stage)btCancelar.getScene().getWindow();
       ventana.close();
    }
    
    @FXML
    public void initialize() {
        
        comboBoxSexo.setItems(itemSex);
        ComboBoxTipoDeDocumento.setItems(itemDoc);
        
    }    
    
}
