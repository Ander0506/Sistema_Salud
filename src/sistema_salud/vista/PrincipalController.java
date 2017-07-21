
package sistema_salud.vista;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sistema_salud.controlador.Sistema_Salud;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;


public class PrincipalController {
    
    @FXML private Label nombreUsuario;
    @FXML private JFXHamburger menu;
    @FXML private JFXDrawer menuDesplegable;
    @FXML private JFXDrawer contenido;



private Sistema sistema = new Sistema();
private Usuario nuevoUsuario;



    public void setNuevoSistema(Sistema nuevoSistema) {
        this.sistema = nuevoSistema;
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
            principalC.setSistema(sistema);
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
    
    @FXML public void initialize() {
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menu);
        transition.setRate(-1);
        menu.addEventHandler(MouseEvent.MOUSE_PRESSED,(e) -> {
            transition.setRate(transition.getRate()*-1);
            transition.play();
            if (menuDesplegable.isShown()) {
                menuDesplegable.close();
                menuDesplegable.setMouseTransparent(true);
            }else{
                menuDesplegable.open();
                menuDesplegable.setMouseTransparent(false);
                menuDesplegable.setSidePane(inicioMenu(nuevoUsuario));
            }
        });
    }    
}