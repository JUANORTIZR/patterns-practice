package com.PedidosGestion.PedidosGestion.repository;
import com.PedidosGestion.PedidosGestion.models.Pedido;
import com.PedidosGestion.PedidosGestion.models.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private List<Producto> productos = new ArrayList<>();
    private long currentId = 1;

    public Producto save(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(currentId++);
        } else {
            deleteById(producto.getId());
        }
        productos.add(producto);
        return producto;
    }


    public List<Producto> findAll() {
        return productos;
    }


    public Optional<Producto> findById(Long id) {
        return productos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }


    public void deleteById(Long id) {
        productos.removeIf(p -> p.getId().equals(id));
    }


    public void deleteAll() {
        productos.clear();
    }
}
