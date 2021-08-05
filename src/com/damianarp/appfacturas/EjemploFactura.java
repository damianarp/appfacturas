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

        // Creamos un objeto del tipo Factura y le pasamos la descripción (sc.nextLine()) y el cliente.
        Factura factura = new Factura(sc.nextLine(), cliente);

        // Definimos un objeto del tipo Producto
        Producto producto;

        // Salto de línea
        System.out.println();

        // Creamos 5 objetos del tipo Producto con un for.
        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese nombre del producto Nº " + producto.getCodigo() + ": ");
            producto.setNombre(sc.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(sc.nextDouble());

            System.out.print("Ingrese la cantidad: ");
            // Agregamos la relación del item a la factura.
            factura.addItemFactura(new ItemFactura(sc.nextInt(),producto));

            // Salto de linea
            System.out.println();
            sc.nextLine();
        }
        // Al terminar de iterar, mostramos el detalle de la factura.
        System.out.println(factura);
    }
}
