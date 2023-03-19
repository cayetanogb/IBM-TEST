package model;

import java.sql.Date;

public class Proveedor {
    private Number id_proveedor;
    private String nombre;
    private Date fecha_alta;
    private Number id_cliente;

    public Proveedor() {
    }

    public Proveedor(Number id_proveedor, String nombre, Date fecha_alta, Number id_cliente) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.fecha_alta = fecha_alta;
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "Proveedor: [id_proveedor=" + id_proveedor + ", nombre=" + nombre + ", fecha_alta=" + fecha_alta + "]";
    }

    public Number getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Number id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Number getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Number id_cliente) {
        this.id_cliente = id_cliente;
    }
}
