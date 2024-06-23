
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
}

