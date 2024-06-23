
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

    // VENTA DAO
public class VentaDAO {
    public List<Venta> listarVentas() {
        List<Venta> ventas = new ArrayList<>();
        Connection connection = null;
        try {
            connection = conexionSQL.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT * FROM venta";

        try {
            try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
                
                while (resultSet.next()) {
                    Venta venta = new Venta();
                    venta.setId_venta(resultSet.getInt("id_venta"));
                    venta.setProductos(resultSet.getString("productos"));
                    venta.setDescripcion(resultSet.getString("descripcion"));
                    venta.setCantidad(resultSet.getInt("cantidad"));
                    venta.setPrecio(resultSet.getDouble("precio"));
                    venta.setTotal(resultSet.getDouble("total"));
                    ventas.add(venta);
                }
                
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ventas;
    }
    
        // Añadri Ventas //
    public boolean agregarVenta(Venta venta) {
    Connection connection = null;
        try {
            connection = conexionSQL.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    if (connection == null) {
        return false;
    }
    String sql = "INSERT INTO ventas (producto, descripcion, cantidad, precio, total) VALUES (?, ?, ?, ?)";
    try {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, venta.getProductos());
            statement.setString(2, venta.getDescripcion());
            statement.setInt(3, venta.getCantidad());
            statement.setDouble(4, venta.getPrecio());
            statement.setDouble(5, venta.getTotal());
            statement.executeUpdate();
        }
        connection.close();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
  }
    
    //Actualizar Venta
    public boolean actualizarVenta(Venta venta) {
    Connection connection = null;
        try {
            connection = conexionSQL.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    if (connection == null) {
        return false;
    }
    String sql = "UPDATE ventas SET producto = ?, descripcion =?, cantidad = ?, precio = ?, total = ? WHERE id = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, venta.getProductos());
        statement.setString(2, venta.getDescripcion());
        statement.setInt(3, venta.getCantidad());
        statement.setDouble(4, venta.getPrecio());
        statement.setDouble(5, venta.getTotal());
        statement.setInt(6, venta.getId_venta());
        statement.executeUpdate();
        statement.close();
        connection.close();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
  }
    
    // Eliminar Venta
    public boolean eliminarVenta(int id_venta) {
    Connection connection = null;
        try {
            connection = conexionSQL.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    if (connection == null) {
        return false;
    }
    String sql = "DELETE FROM ventas WHERE id = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_venta);
        statement.executeUpdate();
        statement.close();
        connection.close();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
  }
}

