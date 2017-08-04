
package sistema_salud.controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistema_salud.modelo.Eps;
import sistema_salud.modelo.Fecha;
import sistema_salud.modelo.Item;
import sistema_salud.modelo.Paciente;
import sistema_salud.modelo.Programa;
import sistema_salud.modelo.Restriccion;
import sistema_salud.modelo.Sistema;
import sistema_salud.modelo.Usuario;
import sistema_salud.vista.LoginController;


public class Sistema_Salud extends Application {
    
    private Stage contenedor;
    private final String ruta = "src/Datos/Sistema.txt";
    private Sistema sistema = new Sistema();
    

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    @Override
    public void start(Stage contenedor) {
       this.contenedor = contenedor;
       this.contenedor.setTitle("Login");
//       sistema.cargar(ruta);
//       crearUsuario();
//       sistema.guardar(ruta);
//       crearProgramas();
//       crearEPS();
       iniciarLogin();
    }
    
    void crearUsuario() {
        try {
            Usuario user = new Usuario("123456789", "Admin", "xxxx", "xxxx@xxx.com", "Administrador", "Masculino", "Admin", "0000");
//            Usuario user = new Usuario("1045674309", "Anderson", "Jimenez", "andersonjesusujv@hotmail.com", "Administrador", "Masculino", "Anderson", "123");
//            Usuario user2 = new Usuario("1067890354", "Andres", "Padilla", "andrestrilli@hotmail.com", "Administrador", "Masculino", "Andres", "12345");
//            Usuario user3 = new Usuario("1895674532", "Byron", "Barrios", "BBarrios@hotmail.com", "Usuario", "Masculino", "Byron", "1234");
//            user3.setEstado(false);
            sistema.adicionarUsuario(user);
//            this.sistema.adicionarUsuario(user2);
//            this.sistema.adicionarUsuario(user3);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    void crearEPS(){
        try {
            Eps eps1 = new Eps("Sura", "3110");
            Eps eps2 = new Eps("Salud Total", "8710");
            Eps eps3 = new Eps("Commeva", "5743");
            sistema.adicionarEps(eps1);
            sistema.adicionarEps(eps2);
            sistema.adicionarEps(eps3);
            Paciente paciente1 = new Paciente(1, "Anderson", "Jesus", "Jimenez", "Visbal", "Cedula de Ciudadania", "1045674309", Fecha.string_A_LocalDate("24/01/1988"), "Masculino", eps1);
            Paciente paciente2 = new Paciente(2, "Katherin", "Rocio", "Jimenez", "Visbal", "Cedula de Ciudadania", "1140830816", Fecha.string_A_LocalDate("09/04/1990"), "Femenino", eps2);
            Paciente paciente3 = new Paciente(3, "Rocio", "Esther", "Visbal", "De Avila", "Cedula de Ciudadania", "32824081", Fecha.string_A_LocalDate("30/03/1967"), "Femenino", eps3);
            paciente1.adicionarPrograma(sistema.getProgramas().get(0));
            sistema.adicionarPaciente(paciente1);
            sistema.adicionarPaciente(paciente2);
            sistema.adicionarPaciente(paciente3);
        } catch (Exception ex) {
            Logger.getLogger(Sistema_Salud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void crearProgramas(){
        try {
            Programa programa1 = new Programa("11", "Programa 1");
            Programa programa2 = new Programa("12", "Programa 2");
            Programa programa3 = new Programa("13", "Programa 3");
            Item item1 = new Item("01", "item1");
            Item item2 = new Item("02", "item2");
            Item item3 = new Item("03", "item3");
            Item item4 = new Item("04", "item4");
            Item item5 = new Item("05", "item5");
            Item item6 = new Item("06", "item6");
            Item item7 = new Item("07", "item7");
            Item item8 = new Item("08", "item8");
            Restriccion res1 = new Restriccion("01", 4.0, 12.0, "Ambos", "Solo niños mayores de 4 y menores de 12 años de ambos sexos");
            Restriccion res2 = new Restriccion("02", 18.0, 0.0, "Femenino", "Mujeres mayores de 18 años");
            programa1.adicionarItem(item8);
            programa1.adicionarItem(item5);
            programa1.adicionarItem(item2);
            programa2.adicionarItem(item1);
            programa2.adicionarItem(item2);
            programa2.adicionarItem(item3);
            programa2.adicionarItem(item4);
            programa3.adicionarItem(item8);
            programa3.adicionarItem(item7);
            programa3.adicionarItem(item6);
            programa3.adicionarItem(item5);
            programa3.adicionarItem(item4);
            programa3.adicionarItem(item3);
            programa3.adicionarItem(item2);
            programa3.adicionarItem(item1);
            programa1.adicionarRestricciones(res1);
            programa1.adicionarRestricciones(res2);
            sistema.adicionarPrograma(programa1);
            sistema.adicionarPrograma(programa2);
            sistema.adicionarPrograma(programa3);
        } catch (Exception ex) {
            Logger.getLogger(Sistema_Salud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void iniciarLogin(){
        try {
            FXMLLoader cargar = new FXMLLoader();
            cargar.setLocation(Sistema_Salud.class.getResource("../vista/Login.fxml"));
           // cargar.setLocation(Sistema_Salud.class.getResource("../vista/.fxml"));
            AnchorPane login = (AnchorPane) cargar.load();
            Scene escena = new Scene(login);
            contenedor.setScene(escena);
            LoginController loginC = cargar.getController();
            loginC.setSistema(sistema);
            contenedor.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Sistema_Salud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
