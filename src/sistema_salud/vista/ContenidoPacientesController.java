
package sistema_salud.vista;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Fecha;
import sistema_salud.modelo.Paciente;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Sistema;


public class ContenidoPacientesController {

    @FXML private TableView<Paciente> tablaPacientes;
    @FXML private TableColumn<Paciente, Integer> colId;
    @FXML private TableColumn<Paciente, String> colNombre;
    @FXML private TableColumn<Paciente, String> colApellido;
    @FXML private TableColumn<Paciente, String> colDocumento;
    @FXML private Label labelTipoDeDocumento;
    @FXML private Label labelDocumento;
    @FXML private Label labelFechaDeNacimiento;
    @FXML private Label labelSexo;
    @FXML private Label labelEstado;
    @FXML private Label labelEPS;
    @FXML private Label labelId;
    @FXML private Label labelNombre;
    @FXML private Label labelApellido;
    @FXML private TextField txtBuscar;
    @FXML private JFXButton btEditarPaciente;
    @FXML private JFXButton btActivarPaciente;
    @FXML private JFXButton btDesactivarPaciente;
    @FXML private TableView<Programa> tablaProgramasInscritos;
    @FXML private TableColumn<Programa, String> colIdPro;
    @FXML private TableColumn<Programa, String> colNombrePro;
    
    private Sistema sistema = new Sistema();

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
        tablaPacientes.setItems(sistema.getPacientes());
    }
    
     private void detallePaciente(Paciente pacienteSelect){
        if (pacienteSelect != null) {
            if (pacienteSelect.getEstado()) {
                btDesactivarPaciente.setDisable(false);
                btActivarPaciente.setDisable(true);
            }else{
                btDesactivarPaciente.setDisable(true);
                btActivarPaciente.setDisable(false);
            }
            btEditarPaciente.setDisable(false);
            tablaProgramasInscritos.setItems(pacienteSelect.getProgramas());
            labelId.setText(String.valueOf(pacienteSelect.getId()));
            labelNombre.setText(pacienteSelect.getNombre1()+" "+pacienteSelect.getNombre2());
            labelApellido.setText(pacienteSelect.getApellido1()+" "+pacienteSelect.getApellido2());
            labelTipoDeDocumento.setText(pacienteSelect.getTipoDocumento());
            labelDocumento.setText(pacienteSelect.getDocumento());
            labelFechaDeNacimiento.setText(Fecha.localDate_A_String(pacienteSelect.getFechaNacimiento()));
            labelSexo.setText(pacienteSelect.getSexo());
            labelEPS.setText(pacienteSelect.getEpsUser().getNombre());
            if (pacienteSelect.getEstado()) {
                labelEstado.setText("Activo");
            }else{
                labelEstado.setText("Inactivo");
            }
        }else{
            labelId.setText("");
            labelNombre.setText("");
            labelApellido.setText("");
            labelTipoDeDocumento.setText("");
            labelDocumento.setText("");
            labelFechaDeNacimiento.setText("");
            labelSexo.setText("");
            labelEPS.setText("");
            labelEstado.setText("");
        }
    }
     
    @FXML void agregarPaciente(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/NuevoPaciente.fxml"));
            AnchorPane newPaciente = (AnchorPane) cargar.load();
            Stage contenedor = new Stage();
            contenedor.initStyle(StageStyle.UNDECORATED);
            Scene escena = new Scene(newPaciente);
            contenedor.setScene(escena);
            NuevoPacienteController newPacienteC = cargar.getController();
            newPacienteC.setSistema(sistema);
            contenedor.show();
        } catch (IOException ex) {
            Logger.getLogger(ContenidoPacientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML void buscarPaciente() {
        if (txtBuscar.getText().isEmpty()) {
            tablaPacientes.setItems(sistema.getPacientes());
        }else{
            tablaPacientes.setItems(sistema.retornarListaDePacientes(txtBuscar.getText()));
        }
    }
    
    @FXML
    public void initialize() {
        btActivarPaciente.setDisable(true);
        btDesactivarPaciente.setDisable(true);
        btEditarPaciente.setDisable(true);
        
        colNombre.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre1"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Paciente, String>("apellido1"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<Paciente, String>("documento"));
        colId.setCellValueFactory(new PropertyValueFactory<Paciente, Integer>("id"));
        
        detallePaciente(null);
        tablaPacientes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> detallePaciente(newValue));
        
        colIdPro.setCellValueFactory(new PropertyValueFactory<Programa, String>("id"));
        colNombrePro.setCellValueFactory(new PropertyValueFactory<Programa, String>("nombre"));
        
    }    
    
}
