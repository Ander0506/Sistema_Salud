/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Sistema;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class EditarProgramaController implements Initializable {

    @FXML    private JFXTextField txtId;
    @FXML    private JFXTextField txtNombre;
    @FXML    private JFXButton btok;
    @FXML    private JFXButton btCancelar;

    private Sistema  sistema = new Sistema();
    private Programa programa;
            
     public void setSistema(Sistema sistema) {
        this.sistema = sistema;
     }
     public void setPrograma(Programa prog){
         this.programa = prog;
         txtId.setText(this.programa.getId());
         txtNombre.setText(this.programa.getNombre());
     }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void editarPrograma(ActionEvent event) {
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
    private void cancelar(ActionEvent event) {
        Stage ventana = (Stage) btCancelar.getScene().getWindow();
                ventana.close();
    }
    
}
