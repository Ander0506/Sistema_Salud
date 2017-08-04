
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private Sistema sistema;
    private Programa programa;
    private ObservableList<Item> listaItems;
    private ObservableList<Restriccion> listaRestriccion;

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaProgramas.setItems(sistema.getProgramas());
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programaSelect) {
        this.programa = programaSelect;
        listaItems = FXCollections.observableArrayList(programaSelect.getItems());
        listaRestriccion = FXCollections.observableArrayList(programaSelect.getRestricciones());
        tablaItems.setItems(listaItems);
        tablaRestricciones.setItems(listaRestriccion);
    }
    
    private void listaItemsPorPrograma(Programa programaSelect){
        if (programaSelect != null) {
            btAgregarItem.setDisable(false);
            btAgregarRestriccion.setDisable(false);
            btEditarPrograma.setDisable(false);
            btEliminarPrograma.setDisable(false);
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
    
    @FXML void agregarItems() {
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
            newItemC.setContenidoProgramas(this);
//            newItemC.setProg(getPrograma());
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML void eliminarItems() {
        Item item = tablaItems.getSelectionModel().selectedItemProperty().get();
        Programa prog = getPrograma();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Item");
        alert.setHeaderText("Programa: "+prog.getNombre()+" ( "+prog.getId()+" ) \n Id: "+item.getId()+"\n Nombre: "+item.getNombre());
        alert.setContentText("Desea eliminar este item?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                prog.eliminarItem(item);
                setPrograma(prog);
            } catch (Exception ex) {
                Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
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
     
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/EditarPrograma.fxml"));
            AnchorPane newPrograma = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newPrograma);
            contenedor.setScene(escena);
            EditarProgramaController editProgramaC = cargar.getController();
            editProgramaC.setSistema(sistema);
            editProgramaC.setPrograma(getPrograma());
            contenedor.show();
            
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }

    @FXML void eliminarPrograma() {
        Programa prog = tablaProgramas.getSelectionModel().selectedItemProperty().get();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar programa");
        alert.setHeaderText(" Id: "+prog.getId()+"\n Nombre: "+prog.getNombre());
        alert.setContentText("Desea eliminar este programa?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                sistema.eliminarPrograma(prog);
            } catch (Exception ex) {
                Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        } else {
            // ... user chose CANCEL or closed the dialog
        }
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
            newRestriccionC.setProg(getPrograma());
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML void eliminarRestriccion() {
        Restriccion restri = tablaRestricciones.getSelectionModel().selectedItemProperty().get();
        Programa prog = getPrograma();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Restriccion");
        alert.setHeaderText("Programa: "+prog.getNombre()+" ( "+prog.getId()+" ) \n"
                + " Id: "+restri.getId()+"\n Descripcion: "+restri.getDescripcion());
        alert.setContentText("Desea eliminar esta restricion?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                prog.eliminarRestriccion(restri);
            } catch (Exception ex) {
                Logger.getLogger(ContenidoColumnasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
        
    }

    @FXML    public void initialize() {
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
