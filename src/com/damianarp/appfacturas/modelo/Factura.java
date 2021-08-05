package com.damianarp.appfacturas.modelo;

import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems; // Se necesita este indice para agregar los items al arreglo ItemFactura[] con el método addItemFactura().
    public static final int MAX_ITEMS = 12; // Esta constante representa el número máximo de items del arreglo ItemFacturas[], se la pasamos al arreglo al inicializarlo.
    private static int ultimoFolio; // Este atributo sirve para autoincrementar el numero de folios. Debe ser static para que no se reinicie cada vez que se ejecute.

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS]; // Debemos inicializar el arreglo ItemFactura[] para que al momento de ejecutar el método addItemFactura no retorne null y lance un NullPointerException.
        this.folio = ++ultimoFolio; // Lo preincrementamos para que comience en 1.
        this.fecha =  new Date(); // Inicializamos una fecha por defecto, para que cuando se cree el objeto Factura se cree con la fecha actual.
    }

    // Solo usamos el getter de este atributo ya que se autogenera e incrementa en el método constructor, por lo que no necesitamos el setter.
    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Solo tenemos el getter de este atributo porque no se usa el setter, ya que los items se agregar con el método addItemFactura().
    public ItemFactura[] getItems() {
        return items;
    }

    // Método para insertar items dentro del arreglo ItemFactura[], recibe como parámetro el item.
    public void addItemFactura(ItemFactura item) {
        // Validamos para que no se lance un ArrayIndexOutOfBoundsException.
        if(indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

}
