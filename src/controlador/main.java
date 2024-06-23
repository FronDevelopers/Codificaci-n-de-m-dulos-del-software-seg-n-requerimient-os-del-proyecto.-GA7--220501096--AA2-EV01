
package controlador;

import modelo.VentaDAO;
import vista.VentaProductos;

public class main {
        public static void main(String[] args) {
        VentaDAO ventaDAO = new VentaDAO();
        VentaProductos ventaView = new VentaProductos();
        ControladorVentas ventaController = new ControladorVentas(ventaDAO, ventaView);
        ventaController.iniciar();
    }
}
