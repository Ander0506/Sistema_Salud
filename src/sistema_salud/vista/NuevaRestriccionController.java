
package sistema_salud.vista;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import sistema_salud.modelo.Sistema;


public class NuevaRestriccionController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtEdadMaxima;
    @FXML private JFXTextField txtEdadMinima;
    @FXML private JFXTextArea txtAreaDescripcion;
    @FXML private JFXComboBox<String> comboBoxSexo;
    
    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino","Ambos");

    
    @FXML
    public void initialize() {
       comboBoxSexo.setItems(itemSex);
    }    
    
}
