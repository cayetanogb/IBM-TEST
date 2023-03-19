package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Proveedor;
import model.ProveedorDAO;

public class App {
    public static void main(Integer args) throws Exception {
        ProveedorDAO model = new ProveedorDAO();
        Integer codigoCliente = args;
        String ruta = "c:/proveedores.txt";
        String contenido = "";

        if (codigoCliente.toString().isEmpty()) {
            System.out.println("No se ha especificado el codigo del cliente");
        } else {
            ArrayList<Proveedor> proveedores = model.getProveedores(codigoCliente);

            for (Proveedor proveedor : proveedores) {
                contenido += proveedor.toString() + "\n";
            }
        }

        File file = new File(ruta, "UTF-8");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();
    }
}
