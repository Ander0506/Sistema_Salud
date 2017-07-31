
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Eps;
import sistema_salud.modelo.Item;
import sistema_salud.modelo.Sistema;


public class NuevaEPSController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNombre;
    @FXML private JFXButton btOk;
    @FXML private JFXButton btCancelar;
    
    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @FXML void agregarEps(){
        if (sistema.isNumeric(txtId.getText())) {
            try {
                Eps eps = new Eps(txtNombre.getText(),txtId.getText());   
                sistema.adicionarEps(eps);
                Stage ventana = (Stage)btOk.getScene().getWindow();
                 ventana.close();
                 
            } catch (Exception ex) {
                Logger.getLogger(NuevoItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("El campo de Codigo debe ser numerico");
            alerta.show();
        }
    }
    
    @FXML void cancelar(){
         Stage ventana = (Stage) btCancelar.getScene().getWindow();
                ventana.close();
    }
    
    @FXML
    public void initialize() {
       
    }    
    
}
