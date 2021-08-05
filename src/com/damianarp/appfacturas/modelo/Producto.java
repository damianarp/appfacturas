package com.damianarp.appfacturas.modelo;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private static int ultimoCodigo; // Este atributo sirve para autoincrementar el numero de id o código del producto. Debe ser static para que no se reinicie cada vez que se ejecute.

    public Producto() {
        this.codigo = ++ultimoCodigo; // Lo preincrementamos para que comience en 1.
    }

    // Solo utilizamos el getter de este atributo ya que el código se autoincrementará en el método constructor.
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo +
                "\t" + nombre +
                "\t" + precio;
    }
}
