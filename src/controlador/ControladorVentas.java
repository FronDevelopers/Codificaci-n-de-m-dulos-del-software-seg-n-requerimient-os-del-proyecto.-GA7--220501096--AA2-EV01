package controlador;

import modelo.Venta;
import modelo.VentaDAO;
import vista.VentaProductos;
import java.util.List;

public class ControladorVentas {
    private final VentaDAO ventaDAO;
    private final VentaProductos ventaView;

    //Constructor
    public ControladorVentas(VentaDAO ventaDAO, VentaProductos ventaView) {
        this.ventaDAO = ventaDAO;
        this.ventaView = ventaView;
    }

    public void iniciar() {
        List<Venta> venta = ventaDAO.listarVentas();
        ventaView.mostrarVentas(venta);
        ventaView.setVisible(true);
    }
}
