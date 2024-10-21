package com.PedidosGestion.PedidosGestion.controllers;

import com.PedidosGestion.PedidosGestion.dto.ProductoDTO;
import com.PedidosGestion.PedidosGestion.models.Pedido;
import com.PedidosGestion.PedidosGestion.models.Producto;
import com.PedidosGestion.PedidosGestion.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("")
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto) {
        Producto productoRespone = productoService.crearProducto(producto);
        return ResponseEntity.ok(productoRespone);
    }

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }
}
