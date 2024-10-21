package com.PedidosGestion.PedidosGestion.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private double precio;
    private String descripcion;
    private String tipo;
}

