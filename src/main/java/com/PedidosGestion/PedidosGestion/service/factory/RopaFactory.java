package com.PedidosGestion.PedidosGestion.service.factory;

import com.PedidosGestion.PedidosGestion.models.Producto;
import com.PedidosGestion.PedidosGestion.models.Ropa;

public class RopaFactory implements IProductoFactory{
    @Override
    public Producto createProducto(Long id, String nombre, double precio, String descripcion) {
        return new Ropa(id, nombre, precio, descripcion);
    }
}
