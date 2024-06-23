package vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Venta;

public class VentaProductos extends JFrame {
    private final JTable table;
    private final DefaultTableModel model;
    private final String[] columnNames = {"ID", "Producto", "Descripcion", "Cantidad", "Precio", "Total"};
    private final JTextField txtProducto;
    private final JTextField txtDescripcion;
    private final JTextField txtCantidad;
    private final JTextField txtPrecio;
    private final JButton btnAgregar;
    private final JButton btnActualizar;
    private final JButton btnEliminar;

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

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Producto:"));
        txtProducto = new JTextField();
        panel.add(txtProducto);
        
        panel.add(new JLabel("Descripcion:"));
        txtDescripcion = new JTextField();
        panel.add(txtDescripcion);

        panel.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panel.add(txtCantidad);

        panel.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        btnAgregar = new JButton("Agregar");
        panel.add(btnAgregar);

        btnActualizar = new JButton("Actualizar");
        panel.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        panel.add(btnEliminar);

        add(panel, BorderLayout.SOUTH);
    }

    public void mostrarVentas(List<Venta> ventas) {
        model.setRowCount(0);
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

    public JTextField getTxtProducto() {
        return txtProducto;
    }
    
        public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JTable getTable() {
        return table;
    }
}

