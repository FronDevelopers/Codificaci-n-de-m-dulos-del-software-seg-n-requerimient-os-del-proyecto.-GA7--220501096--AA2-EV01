package controlador;

import modelo.Venta;
import modelo.VentaDAO;
import vista.VentaProductos;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorVentas {
    private final VentaDAO ventaDAO;
    private final VentaProductos ventaView;

    public ControladorVentas(VentaDAO ventaDAO, VentaProductos ventaView) {
        this.ventaDAO = ventaDAO;
        this.ventaView = ventaView;
        this.ventaView.getBtnAgregar().addActionListener(e -> agregarVenta());
        this.ventaView.getBtnActualizar().addActionListener(e -> actualizarVenta());
        this.ventaView.getBtnEliminar().addActionListener(e -> eliminarVenta());
    }

    public void iniciar() {
        List<Venta> ventas = ventaDAO.listarVentas();
        ventaView.mostrarVentas(ventas);
        ventaView.setVisible(true);
    }

    private void agregarVenta() {
        String producto = ventaView.getTxtProducto().getText();
        String descripcion = ventaView.getTxtDescripcion().getText();
        int cantidad = Integer.parseInt(ventaView.getTxtCantidad().getText());
        double precio = Double.parseDouble(ventaView.getTxtPrecio().getText());
        double total = cantidad * precio;

        Venta venta = new Venta();
        venta.setProducto(producto);
        venta.setDescripcion(descripcion);
        venta.setCantidad(cantidad);
        venta.setPrecio(precio);
        venta.setTotal(total);

        ventaDAO.agregarVenta(venta);
        actualizarVista();
    }

    private void actualizarVenta() {
        int selectedRow = ventaView.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ventaView, "Seleccione una fila para actualizar");
            return;
        }
        int id_venta = (int) ventaView.getTable().getValueAt(selectedRow, 0);
        String producto = ventaView.getTxtProducto().getText();
        String descripcion = ventaView.getTxtDescripcion().getText();
        int cantidad = Integer.parseInt(ventaView.getTxtCantidad().getText());
        double precio = Double.parseDouble(ventaView.getTxtPrecio().getText());
        double total = cantidad * precio;

        Venta venta = new Venta();
        venta.setId(id_venta);
        venta.setProducto(producto);
        venta.setDescripcion(descripcion);
        venta.setCantidad(cantidad);
        venta.setPrecio(precio);
        venta.setTotal(total);

        ventaDAO.actualizarVenta(venta);
        actualizarVista();
    }

    private void eliminarVenta() {
        int selectedRow = ventaView.getTable().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(ventaView, "Seleccione una fila para eliminar");
            return;
        }
        int id = (int) ventaView.getTable().getValueAt(selectedRow, 0);
        ventaDAO.eliminarVenta(id);
        actualizarVista();
    }

    private void actualizarVista() {
        List<Venta> ventas = ventaDAO.listarVentas();
        ventaView.mostrarVentas(ventas);
    }
}
