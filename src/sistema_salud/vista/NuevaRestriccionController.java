
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Restriccion;
import sistema_salud.modelo.Sistema;


public class NuevaRestriccionController {

    @FXML private JFXTextField txtId;
    @FXML private JFXTextField txtEdadMaxima;
    @FXML private JFXTextField txtEdadMinima;
    @FXML private JFXTextArea txtAreaDescripcion;
    @FXML private JFXComboBox<String> comboBoxSexo;
    @FXML    private JFXButton btOk;
    @FXML    private JFXButton btCancelar;
    
    private Sistema sistema = new Sistema();
    private Programa prog;

    public void setProg(Programa prog) {
        this.prog = prog;
    }
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    ObservableList<String> itemSex = FXCollections.observableArrayList("Femenino","Masculino","Ambos");

    @FXML void agregarRestriccion(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Informacion");
            alerta.setHeaderText(null);
            
        if (sistema.isNumeric(txtId.getText())) {
            if (sistema.isNumeric(txtEdadMinima.getText())) {
                if (sistema.isNumeric(txtEdadMaxima.getText())) {
                    
                    try {
                        Restriccion restri = new Restriccion(txtId.getText(), Double.parseDouble(txtEdadMinima.getText()),
                                Double.parseDouble(txtEdadMaxima.getText()), comboBoxSexo.getValue(), txtAreaDescripcion.getText());
                        prog.adicionarRestricciones(restri);
                        Stage ventana = (Stage) btOk.getScene().getWindow();
                        ventana.close();

                        
                    } catch (Exception ex) {
                        Logger.getLogger(NuevaRestriccionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    alerta.setContentText("El campo de Edad Maxima debe ser numerico");
                    alerta.show();
                }
                
            }else{
            alerta.setContentText("El campo de Edad minima debe ser numerico");
            alerta.show();
            }
            
        }else{
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
       comboBoxSexo.setItems(itemSex);
    }    
    
}
