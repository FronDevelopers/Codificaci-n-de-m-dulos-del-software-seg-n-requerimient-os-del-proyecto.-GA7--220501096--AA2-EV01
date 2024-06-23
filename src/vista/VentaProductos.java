package vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Venta;

public class VentaProductos extends JFrame{

    private final JTable table;
    private final DefaultTableModel model;
    private final String[] columnNames = {"Código", "Producto", "Descripción", "Cantidad", "Precio", "Total"};

    public VentaProductos() {
        setTitle("Ventas de Productos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        table = new JTable();
        model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void mostrarVentas(List<Venta> ventas) {
        for (Venta venta : ventas) {
            Object[] row = {
                venta.getId_venta(),
                venta.getProductos(),
                venta.getDescripcion(),
                venta.getCantidad(),
                venta.getPrecio(),
                venta.getTotal()
            };
            model.addRow(row);
        }
    }
}

