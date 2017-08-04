
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


public class EditarProgramaController {

    @FXML    private JFXTextField txtId;
    @FXML    private JFXTextField txtNombre;
    @FXML    private JFXButton btok;
    @FXML    private JFXButton btCancelar;

    private Sistema  sistema;
    private Programa programa;
    
     public void setSistema(Sistema sistema) {
        this.sistema = sistema;
     }
     public void setPrograma(Programa prog){
         this.programa = prog;
         txtId.setText(prog.getId());
         txtNombre.setText(prog.getNombre());
     }
        
    @FXML
    public void initialize() {
      
    }    

    @FXML
    void editarPrograma() {
        if (sistema.isNumeric(txtId.getText())) {
            try {
                programa.setId(txtId.getText());
                programa.setNombre(txtNombre.getText());
                Stage ventana = (Stage)btok.getScene().getWindow();
                ventana.close();
            } catch (Exception ex) {
                Logger.getLogger(EditarProgramaController.class.getName()).log(Level.SEVERE, null, ex);
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
    void cancelar() {
        Stage ventana = (Stage) btCancelar.getScene().getWindow();
                ventana.close();
    }
    
}
