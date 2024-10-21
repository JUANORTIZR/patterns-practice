package com.PedidosGestion.PedidosGestion.models;

public class PedidoBuilder {
    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public PedidoBuilder agregarProducto(Producto producto) {
        pedido.agregarProducto(producto);
        return this;
    }

    public Pedido build() {
        return pedido;
    }
}
