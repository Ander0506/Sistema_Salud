
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Eps;
import sistema_salud.modelo.Sistema;


public class ContenidoEPSController {

    @FXML private TableView<Eps> tablaEPS;
    @FXML private TableColumn<Eps, String> colCodigo;
    @FXML private TableColumn<Eps, String> colNombre;
    @FXML private TextField txtBuscar;
    @FXML private JFXButton btEditarEPS;
    @FXML private JFXButton btActivarEPS;
    @FXML private JFXButton btDesactivarEPS;
    
    private Sistema sistema;
    private Eps eps;
    
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaEPS.setItems(sistema.getEpss());
    }
    
    private void seleccionarEPS(Eps epsSelect){
        if (epsSelect != null) {
            btEditarEPS.setDisable(false);
            if (epsSelect.getEstado()) {
                btActivarEPS.setDisable(true);
                btDesactivarEPS.setDisable(false);
            }else{
                btDesactivarEPS.setDisable(true);
                btActivarEPS.setDisable(false);
            }
        }
    }
    
    private void obtenerEps(Eps epsx) {
        eps = epsx;
    }
    
    public Eps getEps() {
        return eps;
    }
    
     @FXML void buscarEps() {
        if (txtBuscar.getText().isEmpty()) {
            tablaEPS.setItems(sistema.getEpss());
        }else{
            tablaEPS.setItems(sistema.retornarListaDeEPS(txtBuscar.getText()));
        }
    }
     
     @FXML void agregarEps() {
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/NuevaEPS.fxml"));
            AnchorPane newEps = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newEps);
            contenedor.setScene(escena);
            NuevaEPSController newEpsC = cargar.getController();
            newEpsC.setSistema(sistema);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     @FXML void editarEps(){
         try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/EditarEPS.fxml"));
            AnchorPane newEps = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newEps);
            contenedor.setScene(escena);
            EditarEPSController editEpsC = cargar.getController();
            editEpsC.setSistema(sistema);
            editEpsC.setEps(getEps());
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
     @FXML void desactivarEps(){
        Eps eps = tablaEPS.getSelectionModel().selectedItemProperty().get();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Desactivar Eps");
        alert.setHeaderText("Id: "+eps.getCodigo()+"\nNombre: "+eps.getNombre());
        alert.setContentText("Desea Desactivar esta Eps?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           eps.desactivar();
        } else {
            // ... user chose CANCEL or closed the dialog
        }  
     }
    
     @FXML void activarEps(){
         Eps eps = tablaEPS.getSelectionModel().selectedItemProperty().get();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Activar Eps");
        alert.setHeaderText("Id: "+eps.getCodigo()+"\nNombre: "+eps.getNombre());
        alert.setContentText("Desea activar esta Eps?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           eps.activar();
        } else {
            // ... user chose CANCEL or closed the dialog
        }  
     }
      
    @FXML
    public void initialize() {
        btActivarEPS.setDisable(true);
        btDesactivarEPS.setDisable(true);
        btEditarEPS.setDisable(true);
        
        colNombre.setCellValueFactory(new PropertyValueFactory<Eps, String>("nombre"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<Eps, String>("codigo"));
        tablaEPS.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> seleccionarEPS(newValue));
        tablaEPS.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> obtenerEps(newValue));

    }    
    
}
