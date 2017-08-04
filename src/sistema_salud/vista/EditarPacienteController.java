
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Eps;
import sistema_salud.modelo.Paciente;
import sistema_salud.modelo.Sistema;


public class EditarPacienteController {

    @FXML    private JFXTextField txtId;
    @FXML    private JFXTextField txtNombre1;
    @FXML    private JFXTextField txtNombre2;
    @FXML    private JFXTextField txtApellido1;
    @FXML    private JFXTextField txtApellido2;
    @FXML    private JFXComboBox<String> ComboBoxTipoDeDocumento;
    @FXML    private JFXTextField txtDocumento;
    @FXML    private JFXComboBox<String> comboBoxSexo;
    @FXML    private JFXButton btOk;
    @FXML    private JFXButton btCancelar;
    @FXML    private JFXComboBox<Eps> comboBoxEps;
    @FXML    private JFXDatePicker txtFechaNacimiento;
    
    
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino");
    ObservableList<String> itemDoc = FXCollections.observableArrayList("Targeta Identidad","Cedula de Ciudadania","Cedula Extranjero");
    
    private Sistema  sistema;
    private Paciente paciente;
            
     public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        this.comboBoxEps.setItems(sistema.getEpss());
     }
     public void setPaciente(Paciente pac){
         this.paciente = pac;
         txtId.setText(pac.getId()+"");
         txtNombre1.setText(pac.getNombre1());
         txtNombre2.setText(pac.getNombre2());
         txtApellido1.setText(pac.getApellido1());
         txtApellido2.setText(pac.getApellido2());
         ComboBoxTipoDeDocumento.setValue(pac.getTipoDocumento());
         txtDocumento.setText(pac.getDocumento());
         comboBoxSexo.setValue(pac.getSexo());
         txtFechaNacimiento.setValue(pac.getFechaNacimiento());
         comboBoxEps.setValue(pac.getEpsUser());
     }
   
    @FXML
    public void initialize() {
        comboBoxSexo.setItems(itemSex);
        ComboBoxTipoDeDocumento.setItems(itemDoc);
    }    

    @FXML
    void editarPaciente() {
         if (sistema.isNumeric(txtId.getText())) {
             try {
                 paciente.setId(Integer.parseInt(txtId.getText()));
                 paciente.setNombre1(txtNombre1.getText());
                 paciente.setNombre2(txtNombre2.getText());
                 paciente.setTipoDocumento(ComboBoxTipoDeDocumento.getValue());
                 paciente.setApellido1(txtApellido1.getText());
                 paciente.setApellido2(txtApellido2.getText());
                 paciente.setDocumento(txtDocumento.getText());
                 paciente.setSexo(comboBoxSexo.getValue());
                 paciente.setFechaNacimiento(txtFechaNacimiento.getValue());
                 paciente.setEpsUSer(comboBoxEps.getValue());
                 
                 Stage ventana = (Stage)btOk.getScene().getWindow();
                 ventana.close();
             } catch (Exception ex) {
                 Logger.getLogger(EditarPacienteController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }else{
             Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("El campo de Id debe ser numerico");
            alerta.show();
        }
    }

    @FXML
    private void cancelar() {
        Stage ventana = (Stage)btCancelar.getScene().getWindow();
       ventana.close();
    }
    
}
