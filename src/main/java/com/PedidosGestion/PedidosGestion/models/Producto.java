package com.PedidosGestion.PedidosGestion.models;

import com.PedidosGestion.PedidosGestion.prototype.Copiable;
import com.PedidosGestion.PedidosGestion.service.factory.IProducto;
import lombok.Data;

@Data
public class Producto  implements Copiable<Producto> {
    protected Long id;
    protected String nombre;
    protected double precio;
    protected String descripcion;
    private String tipo;

    public Producto(Long id, String nombre, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public Producto copiar() {
        return new Producto(this.id, this.nombre, this.precio, this.descripcion);
    }
    @Override
    public Producto deepClone() {
        return this.copiar();
    }


}

