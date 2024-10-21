package com.PedidosGestion.PedidosGestion.service;


import com.PedidosGestion.PedidosGestion.dto.ProductoDTO;
import com.PedidosGestion.PedidosGestion.models.Pedido;
import com.PedidosGestion.PedidosGestion.models.PedidoBuilder;
import com.PedidosGestion.PedidosGestion.models.Producto;
import com.PedidosGestion.PedidosGestion.repository.PedidoRepository;
import com.PedidosGestion.PedidosGestion.repository.ProductoRepository;
import com.PedidosGestion.PedidosGestion.service.factory.IProductoFactory;
import com.PedidosGestion.PedidosGestion.service.factory.ProductoFactorySingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Pedido crearPedido() {
        Pedido nuevoPedido = new PedidoBuilder().build();
        return pedidoRepository.save(nuevoPedido);
    }

    public Pedido agregarProducto(Long pedidoId, Long id) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(pedidoId);
        if (!pedidoOpt.isPresent()) {
            throw new RuntimeException("Pedido no encontrado.");
        }

        Pedido pedido = pedidoOpt.get();
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado."));
        pedido.agregarProducto(producto);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido clonarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado."));
        Pedido pedido1 = pedido.deepClone();
        return pedidoRepository.save(pedido1);
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void pagarPedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).orElseThrow(() -> new RuntimeException("Pedido no encontrado."));
        System.out.println("Pedido con ID " + pedidoId + " ha sido pagado.");
    }

    public void eliminarPedido(Long pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }
}


