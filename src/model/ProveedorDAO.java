package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProveedorDAO {

    private PreparedStatement pst;
    private ResultSet rs;

    public ArrayList<Proveedor> getProveedores(Integer codigoCliente) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor;

        Connection conexion = null;

        try {
            conexion = Conexion.getInstance().getConnection();

            if (conexion != null) {
                String sql = "SELECT id_proveedor, nombre, fecha_alta FROM proveedores WHERE id_cliente = ?";

                pst = conexion.prepareStatement(sql);
                pst.setInt(0, codigoCliente);

                rs = pst.executeQuery();

                while (rs.next()) {
                    proveedor = new Proveedor();

                    proveedor.setId_proveedor(rs.getInt("id_proveedor"));
                    proveedor.setNombre(rs.getString("nombre"));
                    proveedor.setFecha_alta(rs.getDate("fecha_alta"));

                    proveedores.add(proveedor);
                }
            } else {
                System.out.println("Conexión fallida");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Conexion.getInstance().closeConnection(conexion);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return proveedores;
    }

}
