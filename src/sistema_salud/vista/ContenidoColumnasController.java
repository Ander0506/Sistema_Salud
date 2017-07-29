
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Item;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Restriccion;
import sistema_salud.modelo.Sistema;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ContenidoColumnasController {

    @FXML private TableView<Programa> tablaProgramas;
    @FXML private TableColumn<Programa, String> colId;
    @FXML private TableColumn<Programa, String> colNombre;
    @FXML private TableView<Item> tablaItems;
    @FXML private TableColumn<Item, String> colId1;
    @FXML private TableColumn<Item, String> colNombre1;
    @FXML private TextField txtBuscar;
    @FXML private TableView<Restriccion> tablaRestricciones;
    @FXML private TableColumn<Restriccion, String> colResId;
    @FXML private TableColumn<Restriccion, Double> colEdadMin;
    @FXML private TableColumn<Restriccion, Double> colEdadMax;
    @FXML private TableColumn<Restriccion, String> colSexo;
    @FXML private JFXTextArea txtAreaDescripcion;
    @FXML private JFXButton btEditarPrograma;
    @FXML private JFXButton btEliminarPrograma;
    @FXML private JFXButton btEliminarItem;
    @FXML private JFXButton btAgregarItem;
    @FXML private JFXButton btEliminarRestriccion;
    @FXML private JFXButton btAgregarRestriccion;

    private Sistema sistema = new Sistema();
    private Programa programa;

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaProgramas.setItems(sistema.getProgramas());
    }

    public Programa getPrograma() {
        return programa;
    }

    private void setPrograma(Programa programa) {
        this.programa = programa;
    }
    
    private void listaItemsPorPrograma(Programa programaSelect){
        if (programaSelect != null) {
            btAgregarItem.setDisable(false);
            btAgregarRestriccion.setDisable(false);
            btEditarPrograma.setDisable(false);
            btEliminarPrograma.setDisable(false);
            tablaItems.setItems(programaSelect.getItems());
            tablaRestricciones.setItems(programaSelect.getRestricciones());  
        }
    }
    
    private void descripcionRestricion(Restriccion restriccionSelect){
        if (restriccionSelect != null) {
            btEliminarRestriccion.setDisable(false);
            txtAreaDescripcion.setText(restriccionSelect.getDescripcion());
        }else{
            btEliminarRestriccion.setDisable(true);
            txtAreaDescripcion.setText("");
        }
    }
    
    private void selecionarItem(Item itemSelect){
        if (itemSelect != null) {
            btEliminarItem.setDisable(false);
        }else{
            btEliminarItem.setDisable(true);
        }
    }
    
    @FXML
    private void agregarItems(ActionEvent event) {
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/NuevoItem.fxml"));
            AnchorPane newItem = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newItem);
            contenedor.setScene(escena);
            NuevoItemController newItemC = cargar.getController();
            newItemC.setSistema(sistema);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void eliminarItems(ActionEvent event) {
    }

    @FXML void buscarPrograma() {
        if (txtBuscar.getText().isEmpty()) {
            tablaProgramas.setItems(sistema.getProgramas());
        }else{
            tablaProgramas.setItems(sistema.retornarListaDeProgramas(txtBuscar.getText()));
        }
    }

    @FXML void agregarPrograma() {
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/NuevoPrograma.fxml"));
            AnchorPane newPrograma = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newPrograma);
            contenedor.setScene(escena);
            NuevoProgramaController newProgramaC = cargar.getController();
            newProgramaC.setSistema(sistema);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML void editarPrograma() {
    }

    @FXML void eliminarPrograma() {
    }
    
    @FXML void agregarRestriccion() {
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/NuevaRestriccion.fxml"));
            AnchorPane newRestriccion = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newRestriccion);
            contenedor.setScene(escena);
            NuevaRestriccionController newRestriccionC = cargar.getController();
            newRestriccionC.setSistema(sistema);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML void eliminarRestriccion() {

    }

    @FXML
    public void initialize() {
        btEliminarItem.setDisable(true);
        btEliminarRestriccion.setDisable(true);
        btEditarPrograma.setDisable(true);
        btEliminarPrograma.setDisable(true);
        btAgregarItem.setDisable(true);
        btAgregarRestriccion.setDisable(true);
        colNombre.setCellValueFactory(new PropertyValueFactory<Programa, String>("nombre"));
        colId.setCellValueFactory(new PropertyValueFactory<Programa, String>("id"));
        tablaProgramas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> listaItemsPorPrograma(newValue));
        tablaProgramas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setPrograma(newValue));
        
        selecionarItem(null);
        colNombre1.setCellValueFactory(new PropertyValueFactory<Item, String>("nombre"));
        colId1.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
        tablaItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)-> selecionarItem(newValue));
        
        descripcionRestricion(null);
        colResId.setCellValueFactory(new PropertyValueFactory<Restriccion, String>("id"));
        colEdadMin.setCellValueFactory(new PropertyValueFactory<Restriccion, Double>("edadMin"));
        colEdadMax.setCellValueFactory(new PropertyValueFactory<Restriccion, Double>("edadMax"));
        colSexo.setCellValueFactory(new PropertyValueFactory<Restriccion, String>("sexo"));
        tablaRestricciones.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> descripcionRestricion(newValue));
    }    
}
