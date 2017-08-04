
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Eps;
import sistema_salud.modelo.Sistema;

public class EditarEPSController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNombre;
    @FXML private JFXButton btOk;
    @FXML private JFXButton btCancelar;

    private Sistema sistema;
    private Eps eps;
    
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
        txtId.setText(this.eps.getCodigo());
        txtNombre.setText(this.eps.getNombre());        
    }
    
    @FXML
    public void initialize() {
    }    

    @FXML
    private void editarEps() {
        if (sistema.isNumeric(txtId.getText())) {
            try {
                eps.setCodigo(txtId.getText());
                eps.setNombre(txtNombre.getText());     
                
                Stage ventana = (Stage)btOk.getScene().getWindow();
                 ventana.close();
                
            } catch (Exception ex) {
                Logger.getLogger(EditarEPSController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("El campo de Codigo debe ser numerico");
            alerta.show();
        }
    }

    @FXML
    private void cancelar() {
         Stage ventana = (Stage) btCancelar.getScene().getWindow();
                ventana.close();
    }
    
}
