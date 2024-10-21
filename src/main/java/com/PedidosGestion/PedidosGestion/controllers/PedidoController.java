package com.PedidosGestion.PedidosGestion.controllers;

import com.PedidosGestion.PedidosGestion.dto.ProductoDTO;
import com.PedidosGestion.PedidosGestion.models.Pedido;
import com.PedidosGestion.PedidosGestion.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// PedidoController.java
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<Pedido> registrarPedido() {
        Pedido nuevoPedido = pedidoService.crearPedido();
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/agregarProducto/producto/{idProducto}")
    public ResponseEntity<Pedido> agregarProducto(@PathVariable Long id, @PathVariable Long idProducto) {
        Pedido pedidoActualizado = pedidoService.agregarProducto(id, idProducto);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerTodos() {
        return ResponseEntity.ok(pedidoService.obtenerTodos());
    }

    @PostMapping("/clone/{id}")
    public ResponseEntity<Pedido> clonarPedido(@PathVariable Long id) {
        Pedido pedidoClonado = pedidoService.clonarPedido(id);
        if (pedidoClonado != null) {
            return new ResponseEntity<>(pedidoClonado, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        return pedidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<String> pagarPedido(@PathVariable Long id) {
        pedidoService.pagarPedido(id);
        return ResponseEntity.ok("Pedido pagado correctamente.");
    }
}