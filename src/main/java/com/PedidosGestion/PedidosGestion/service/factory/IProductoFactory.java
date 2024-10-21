package com.PedidosGestion.PedidosGestion.service.factory;

import com.PedidosGestion.PedidosGestion.models.Producto;

public interface IProductoFactory {
    Producto createProducto(Long id, String nombre, double precio, String descripcion);
}
