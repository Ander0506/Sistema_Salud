
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Item;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Sistema;


public class NuevoItemController {

    @FXML    private JFXTextField txtId;
    @FXML    private JFXTextField txtNombre;
    @FXML    private JFXButton btOk;
    @FXML    private JFXButton btCancelar;

    
    
    private Sistema sistema;
    private ContenidoColumnasController contenidoProgramas;
    private Programa prog;

    public void setProg(Programa prog) {
        this.prog = prog;
    }

    public void setContenidoProgramas(ContenidoColumnasController contenidoProgramas) {
        this.contenidoProgramas = contenidoProgramas;
    }
    
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @FXML void agregarItems(){
        if (sistema.isNumeric(txtId.getText())) {
            try {
                Item item = new Item(txtId.getText(),txtNombre.getText());   
                prog.adicionarItem(item);
                contenidoProgramas.setPrograma(prog);
                Stage ventana = (Stage)btOk.getScene().getWindow();
                 ventana.close();
                 
            } catch (Exception ex) {
                Logger.getLogger(NuevoItemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            alerta.setContentText("El campo de Id debe ser numerico");
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
