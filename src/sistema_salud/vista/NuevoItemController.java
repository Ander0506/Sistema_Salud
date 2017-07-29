
package sistema_salud.vista;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sistema_salud.modelo.Sistema;


public class NuevoItemController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNombre;
    
    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @FXML
    public void initialize() {
    }    
    
}
