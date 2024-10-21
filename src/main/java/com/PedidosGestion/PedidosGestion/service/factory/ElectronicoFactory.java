package com.PedidosGestion.PedidosGestion.service.factory;

import com.PedidosGestion.PedidosGestion.models.Electronico;
import com.PedidosGestion.PedidosGestion.models.Producto;

public class ElectronicoFactory implements IProductoFactory{

    @Override
    public Producto createProducto(Long id, String nombre, double precio, String descripcion) {
        return new Electronico(id, nombre, precio, descripcion);
    }
}
