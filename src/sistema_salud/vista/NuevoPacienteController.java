
package sistema_salud.vista;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sistema_salud.modelo.Sistema;


public class NuevoPacienteController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNombre1;
    @FXML private JFXTextField txtNombre2;
    @FXML private JFXTextField txtApellido1;
    @FXML private JFXTextField txtApellido2;
    @FXML private JFXComboBox<?> ComboBoxTipoDeDocumento;
    @FXML private JFXTextField txtDocumento;
    @FXML private JFXComboBox<?> comboBoxSexo;
    @FXML private JFXComboBox<?> comboBoxEps;
    @FXML private JFXDatePicker txtFechaNacimiento;
    
    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @FXML
    public void initialize() {
    }    
    
}
