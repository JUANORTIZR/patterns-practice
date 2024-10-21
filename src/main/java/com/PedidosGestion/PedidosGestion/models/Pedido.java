package com.PedidosGestion.PedidosGestion.models;

import com.PedidosGestion.PedidosGestion.prototype.Copiable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class Pedido implements Copiable<Pedido> {
    private Long id;
    private List<Producto> productos = new ArrayList<>();
    private double total;

    public Pedido() {}

    public Pedido(Long id, List<Producto> productos, double total) {
        this.id = id;
        this.productos = productos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public Pedido copiar() {
        List<Producto> copiaProductos = new ArrayList<>();
        for (Producto producto : this.productos) {
            copiaProductos.add(producto.copiar());
        }
        return new Pedido(this.id, copiaProductos, this.total);
    }

    @Override
    public Pedido deepClone() {
        List<Producto> copiaProductos = new ArrayList<>();
        for (Producto producto : this.productos) {
            copiaProductos.add(producto.deepClone());
        }
        return new Pedido(null, copiaProductos, this.total);
    }
}
