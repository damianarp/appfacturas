package com.damianarp.appfacturas.modelo;

public class ItemFactura {
    private int cantidad;
    private Producto producto;

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Método para calcular el importe (precio del producto * cantidad)
    public double calcularImporte() {
        return this.cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return producto.toString() + // Agregamos el método toString() para poder acceder a este método con step into en el modo debug.
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}
