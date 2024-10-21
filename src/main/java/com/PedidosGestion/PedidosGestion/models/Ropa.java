package com.PedidosGestion.PedidosGestion.models;

import com.PedidosGestion.PedidosGestion.service.factory.IProducto;

public class Ropa extends Producto implements IProducto {
    public Ropa(Long id, String nombre, double precio, String descripcion) {
        super(id, nombre, precio, descripcion);
    }

    @Override
    public double getPrecio() {
        return calcularPrecio();
    }

    @Override
    public Double calcularPrecio() {
        return this.precio;
    }

    @Override
    public String getTipo() {
        return "Ropa";
    }
}
