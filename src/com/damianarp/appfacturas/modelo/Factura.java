package com.damianarp.appfacturas.modelo;

import java.text.SimpleDateFormat;
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

    // Método para calcular el total de la factura. Para ello debemos iterar cada importe del arreglo ItemFactura[], sumarlos y retornar el total.
    public double calcularTotal() {
        double total = 0.0; // Variable local del método para inicializar la suma en 0.
        for( int i = 0; i < indiceItems; i++) {
            total += this.items[i].calcularImporte();
        }
        return total;
    }

    // Método para generar el detalle de la factura.
    // Utilizamos un StringBuilder con su método append para concatenar (en vez de usar el +) porque debemos concatenar bastante información
    // y el StringBuilder tiene un mejor rendimiento en este sentido.
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(this.folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\tNIF: ")
                .append(this.cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        // Formateamos la fecha asi se la agregamos al StringBuilder en el detalle de la factura.
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");

        sb.append("Fecha de emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tSubtotal\n");

        // Comenzamos con la iteración.
        for (int i = 0; i < indiceItems; i++) {
            sb.append(this.items[i].toString()) // Agregamos el método toString() para poder acceder a este método con step into en el modo debug.
                    .append("\n");
        }
        sb.append("\nTotal: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
