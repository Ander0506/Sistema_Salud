
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Sistema;


public class NuevoProgramaController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtNombre;
    @FXML private JFXButton btok;
    @FXML private JFXButton btCancelar;

    
    private Sistema sistema;

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    
    @FXML
    void agregarPrograma (){
        String  id = txtId.getText();
        String nombre = txtNombre.getText();
        if (sistema.isNumeric(id)) {
            try {
                Programa prog = new Programa(id, nombre);
                sistema.adicionarPrograma(prog);
                Stage ventana = (Stage)btok.getScene().getWindow();
                ventana.close();
            } catch (Exception ex) {
                Logger.getLogger(NuevoProgramaController.class.getName()).log(Level.SEVERE, null, ex);
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
    void cancelar(){
        Stage ventana = (Stage) btCancelar.getScene().getWindow();
                ventana.close();
    }
    
    public void initialize() {
        
    }    
    
}
