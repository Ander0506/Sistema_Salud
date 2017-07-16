
package sistema_salud.vista;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;


public class PrincipalController implements Initializable {
    
    @FXML private Label nombreUsuario;
    @FXML private JFXHamburger menu;
    @FXML private JFXDrawer menuDesplegable;
    @FXML private JFXDrawer contenido;



private Sistema nuevoSistema;
private Usuario nuevoUsuario;



    public void setNuevoSistema(Sistema nuevoSistema) {
        this.nuevoSistema = nuevoSistema;
    }

    public void setNuevoUsuario(Usuario nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
        nombreUsuario.setText(this.nuevoUsuario.getNombre()+" "+this.nuevoUsuario.getApellidos());
    }
    

    VBox inicioMenu(Usuario nuevoUsuario){
        VBox resultado = new VBox();
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/DrawerContent.fxml"));
            resultado = (VBox)cargar.load();
            DrawerContentController principalC = cargar.getController();
            principalC.setNuevoUsuario(nuevoUsuario);
            principalC.setPrincipal(this);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    public void presBoton(AnchorPane contenidoBoton){
         contenido.open();
         contenido.setSidePane(contenidoBoton);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menu);
        transition.setRate(-1);
        menu.addEventHandler(MouseEvent.MOUSE_PRESSED,(e) -> {
            transition.setRate(transition.getRate()*-1);
            transition.play();
            if (menuDesplegable.isShown()) {
                menuDesplegable.close();
            }else{
                menuDesplegable.open();
                menuDesplegable.setSidePane(inicioMenu(this.nuevoUsuario));
            }
        });
    }    
}