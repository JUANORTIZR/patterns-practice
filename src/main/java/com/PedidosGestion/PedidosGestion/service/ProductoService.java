package com.PedidosGestion.PedidosGestion.service;

import com.PedidosGestion.PedidosGestion.dto.ProductoDTO;
import com.PedidosGestion.PedidosGestion.models.Producto;
import com.PedidosGestion.PedidosGestion.repository.ProductoRepository;
import com.PedidosGestion.PedidosGestion.service.factory.IProductoFactory;
import com.PedidosGestion.PedidosGestion.service.factory.ProductoFactorySingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto productoDTO) {
        IProductoFactory productoFactory = ProductoFactorySingleton.getInstance().crearProducto(productoDTO.getTipo());
        Producto producto = productoFactory.createProducto(productoDTO.getId(), productoDTO.getNombre(), productoDTO.getPrecio(), productoDTO.getDescripcion());
        return productoRepository.save(producto);
    }
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
