
package sistema_salud.vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sistema_salud.modelo.Item;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Sistema;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ContenidoColumnasController{

    @FXML private TableView<Programa> tablaProgramas;
    @FXML private TableColumn<Programa, String> colId;
    @FXML private TableColumn<Programa, String> colNombre;
    @FXML private TableView<Item> tablaItems;
    @FXML private TableColumn<Item, String> colId1;
    @FXML private TableColumn<Item, String> colNombre1;
    @FXML private TextField txtBuscar;

    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaProgramas.setItems(sistema.getProgramas());
    }
    
    
    public void listaItemsPorPrograma(Programa programaSelect){
        tablaItems.setItems(programaSelect.getItems());
    }
    
    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<Programa, String>("nombre"));
        colId.setCellValueFactory(new PropertyValueFactory<Programa, String>("id"));
        tablaProgramas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> listaItemsPorPrograma(newValue));
        
        colNombre1.setCellValueFactory(new PropertyValueFactory<Item, String>("nombre"));
        colId1.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
    }    

    @FXML
    private void agregarItems(ActionEvent event) {
    }

    @FXML
    private void eliminarItems(ActionEvent event) {
    }

    @FXML
    private void buscarPrograma(ActionEvent event) {
    }

    @FXML
    private void agregarPrograma(ActionEvent event) {
    }

    @FXML
    private void editarPrograma(ActionEvent event) {
    }

    @FXML
    private void eliminarPrograma(ActionEvent event) {
    }
    
}
