package com.PedidosGestion.PedidosGestion.models;

import com.PedidosGestion.PedidosGestion.service.factory.IProducto;


public class Electronico extends Producto implements IProducto {
    public Electronico(Long id, String nombre, double precio, String descripcion) {
        super(id, nombre, precio, descripcion);
    }

    @Override
    public double getPrecio() {
        return calcularPrecio();
    }

    @Override
    public Double calcularPrecio() {
        double precioEmpaqueEspecial = 1200;
        return precioEmpaqueEspecial + this.precio;
    }

    @Override
    public String getTipo() {
        return "Electrónico";
    }
}
