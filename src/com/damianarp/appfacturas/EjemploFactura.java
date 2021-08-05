package com.damianarp.appfacturas;

import com.damianarp.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        // Creamos un objeto del tipo Cliente
        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Damián");

        // Utilizamos la clase Scanner para ingresar los datos de la factura.
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una  descripción de la factura: ");

        // Leemos la descripción ingresada por el usuario.
        String desc = sc.nextLine();

        // Creamos un objeto del tipo Factura
        Factura factura = new Factura(desc, cliente);

        // Definimos un objeto del tipo Producto
        Producto producto;

        // Cada producto tendrá:
        String nombre;
        double precio;
        int cantidad;

        // Salto de línea
        System.out.println();

        // Creamos 5 objetos del tipo Producto con un for.
        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese nombre del producto Nº " + producto.getCodigo() + ": ");
            nombre = sc.nextLine();
            producto.setNombre(nombre);

            System.out.print("Ingrese el precio: ");
            precio = sc.nextDouble();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad = sc.nextInt();
            ItemFactura item = new ItemFactura(cantidad,producto);

            // Agregamos la relación del item a la factura.
            factura.addItemFactura(item);

            // Salto de linea
            System.out.println();
            sc.nextLine();
        }
        // Al terminar de iterar, mostramos el detalle de la factura.
        System.out.println(factura.generarDetalle());
    }
}
